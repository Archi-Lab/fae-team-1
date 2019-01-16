package thk.fae.ua.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import thk.fae.ua.core.domain.entities.Route;
import thk.fae.ua.core.domain.repositories.RouteRepo;

@Repository
public class RouteRepoDBImpl implements RouteRepo {

	private final RouteRepoDBBase dbBase;

	public RouteRepoDBImpl(final RouteRepoDBBase dbBase) {
		this.dbBase = dbBase;
	}

	@Override
	public Optional<Route> findById(final UUID id) {
		return this.dbBase.findById(id);
	}

	@Override
	public Route create(final Route route) {
		return this.dbBase.save(route);
	}
}
