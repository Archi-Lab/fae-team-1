package thk.fae.urd.route.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import thk.fae.urd.route.repository.RouteRepository;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RouteTest {

    @Autowired
    private RouteRepository repo;

    @Test
    public void testRouteLocation() {
        Location l = new Location();

        Route r = new Route(l);
        r.setName("test");

        r = this.repo.save(r);
        Long id = r.getId();

        Optional<Route> savedRoute = this.repo.findById(id);
        assertNotNull(savedRoute.get());
        assertEquals("test", savedRoute.get().getName());

        assertNotNull(savedRoute.get().getLocation());
    }
}

