package thk.fae.ua.core.domain.valueobjects;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public class Tracker {

    @Getter
    private UUID trackerId;

    public Tracker() {
    }

    public Tracker(UUID trackerId) {
        this.trackerId = trackerId;
    }
}
