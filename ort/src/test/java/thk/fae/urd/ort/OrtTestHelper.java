package thk.fae.urd.ort;

import java.util.ArrayList;
import java.util.List;

import thk.fae.urd.ort.domain.Location;
import thk.fae.urd.ort.domain.LocationTestHelper;
import thk.fae.urd.ort.domain.ort.Ort;

public class OrtTestHelper {

	public static Ort createDummyOrtWithLocation() {
		final Ort ort = new Ort();
		ort.setLocation(LocationTestHelper.createDummyLocation());
		return ort;
	}

	public static Ort createDummyOrtWithGeofence() {
		final Ort ort = new Ort();
		final List<Location> list = new ArrayList<Location>();
		list.add(LocationTestHelper.createDummyRandomLocation());
		list.add(LocationTestHelper.createDummyRandomLocation());
		list.add(LocationTestHelper.createDummyRandomLocation());
		ort.setGeofence(list);
		return ort;
	}
}
