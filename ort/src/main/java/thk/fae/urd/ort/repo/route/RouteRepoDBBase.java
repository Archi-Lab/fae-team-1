package thk.fae.urd.ort.repo.route;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import thk.fae.urd.ort.domain.route.Route;

public interface RouteRepoDBBase extends CrudRepository<Route, UUID> {
}
