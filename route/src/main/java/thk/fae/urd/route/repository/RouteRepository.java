package thk.fae.urd.route.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thk.fae.urd.route.model.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {
}
