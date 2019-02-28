package thk.fae.ua.core.application.interfaces;

import thk.fae.ua.core.domain.events.UngewoehnlicherAufenthaltsortEvent;

public interface UAEventService {
    void publishUAEvent(UngewoehnlicherAufenthaltsortEvent event);
}
