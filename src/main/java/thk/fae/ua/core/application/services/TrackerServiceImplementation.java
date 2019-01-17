package thk.fae.ua.core.application.services;

import thk.fae.ua.core.application.interfaces.TrackerService;
import thk.fae.ua.core.domain.events.TrackerUpdateEvent;

public class TrackerServiceImplementation implements TrackerService {

    @Override
    public void handleTrackerUpdate(TrackerUpdateEvent event) {
        // IS THERE DVP FOR TRACKER ?
        // (IF SO CHECK FOR ANOMALIES) -> give to other service for checking
    }
}
