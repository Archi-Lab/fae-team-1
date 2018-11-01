package thk.fae.urd.ort.domain.ort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import thk.fae.urd.ort.domain.KontaktdatenTestHelper;
import thk.fae.urd.ort.domain.LocationTestHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrtPersistenzTest {

	@Autowired
	private OrtRepo repo;

	@Test
	public void testOKLocation() {
		final Ort ort = OrtTestHelper.createDummyOrtWithLocation();
		assertNull(ort.getGeofence());

		final Ort savedOrt = this.repo.create(ort);
		assertEquals(ort, savedOrt);
		assertEquals(ort.getLocation(), savedOrt.getLocation());
		assertNull(savedOrt.getGeofence());

		final Ort readOrt = this.repo.findById(ort.getId()).get();
		assertEquals(ort, readOrt);
		assertEquals(ort.getLocation(), readOrt.getLocation());
		assertNull(readOrt.getGeofence());
	}

	@Test
	public void testOKGeofence() {
		final Ort ort = OrtTestHelper.createDummyOrtWithGeofence();
		assertNull(ort.getLocation());

		final Ort savedOrt = this.repo.create(ort);
		assertEquals(ort, savedOrt);
		assertEquals(ort.getGeofence(), savedOrt.getGeofence());
		assertNull(savedOrt.getLocation());

		final Ort readOrt = this.repo.findById(ort.getId()).get();
		assertEquals(ort, readOrt);
		assertEquals(ort.getGeofence(), readOrt.getGeofence());
		assertNull(readOrt.getLocation());
	}

	@Test
	public void testOKKontaktdaten() {
		final Ort ort = OrtTestHelper.createDummyOrtWithLocation();
		ort.setKontaktdaten(KontaktdatenTestHelper.createDummyKontaktdaten());

		final Ort savedOrt = this.repo.create(ort);
		assertEquals(ort, savedOrt);
		assertEquals(ort.getKontaktdaten(), savedOrt.getKontaktdaten());

		final Ort readOrt = this.repo.findById(ort.getId()).get();
		assertEquals(ort, readOrt);
		assertEquals(ort.getKontaktdaten(), readOrt.getKontaktdaten());
	}

	@Test
	public void testNotOkOrtWithLocationAndGeofence() {
		final Ort ort = OrtTestHelper.createDummyOrtWithGeofence();
		assertNotNull(ort.getGeofence());
		assertThrows(IllegalArgumentException.class, () -> ort.setLocation(LocationTestHelper.createDummyLocation()),
				"Ein Ort kan nur einen Punkt oder in einen Bereich darstellen.");
	}

}
