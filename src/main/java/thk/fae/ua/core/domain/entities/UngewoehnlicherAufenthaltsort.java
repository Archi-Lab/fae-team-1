package thk.fae.ua.core.domain.entities;

import thk.fae.ua.core.domain.common.EntityUUID4;
import thk.fae.ua.core.domain.valueobjects.Lokation;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.time.Instant;

@Entity
public class UngewoehnlicherAufenthaltsort extends EntityUUID4 {
    @Embedded
    private DemenziellVeraendertePerson demenziellVeraendertePerson;
    @Embedded
    private Lokation lokation;
    @Embedded
    private Instant timestamp;
}
