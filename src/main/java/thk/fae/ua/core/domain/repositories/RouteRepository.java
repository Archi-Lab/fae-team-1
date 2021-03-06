package thk.fae.ua.core.domain.repositories;

import thk.fae.ua.core.domain.entities.Route;

import java.util.Optional;
import java.util.UUID;

public interface RouteRepository {
	Optional<Route> findById(UUID id);
	Iterable<Route> findByDvpId(UUID dvpId);
	Route save(final Route route);
	void deleteById(UUID id);
	boolean existsById(UUID id);
}
