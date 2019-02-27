package thk.fae.ua.core.domain.events;

import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;
import thk.fae.ua.core.domain.valueobjects.Lokation;

import java.time.Instant;

public class UngewoehnlicherAufenthaltsortEvent {
    public DemenziellVeraendertePerson dvp;
    public Instant timestamp;
    public Lokation lokation;
}
