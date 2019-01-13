package thk.fae.ua.domain;

import java.util.Random;

public class LocationTestHelper {

	public static Location createDummyRandomLocation() {
		final Random random = new Random();
		final Location location = new Location();
		location.setLongitude(random.nextDouble());
		location.setLatitude(random.nextDouble());
		location.setAltitude(random.nextDouble());
		return location;
	}
}
