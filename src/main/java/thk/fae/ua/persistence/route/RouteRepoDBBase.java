package thk.fae.ua.persistence.route;

import org.springframework.data.repository.CrudRepository;
import thk.fae.ua.core.domain.entities.Route;

import java.util.List;
import java.util.UUID;

public interface RouteRepoDBBase extends CrudRepository<Route, UUID> {
    Iterable<Route> findAllByDemenziellVeraendertePerson_Id(UUID dvpId);
}
