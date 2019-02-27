package thk.fae.ua.core.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import thk.fae.ua.core.domain.common.EntityUUID4;
import thk.fae.ua.core.domain.common.EqualsBuilderExtension;
import thk.fae.ua.core.domain.events.TrackerUpdateEvent;
import thk.fae.ua.core.domain.valueobjects.Tracker;

@Entity
public class DemenziellVeraendertePerson extends EntityUUID4 {

	@Getter
	@Setter
	private Long version;

	@Getter
	@Setter
	@Embedded
	private Tracker tracker;

	@Getter
	@Setter
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private TrackerUpdateEvent letzterBekannterAufenthaltsort;

	@Getter
	@Setter
	private String vorname;

	@Getter
	@Setter
	private String nachname;

	@Getter
	@Setter
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "demenziellVeraendertePerson", fetch = FetchType.EAGER)
	private List<Ort> orte;

	@Getter
	@Setter
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "demenziellVeraendertePerson", fetch = FetchType.EAGER)
	private List<Route> routen;

	public DemenziellVeraendertePerson() {

	}

	public void addOrt(final Ort ort) {
		if (this.orte == null) {
			this.orte = new ArrayList<>();
		}
		this.orte.add(ort);
	}

	public void addRoute(final Route route) {
		if (this.routen == null) {
			this.routen = new ArrayList<>();
		}
		this.routen.add(route);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof DemenziellVeraendertePerson)) {
			return false;
		}
		final DemenziellVeraendertePerson other = (DemenziellVeraendertePerson) obj;
		final EqualsBuilderExtension eb = new EqualsBuilderExtension();
		eb.appendSuper(super.equals(obj));

		eb.append(this.getVersion(), other.getVersion());
		eb.append(this.getTracker(), other.getTracker());
		eb.append(this.getLetzterBekannterAufenthaltsort(), other.getLetzterBekannterAufenthaltsort());
		eb.append(this.getVorname(), other.getVorname());
		eb.append(this.getNachname(), other.getNachname());
		eb.append(this.getOrte(), other.getOrte());
		eb.append(this.getRouten(), other.getRouten());

		return eb.isEquals();
	}

	@Override
	public String toString() {
		return String.format(
				"%1$s %2$s with UUID: %3$s",
				/*1*/ this.vorname,
				/*2*/ this.nachname,
				/*3*/ this.getId()
		);
	}
}
