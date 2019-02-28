package thk.fae.ua.presentation.web.route;

import java.util.UUID;

public class RouteNotFoundException extends RuntimeException {
    RouteNotFoundException(UUID id) {
        super("Es konnte keine Route mit der UUID" + id + "gefunden werden!");
    }
}
