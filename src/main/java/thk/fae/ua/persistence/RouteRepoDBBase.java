package thk.fae.ua.persistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import thk.fae.ua.core.domain.entities.Route;

public interface RouteRepoDBBase extends CrudRepository<Route, UUID> {
}
