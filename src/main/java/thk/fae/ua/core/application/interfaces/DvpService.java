package thk.fae.ua.core.application.interfaces;

import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;

public interface DvpService {
    void handleDvpUpdate(DemenziellVeraendertePerson dvp);
}
