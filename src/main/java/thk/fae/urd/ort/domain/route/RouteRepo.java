package thk.fae.urd.ort.domain.route;

import java.util.Optional;
import java.util.UUID;

public interface RouteRepo {
	Optional<Route> findById(UUID id);

	Route create(final Route route);
}
