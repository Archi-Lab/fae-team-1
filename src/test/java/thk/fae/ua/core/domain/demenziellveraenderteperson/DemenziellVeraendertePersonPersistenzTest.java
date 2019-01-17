package thk.fae.ua.core.domain.demenziellveraenderteperson;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;
import thk.fae.ua.core.domain.repositories.OrtRepository;
import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;
import thk.fae.ua.core.domain.ort.OrtTestHelper;
import thk.fae.ua.core.domain.repositories.RouteRepository;
import thk.fae.ua.core.domain.route.RouteTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemenziellVeraendertePersonPersistenzTest {

	@Autowired
	private DemenziellVeraendertePersonRepository dvpRepo;

	@Autowired
	private OrtRepository ortRepo;

	@Autowired
	private RouteRepository routeRepo;

	@Test
	public void testOK1() {
		final DemenziellVeraendertePerson dvp = DemenziellVeraendertePersonTestHelper
				.createDummyDemenziellVeraendertePerson();
		assertNotNull(dvp.getId());
		assertNull(dvp.getOrte());
		assertNull(dvp.getRouten());

		final DemenziellVeraendertePerson savedDvp = this.dvpRepo.save(dvp);
		assertEquals(dvp, savedDvp);

		final DemenziellVeraendertePerson readDvp = this.dvpRepo.save(dvp);
		assertEquals(dvp, readDvp);
	}

	@Test
	public void testOK2() {
		final DemenziellVeraendertePerson dvp = DemenziellVeraendertePersonTestHelper
				.createDummyDemenziellVeraendertePerson();
		assertNotNull(dvp.getId());

		DemenziellVeraendertePerson savedDvp = this.dvpRepo.save(dvp);
		assertEquals(dvp, savedDvp);

		dvp.addOrt(this.ortRepo.save(OrtTestHelper.createDummyOrtWithGeofence(dvp)));
		dvp.addOrt(this.ortRepo.save(OrtTestHelper.createDummyOrtWithLocation(dvp)));
		dvp.addRoute(this.routeRepo.save(RouteTestHelper.createDummyRoute(dvp)));
		savedDvp = this.dvpRepo.save(dvp);
		assertEquals(dvp, savedDvp);

		final DemenziellVeraendertePerson readDvp = this.dvpRepo.save(dvp);
		assertEquals(dvp, readDvp);
	}

}
