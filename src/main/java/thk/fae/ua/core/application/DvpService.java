package thk.fae.ua.core.application;

public interface DvpService {
    void addUpdateListener(DvpEventListener listener);
    void removeUpdateListener(DvpEventListener listener);
}
