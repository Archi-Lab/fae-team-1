package thk.fae.ua.core.domain.events;

import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;

import java.time.Instant;

public class DvpUpdateEvent {
    DemenziellVeraendertePerson dvp;
    Instant timestamp;
}
