package thk.fae.ua.core.domain.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;

import thk.fae.ua.core.domain.valueobjects.Lokation;
import thk.fae.ua.core.domain.common.EntityUUID4;
import thk.fae.ua.core.domain.common.EqualsBuilderExtension;

@Entity
public class Route extends EntityUUID4 {

	@Length(min = 1)
	private String name;

	@Size(min = 2, message = "Eine Route besteht mindestens aus 2 Locations")
	@ElementCollection(targetClass = Lokation.class, fetch = FetchType.EAGER)
	@JoinTable(name = "ROUTE_LOCATIONS")
	private List<Lokation> lokationen;

	@NotNull
	@ManyToOne
	private DemenziellVeraendertePerson demenziellVeraendertePerson;

	public Route() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<Lokation> getLokationen() {
		return this.lokationen == null || this.lokationen.isEmpty() ? null : this.lokationen;
	}

	public void setLokationen(final List<Lokation> lokationen) {
		this.lokationen = lokationen;
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
		if (obj == null || !(obj instanceof Route)) {
			return false;
		}

		final Route other = (Route) obj;
		final EqualsBuilderExtension eb = new EqualsBuilderExtension();
		eb.appendSuper(super.equals(obj));

		eb.append(this.getName(), other.getName());
		eb.append(this.getLokationen(), other.getLokationen());

		return eb.isEquals();
	}

	@Override
	public int hashCode() {
		final HashCodeBuilder hcb = new HashCodeBuilder();
		hcb.appendSuper(super.hashCode());

		hcb.append(this.getName());

		return hcb.toHashCode();
	}

}
