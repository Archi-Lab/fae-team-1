package thk.fae.urd.ort.repo.route;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import thk.fae.urd.ort.domain.route.Route;
import thk.fae.urd.ort.domain.route.RouteRepo;

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
