package thk.fae.ua.presentation.web.ort;

import java.util.UUID;

public class OrtNotFoundException extends RuntimeException {
    OrtNotFoundException(UUID id) {
        super("Es konnte kein Ort mit der UUID" + id + "gefunden werden!");
    }
}
