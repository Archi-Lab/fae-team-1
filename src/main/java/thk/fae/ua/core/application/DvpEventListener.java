package thk.fae.ua.core.application;


import thk.fae.ua.core.domain.events.DvpUpdateEvent;

public interface DvpEventListener {
    void onDvpUpdate(DvpUpdateEvent event);
}
