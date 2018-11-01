package thk.fae.urd.ort.domain;

import java.util.Random;

public class LocationTestHelper {

	public static Location createDummyLocation() {
		final Location location = new Location();
		location.setLongitude(1d);
		location.setLatitude(2d);
		location.setAltitude(3d);
		return location;
	}

	public static Location createDummyRandomLocation() {
		final Random random = new Random();
		final Location location = new Location();
		location.setLongitude(random.nextDouble());
		location.setLatitude(random.nextDouble());
		location.setAltitude(random.nextDouble());
		return location;
	}
}
