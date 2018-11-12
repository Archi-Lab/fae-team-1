package thk.fae.urd.ort.domain.route;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import thk.fae.urd.ort.domain.Location;
import thk.fae.urd.ort.domain.LocationTestHelper;
import thk.fae.urd.ort.domain.demenziellveraenderteperson.DemenziellVeraendertePerson;

public class RouteTestHelper {

	public static Route createDummyRoute(final DemenziellVeraendertePerson dvp) {
		final Route route = new Route();
		route.setDemenziellVeraendertePerson(dvp);
		route.setName(RandomStringUtils.random(10));
		final List<Location> list = new ArrayList<>();
		list.add(LocationTestHelper.createDummyRandomLocation());
		list.add(LocationTestHelper.createDummyRandomLocation());
		route.setLocations(list);
		return route;
	}

}
