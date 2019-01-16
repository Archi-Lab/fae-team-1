package thk.fae.ua.core.application;

import thk.fae.ua.core.domain.events.TrackerUpdateEvent;

public interface TrackerEventListener {
    void onTrackerUpdate(TrackerUpdateEvent event);

}
