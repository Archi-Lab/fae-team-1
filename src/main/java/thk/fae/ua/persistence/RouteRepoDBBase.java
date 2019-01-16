package thk.fae.ua.persistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thk.fae.ua.core.domain.entities.Route;

@RepositoryRestResource(path = "routen", collectionResourceRel = "routen", itemResourceRel = "route")
public interface RouteRepoDBBase extends CrudRepository<Route, UUID> {
}
