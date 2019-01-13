package thk.fae.urd.ort.domain.ort;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;

import thk.fae.urd.ort.domain.Location;
import thk.fae.urd.ort.domain.core.EntityUUID4;
import thk.fae.urd.ort.domain.demenziellveraenderteperson.DemenziellVeraendertePerson;
import thk.fae.urd.ort.utils.EqualsBuilderExtension;

@Entity
public class Ort extends EntityUUID4 {

	private final static String LOCATION_BEREICH_MESSAGE = "Ein Ort kann entweder durch einen Punkt oder als ein Bereich dargestellt werden.";

	@Length(min = 1)
	private String name;

	@Embedded
	private Location location;

	@Size(min = 3, message = "Ein Bereich besteht aus mindestens 3 Punkten.")
	@ElementCollection(targetClass = Location.class, fetch = FetchType.EAGER)
	@JoinTable(name = "GEOFENCE_BORDER")
	private List<Location> bereich;

	@NotNull
	@ManyToOne
	private DemenziellVeraendertePerson demenziellVeraendertePerson;

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(final Location location) {
		Validate.isTrue(this.bereich == null, LOCATION_BEREICH_MESSAGE);
		this.location = location;
	}

	public List<Location> getBereich() {
		return this.bereich == null || this.bereich.isEmpty() ? null : this.bereich;
	}

	public void setBereich(final List<Location> bereich) {
		Validate.isTrue(this.location == null, LOCATION_BEREICH_MESSAGE);
		this.bereich = bereich;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public DemenziellVeraendertePerson getDemenziellVeraendertePerson() {
		return this.demenziellVeraendertePerson;
	}

	public void setDemenziellVeraendertePerson(final DemenziellVeraendertePerson demenziellVeraendertePerson) {
		this.demenziellVeraendertePerson = demenziellVeraendertePerson;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Ort)) {
			return false;
		}

		final Ort other = (Ort) obj;
		final EqualsBuilderExtension eb = new EqualsBuilderExtension();
		eb.appendSuper(super.equals(obj));

		eb.append(this.getName(), other.getName());
		eb.append(this.getLocation(), other.getLocation());
		eb.append(this.getBereich(), other.getBereich());

		return eb.isEquals();
	}

	@Override
	public int hashCode() {
		final HashCodeBuilder hcb = new HashCodeBuilder();
		hcb.appendSuper(super.hashCode());

		hcb.append(this.getName());
		hcb.append(this.getLocation());

		return hcb.toHashCode();
	}
}
