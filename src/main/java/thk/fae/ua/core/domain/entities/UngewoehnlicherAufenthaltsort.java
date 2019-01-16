package thk.fae.ua.core.domain.entities;

import thk.fae.ua.core.domain.common.EntityUUID4;
import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;
import thk.fae.ua.core.domain.valueobjects.Lokation;

import java.time.Instant;

public class UngewoehnlicherAufenthaltsort extends EntityUUID4 {
    private DemenziellVeraendertePerson demenziellVeraendertePerson;
    private Lokation lokation;
    private Instant timestamp;
}
