package thk.fae.ua.core.domain.events;

import lombok.Getter;
import lombok.Setter;
import thk.fae.ua.core.domain.common.EntityUUID4;
import thk.fae.ua.core.domain.valueobjects.Tracker;
import thk.fae.ua.core.domain.valueobjects.Lokation;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.time.Instant;

@Entity
public class TrackerUpdateEvent extends EntityUUID4 {

    @Getter
    @Setter
    @Embedded
    private Tracker tracker;

    @Getter
    @Setter
    @Embedded
    private Lokation lokation;

    @Getter
    @Setter
    private Instant timestamp;
}
