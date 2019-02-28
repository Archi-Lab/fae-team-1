package thk.fae.ua.infrastructure.kafka.models.uaevent;

import thk.fae.ua.core.domain.valueobjects.Lokation;

import java.time.Instant;
import java.util.UUID;

public class UAEventMessageModel {

    public Long version;

    public UUID dvpId;

    public Instant zeitpunk;

    public Lokation standort;

}
