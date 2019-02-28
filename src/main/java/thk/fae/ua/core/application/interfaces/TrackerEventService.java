package thk.fae.ua.core.application.interfaces;

import thk.fae.ua.core.domain.events.TrackerUpdateEvent;

public interface TrackerEventService {
    void handleTrackerUpdate(TrackerUpdateEvent event);
}
