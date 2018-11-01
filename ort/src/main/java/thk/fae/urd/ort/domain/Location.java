package thk.fae.urd.ort.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Location {

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
		if ((null == obj) || (obj.getClass() != Location.class)) {
			return false;
		}
		final Location other = (Location) obj;
		return this.getAltitude() == other.getAltitude() && this.getLatitude() == other.getLatitude()
				&& this.getLongitude() == other.getLongitude();
	}

}
