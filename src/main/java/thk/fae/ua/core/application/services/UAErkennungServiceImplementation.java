package thk.fae.ua.core.application.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import thk.fae.ua.core.application.interfaces.UAErkennungService;
import thk.fae.ua.core.application.interfaces.UAEventPublikationService;
import thk.fae.ua.core.domain.events.UngewoehnlicherAufenthaltsortEvent;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UAErkennungServiceImplementation implements UAErkennungService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UAErkennungService.class);

    private final DemenziellVeraendertePersonRepository dvpRepository;
    private final UAEventPublikationService uaService;

    @Override
    public void aufenthaltsortPruefen(UUID dvpId) {

        // TODO CHECK IF DVP IS "OUT OF BOUNDS"

        // TODO CHECK IF DVP IS "ON ROUTE"

        // TODO CHECK IF DVP IS IN AREA

        uaService.publishUAEvent(new UngewoehnlicherAufenthaltsortEvent());
    }

    private void istDvpAufRoute() {
        // TODO com.google.maps.android.PolyUtil
    }
}
