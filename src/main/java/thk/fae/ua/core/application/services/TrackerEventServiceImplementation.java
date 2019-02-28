package thk.fae.ua.core.application.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import thk.fae.ua.core.application.interfaces.TrackerEventService;
import thk.fae.ua.core.application.interfaces.UAErkennungService;
import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;
import thk.fae.ua.core.domain.events.TrackerUpdateEvent;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrackerEventServiceImplementation implements TrackerEventService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackerEventService.class);

    private final DemenziellVeraendertePersonRepository dvpRepository;
    private final UAErkennungService uaService;

    @Override
    public void handleTrackerUpdate(TrackerUpdateEvent event) {

        UUID trackerId = event.getTracker().getTrackerId();

        dvpRepository.findByTrackerId(trackerId).ifPresentOrElse(
                dvp -> {
                    LOGGER.info("Received tracker location update from: {} -> DVP associated with the tracker: {}", trackerId, dvp.toString());
                    dvpLokationSpeichern(dvp, event);
                    uaService.aufenthaltsortPruefen(dvp.getId());
                },
                () -> LOGGER.info("Received tracker location update from: {} -> There is no DVP associated with the tracker!", trackerId)
        );
    }

    private void dvpLokationSpeichern(DemenziellVeraendertePerson dvp, TrackerUpdateEvent trackerEvent) {
        dvp.setLetzterBekannterAufenthaltsort(trackerEvent);
        dvpRepository.save(dvp);
    }

}
