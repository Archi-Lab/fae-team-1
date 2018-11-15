package thk.fae.urd.ort.repo.route;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thk.fae.urd.ort.domain.route.Route;

@RepositoryRestResource(path = "routen", collectionResourceRel = "routen", itemResourceRel = "route")
public interface RouteRepoDBBase extends CrudRepository<Route, UUID> {
}
