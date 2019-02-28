package thk.fae.ua.presentation.web.dvp;

import java.util.UUID;

public class DvpNotFoundException extends RuntimeException {
    public DvpNotFoundException(UUID id) {
        super("Es konnte keine dementiell veränderte Person mit der UUID" + id + "gefunden werden!");
    }
}
