package thk.fae.ua.core.domain.ort;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import thk.fae.ua.core.domain.entities.Ort;
import thk.fae.ua.core.domain.valueobjects.Lokation;
import thk.fae.ua.core.domain.LocationTestHelper;
import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;

public class OrtTestHelper {

	private static Ort createDummyOrt(final DemenziellVeraendertePerson dvp) {
		final Ort ort = new Ort();
		ort.setDemenziellVeraendertePerson(dvp);
		ort.setName(RandomStringUtils.random(10));
		return ort;
	}

	public static Ort createDummyOrtWithLocation(final DemenziellVeraendertePerson dvp) {
		final Ort ort = createDummyOrt(dvp);
		ort.setLokation(LocationTestHelper.createDummyRandomLocation());
		return ort;
	}

	public static Ort createDummyOrtWithGeofence(final DemenziellVeraendertePerson dvp) {
		final Ort ort = createDummyOrt(dvp);
		final List<Lokation> list = new ArrayList<>();
		list.add(LocationTestHelper.createDummyRandomLocation());
		list.add(LocationTestHelper.createDummyRandomLocation());
		list.add(LocationTestHelper.createDummyRandomLocation());
		ort.setBereich(list);
		return ort;
	}
}
