package thk.fae.ua.core.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import thk.fae.ua.core.domain.common.EntityUUID4;
import thk.fae.ua.utils.EqualsBuilderExtension;

@Entity
public class DemenziellVeraendertePerson extends EntityUUID4 {

	private UUID trackerId;

	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "demenziellVeraendertePerson", fetch = FetchType.EAGER)
	private List<Ort> orte;

	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "demenziellVeraendertePerson", fetch = FetchType.EAGER)
	private List<Route> routen;

	public List<Ort> getOrte() {
		return this.orte;
	}

	public void setOrte(final List<Ort> orte) {
		this.orte = orte;
	}

	public void addOrt(final Ort ort) {
		if (this.orte == null) {
			this.orte = new ArrayList<>();
		}
		this.orte.add(ort);
	}

	public List<Route> getRouten() {
		return this.routen;
	}

	public void setRouten(final List<Route> routen) {
		this.routen = routen;
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

		eb.append(this.getOrte(), other.getOrte());
		eb.append(this.getRouten(), other.getRouten());

		return eb.isEquals();
	}
}
