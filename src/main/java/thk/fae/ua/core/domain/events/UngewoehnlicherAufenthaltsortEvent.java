package thk.fae.ua.core.domain.events;

import lombok.Getter;
import lombok.Setter;
import thk.fae.ua.core.domain.common.EntityUUID4;
import thk.fae.ua.core.domain.valueobjects.Lokation;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.time.Instant;
import java.util.UUID;

@Entity
public class UngewoehnlicherAufenthaltsortEvent extends EntityUUID4 {

    @Getter
    @Setter
    private UUID dvpId;

    @Getter
    @Setter
    private Instant timestamp;


    @Getter
    @Setter
    @Embedded
    private Lokation lokation;

    @Getter
    @Setter
    private boolean publiziert;
}
