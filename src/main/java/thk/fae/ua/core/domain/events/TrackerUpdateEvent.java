package thk.fae.ua.core.domain.events;

import thk.fae.ua.core.domain.entities.Tracker;
import thk.fae.ua.core.domain.valueobjects.Lokation;

import java.time.Instant;

public class TrackerUpdateEvent {
    Tracker tracker;
    Lokation lokation;
    Instant timestamp;
}
