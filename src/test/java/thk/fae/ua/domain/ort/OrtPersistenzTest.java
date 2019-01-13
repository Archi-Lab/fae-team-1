package thk.fae.ua.domain.ort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import thk.fae.ua.domain.LocationTestHelper;
import thk.fae.ua.domain.demenziellveraenderteperson.DemenziellVeraendertePersonTestHelper;
import thk.fae.ua.domain.Location;
import thk.fae.ua.domain.demenziellveraenderteperson.DemenziellVeraendertePerson;
import thk.fae.ua.domain.demenziellveraenderteperson.DemenziellVeraendertePersonRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrtPersistenzTest {

	@Autowired
	private OrtRepo ortRepo;

	@Autowired
	private DemenziellVeraendertePersonRepo dvpRepo;

	private DemenziellVeraendertePerson dvp;

	@Before
	public void before() {
		this.dvp = DemenziellVeraendertePersonTestHelper.createDummyDemenziellVeraendertePerson();
		this.dvpRepo.create(this.dvp);
	}

	@Test
	public void testOKLocation() {
		final Ort ort = OrtTestHelper.createDummyOrtWithLocation(this.dvp);
		assertNull(ort.getBereich());

		final Ort savedOrt = this.ortRepo.create(ort);
		assertEquals(ort, savedOrt);
		assertNull(savedOrt.getBereich());

		final Ort readOrt = this.ortRepo.findById(ort.getId()).get();
		assertEquals(ort, readOrt);
		assertNull(readOrt.getBereich());
	}

	@Test
	public void testOKGeofence() {
		final Ort ort = OrtTestHelper.createDummyOrtWithGeofence(this.dvp);
		assertNull(ort.getLocation());

		final Ort savedOrt = this.ortRepo.create(ort);
		assertEquals(ort, savedOrt);
		assertNull(savedOrt.getLocation());

		final Ort readOrt = this.ortRepo.findById(ort.getId()).get();
		assertEquals(ort, readOrt);
		assertNull(readOrt.getLocation());
	}

	@Test
	public void testNotOkOrtWithLocationAndGeofence() {
		final Ort ort = OrtTestHelper.createDummyOrtWithGeofence(this.dvp);
		assertNotNull(ort.getBereich());
		assertThrows(IllegalArgumentException.class,
				() -> ort.setLocation(LocationTestHelper.createDummyRandomLocation()));
	}

	@Test
	public void testNotOkOrtWithGeofenceAndLocation() {
		final Ort ort = OrtTestHelper.createDummyOrtWithLocation(this.dvp);
		assertNotNull(ort.getLocation());

		final List<Location> list = new ArrayList<>();
		list.add(LocationTestHelper.createDummyRandomLocation());
		assertThrows(IllegalArgumentException.class, () -> ort.setBereich(list));
	}

	@Test
	public void testNotOkOrtWithGeofenceUnder3Locations() {
		final Ort ort = new Ort();
		final List<Location> list = new ArrayList<>();
		list.add(LocationTestHelper.createDummyRandomLocation());
		ort.setBereich(list);
		assertNull(ort.getLocation());

		assertThrows(TransactionSystemException.class, () -> this.ortRepo.create(ort));

		final Optional<Ort> readOrt = this.ortRepo.findById(ort.getId());
		assertFalse(readOrt.isPresent());
	}

}
