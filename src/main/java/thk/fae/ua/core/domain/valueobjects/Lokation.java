package thk.fae.ua.core.domain.valueobjects;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class Lokation {

	@NotNull
	private Double latitude;

	@NotNull
	private Double longitude;

	@NotNull
	private Double altitude;

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return this.altitude;
	}

	public void setAltitude(final Double altitude) {
		this.altitude = altitude;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Lokation)) {
			return false;
		}

		final Lokation other = (Lokation) obj;
		final EqualsBuilder eb = new EqualsBuilder();

		eb.append(this.getAltitude(), other.getAltitude());
		eb.append(this.getLatitude(), other.getLatitude());
		eb.append(this.getLongitude(), other.getLongitude());

		return eb.isEquals();
	}

	@Override
	public int hashCode() {
		final HashCodeBuilder hcb = new HashCodeBuilder();

		hcb.append(this.getAltitude());
		hcb.append(this.getLatitude());
		hcb.append(this.getLongitude());

		return hcb.toHashCode();
	}
}
