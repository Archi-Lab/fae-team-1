package thk.fae.ua.core.application.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import thk.fae.ua.core.application.interfaces.TrackerService;
import thk.fae.ua.core.domain.events.TrackerUpdateEvent;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;

@Service
@RequiredArgsConstructor
public class TrackerServiceImplementation implements TrackerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackerService.class);

    private final DemenziellVeraendertePersonRepository dvpRepository;

    @Override
    public void handleTrackerUpdate(TrackerUpdateEvent event) {
        LOGGER.info("RECEIVED TRACKER UPDATE FROM {}", event.getTracker().getTrackerId());

        // TODO CHECK IF THERE IS AN DVP ASSOCIATED WITH THE TRACKER

        // TODO SET DVP LAST KNOWN LOCATION TO TRACKER LOCATION

        // TODO CHECK IF DVP IS "OUT OF BOUNDS"

    }
}
