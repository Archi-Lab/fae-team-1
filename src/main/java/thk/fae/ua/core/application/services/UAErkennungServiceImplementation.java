package thk.fae.ua.core.application.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import thk.fae.ua.core.application.interfaces.UAErkennungService;
import thk.fae.ua.core.application.interfaces.UAEventService;
import thk.fae.ua.core.util.google.LatLng;
import thk.fae.ua.core.util.google.PolyUtil;
import static thk.fae.ua.core.util.google.SphericalUtil.computeDistanceBetween;

import thk.fae.ua.core.domain.entities.Ort;
import thk.fae.ua.core.domain.entities.Route;
import thk.fae.ua.core.domain.events.UngewoehnlicherAufenthaltsortEvent;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;
import thk.fae.ua.core.domain.valueobjects.Lokation;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UAErkennungServiceImplementation implements UAErkennungService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UAErkennungService.class);

    private final DemenziellVeraendertePersonRepository dvpRepository;
    private final UAEventService uaService;

    @Override
    public void aufenthaltsortPruefen(UUID dvpId) {

        dvpRepository.findById(dvpId).ifPresent(dvp -> {
            if((dvp.getOrte().size() + dvp.getRouten().size()) > 0) {

                Lokation aufenthaltsort = dvp.getLetzterBekannterAufenthaltsort().getLokation();
                boolean dvpIstAnUA = true;

                for(Route route : dvp.getRouten()) {
                    if (dvpBefindetSichAufRoute(aufenthaltsort, route)) {
                        LOGGER.info("DVP {} ist auf bekannter Route", dvp.toString());
                        dvpIstAnUA = false;
                        break;
                    }
                }

                if (dvpIstAnUA) {
                    for(Ort ort : dvp.getOrte()) {
                        if (dvpBefindetSichAnOrt(aufenthaltsort, ort)) {
                            LOGGER.info("DVP {} ist an bekanntem Ort", dvp.toString());
                            dvpIstAnUA = false;
                            break;
                        }
                    }
                }

                if(dvpIstAnUA) {
                    LOGGER.info("DVP {} befindet sich an einem unbekanntem Aufenthaltsort!", dvp.toString());
                    UngewoehnlicherAufenthaltsortEvent uaevent = new UngewoehnlicherAufenthaltsortEvent();
                    uaevent.dvp = dvp;
                    uaevent.lokation = aufenthaltsort;
                    uaevent.timestamp = Instant.now();
                    uaService.publishUAEvent(uaevent);
                }

            } else {
                LOGGER.info("Keine Checks für DVP {} vorhanden", dvp.toString());
            }
        });
    }

    private boolean dvpBefindetSichAufRoute(Lokation standort, Route route) {
        List<LatLng> polyline = LokationenZuLatLngs(route.getLokationen());
        LatLng location = LokationZuLatLng(standort);
        return PolyUtil.isLocationOnPath(location, polyline, true, 5);
    }

    private boolean dvpBefindetSichAnOrt(Lokation standort, Ort ort) {
        LatLng location = LokationZuLatLng(standort);
        if(ort.getLokation() == null) {
            LatLng ortLocation = LokationZuLatLng(ort.getLokation());
            double distance = computeDistanceBetween(ortLocation, location);
            return distance <= 15;
        } else {
            List<LatLng> polygon = LokationenZuLatLngs(ort.getBereich());
            return PolyUtil.containsLocation(location, polygon, true);
        }
    }

    private LatLng LokationZuLatLng(Lokation lokation) {
        return new LatLng(lokation.getLatitude(), lokation.getLongitude());
    }

    private List<LatLng> LokationenZuLatLngs(List<Lokation> lokationen) {
        return lokationen.stream().map(lokation -> LokationZuLatLng(lokation)).collect(Collectors.toList());
    }
}
