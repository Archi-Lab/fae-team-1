package thk.fae.ua.core.application.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import thk.fae.ua.core.application.interfaces.TrackerService;
import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;
import thk.fae.ua.core.domain.events.TrackerUpdateEvent;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;
import thk.fae.ua.core.domain.valueobjects.Tracker;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrackerServiceImplementation implements TrackerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackerService.class);

    private final DemenziellVeraendertePersonRepository dvpRepository;

    @Override
    public void handleTrackerUpdate(TrackerUpdateEvent event) {

        UUID trackerId = event.getTracker().getTrackerId();

        dvpRepository.findByTrackerId(trackerId).ifPresentOrElse(
                dvp -> LOGGER.info("Received tracker location update from: {} -> DVP associated with the tracker: {}", trackerId, dvp.toString()),
                () -> LOGGER.info("Received tracker location update from: {} -> There is no DVP associated with the tracker!", trackerId)
        );

        // TODO SET DVP LAST KNOWN LOCATION TO TRACKER LOCATION

        // TODO CHECK IF DVP IS "OUT OF BOUNDS"

    }

    private void updateLastLocation(DemenziellVeraendertePerson dvp, Tracker tracker) {

    }
}
