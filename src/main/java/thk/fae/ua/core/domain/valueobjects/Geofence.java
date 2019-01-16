package thk.fae.ua.core.domain.valueobjects;

import thk.fae.ua.core.domain.common.EntityUUID4;

import java.util.List;

public class Geofence extends EntityUUID4 {
    private List<Lokation> lokationen;

    public Geofence(List<Lokation> lokationen) {
        if(lokationen.size() < 3) {
            throw new IllegalArgumentException("Ein Geofence muss aus mindestens 3 Lokationen bestehen!");
        }
        this.lokationen = lokationen;
    }
}
