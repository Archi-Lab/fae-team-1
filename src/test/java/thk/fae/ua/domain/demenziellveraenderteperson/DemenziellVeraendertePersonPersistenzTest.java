package thk.fae.ua.domain.demenziellveraenderteperson;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import thk.fae.ua.domain.ort.OrtRepo;
import thk.fae.ua.domain.ort.OrtTestHelper;
import thk.fae.ua.domain.route.RouteRepo;
import thk.fae.ua.domain.route.RouteTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemenziellVeraendertePersonPersistenzTest {

	@Autowired
	private DemenziellVeraendertePersonRepo dvpRepo;

	@Autowired
	private OrtRepo ortRepo;

	@Autowired
	private RouteRepo routeRepo;

	@Test
	public void testOK1() {
		final DemenziellVeraendertePerson dvp = DemenziellVeraendertePersonTestHelper
				.createDummyDemenziellVeraendertePerson();
		assertNotNull(dvp.getId());
		assertNull(dvp.getOrte());
		assertNull(dvp.getRouten());

		final DemenziellVeraendertePerson savedDvp = this.dvpRepo.create(dvp);
		assertEquals(dvp, savedDvp);

		final DemenziellVeraendertePerson readDvp = this.dvpRepo.create(dvp);
		assertEquals(dvp, readDvp);
	}

	@Test
	public void testOK2() {
		final DemenziellVeraendertePerson dvp = DemenziellVeraendertePersonTestHelper
				.createDummyDemenziellVeraendertePerson();
		assertNotNull(dvp.getId());

		DemenziellVeraendertePerson savedDvp = this.dvpRepo.create(dvp);
		assertEquals(dvp, savedDvp);

		dvp.addOrt(this.ortRepo.create(OrtTestHelper.createDummyOrtWithGeofence(dvp)));
		dvp.addOrt(this.ortRepo.create(OrtTestHelper.createDummyOrtWithLocation(dvp)));
		dvp.addRoute(this.routeRepo.create(RouteTestHelper.createDummyRoute(dvp)));
		savedDvp = this.dvpRepo.create(dvp);
		assertEquals(dvp, savedDvp);

		final DemenziellVeraendertePerson readDvp = this.dvpRepo.create(dvp);
		assertEquals(dvp, readDvp);
	}

}
