package thk.fae.ua.core.application.interfaces;

import thk.fae.ua.core.domain.events.UngewoehnlicherAufenthaltsortEvent;

public interface UAEventPublikationService {
    void publishUAEvent(UngewoehnlicherAufenthaltsortEvent event);
}
