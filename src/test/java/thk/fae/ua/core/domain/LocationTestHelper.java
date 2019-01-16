package thk.fae.ua.core.domain;

import thk.fae.ua.core.domain.valueobjects.Lokation;

import java.util.Random;

public class LocationTestHelper {

	public static Lokation createDummyRandomLocation() {
		final Random random = new Random();
		final Lokation lokation = new Lokation();
		lokation.setLongitude(random.nextDouble());
		lokation.setLatitude(random.nextDouble());
		lokation.setAltitude(random.nextDouble());
		return lokation;
	}
}
