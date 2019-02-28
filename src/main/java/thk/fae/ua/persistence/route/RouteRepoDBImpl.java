package thk.fae.ua.persistence.route;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import thk.fae.ua.core.domain.entities.Route;
import thk.fae.ua.core.domain.repositories.RouteRepository;

@Repository
public class RouteRepoDBImpl implements RouteRepository {

	private final RouteRepoDBBase dbBase;

	public RouteRepoDBImpl(final RouteRepoDBBase dbBase) {
		this.dbBase = dbBase;
	}

	@Override
	public Optional<Route> findById(final UUID id) {
		return this.dbBase.findById(id);
	}

	@Override
	public Iterable<Route> findByDvpId(UUID dvpId) {
		return this.dbBase.findAllByDemenziellVeraendertePerson_Id(dvpId);
	}

	@Override
	public Route save(final Route route) {
		return this.dbBase.save(route);
	}

	@Override
	public void deleteById(UUID id) { this.dbBase.deleteById(id); }

	@Override
	public boolean existsById(UUID id) { return this.dbBase.existsById(id); }
}
