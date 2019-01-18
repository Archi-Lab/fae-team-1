package thk.fae.ua.core.domain.valueobjects;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class Lokation {

	@NotNull
	@Getter
	@Setter
	private Double latitude;

	@NotNull
	@Getter
	@Setter
	private Double longitude;

	@NotNull
	@Getter
	@Setter
	private Double altitude;

	public Lokation() {

	}

	public Lokation(@NotNull Double latitude, @NotNull Double longitude, @NotNull Double altitude) {
		this.latitude = latitude;
		this.longitude = longitude;
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
