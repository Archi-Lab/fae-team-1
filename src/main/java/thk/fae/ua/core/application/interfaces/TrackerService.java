package thk.fae.ua.core.application.interfaces;

import thk.fae.ua.core.domain.events.TrackerUpdateEvent;

public interface TrackerService {
    void handleTrackerUpdate(TrackerUpdateEvent event);
}
