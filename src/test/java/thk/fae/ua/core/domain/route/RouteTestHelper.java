package thk.fae.ua.core.domain.route;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import thk.fae.ua.core.domain.entities.Route;
import thk.fae.ua.core.domain.valueobjects.Lokation;
import thk.fae.ua.core.domain.LocationTestHelper;
import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;

public class RouteTestHelper {

	public static Route createDummyRoute(final DemenziellVeraendertePerson dvp) {
		final Route route = new Route();
		route.setDemenziellVeraendertePerson(dvp);
		route.setName(RandomStringUtils.random(10));
		final List<Lokation> list = new ArrayList<>();
		list.add(LocationTestHelper.createDummyRandomLocation());
		list.add(LocationTestHelper.createDummyRandomLocation());
		route.setLokationen(list);
		return route;
	}

}
