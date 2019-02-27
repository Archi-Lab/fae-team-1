package thk.fae.ua.core.application.interfaces;

import thk.fae.ua.core.domain.events.UngewoehnlicherAufenthaltsortEvent;

public interface UAEventPublisherService {
    void publishUAEvent(UngewoehnlicherAufenthaltsortEvent event);
}
