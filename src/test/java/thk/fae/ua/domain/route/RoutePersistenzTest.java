package thk.fae.ua.domain.route;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import thk.fae.ua.domain.demenziellveraenderteperson.DemenziellVeraendertePersonTestHelper;
import thk.fae.ua.domain.demenziellveraenderteperson.DemenziellVeraendertePerson;
import thk.fae.ua.domain.demenziellveraenderteperson.DemenziellVeraendertePersonRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoutePersistenzTest {

	@Autowired
	private RouteRepo routeRepo;

	@Autowired
	private DemenziellVeraendertePersonRepo dvpRepo;

	private DemenziellVeraendertePerson dvp;

	@Before
	public void before() {
		this.dvp = DemenziellVeraendertePersonTestHelper.createDummyDemenziellVeraendertePerson();
		this.dvpRepo.create(this.dvp);
	}

	@Test
	public void testOK() {
		final Route route = RouteTestHelper.createDummyRoute(this.dvp);
		assertNotNull(route.getDemenziellVeraendertePerson());
		assertNotNull(route.getName());

		final Route savedRoute = this.routeRepo.create(route);
		assertEquals(route, savedRoute);

		final Route readRoute = this.routeRepo.findById(route.getId()).get();
		assertEquals(route, readRoute);
	}
}
