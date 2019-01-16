package thk.fae.ua.core.application;

public interface TrackerService {
    void addUpdateListener(DvpEventListener listener);
    void removeUpdateListener(DvpEventListener listener);
}
