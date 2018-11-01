package thk.fae.urd.ort.domain.ort;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.validation.constraints.Size;

import thk.fae.urd.ort.domain.AggregateUUID4;
import thk.fae.urd.ort.domain.Kontaktdaten;
import thk.fae.urd.ort.domain.Location;

@Entity
public class Ort extends AggregateUUID4 {

	@Embedded
	private Location location;

	@Size(min = 3)
	@ElementCollection(targetClass = Location.class, fetch = FetchType.EAGER)
	@JoinTable(name = "GEOFENCE_BORDER")
	private List<Location> geofence;

	@Embedded
	private Kontaktdaten kontaktdaten;

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(final Location location) {
		if (this.geofence != null) {
			throw new IllegalArgumentException("Ein Ort kan nur einen Punkt oder in einen Bereich darstellen.");
		}
		this.location = location;
	}

	public Kontaktdaten getKontaktdaten() {
		return this.kontaktdaten;
	}

	public void setKontaktdaten(final Kontaktdaten kontaktdaten) {
		this.kontaktdaten = kontaktdaten;
	}

	public boolean isAnlaufstelle() {
		return this.kontaktdaten != null;
	}

	public List<Location> getGeofence() {
		// TODO: Beim Laden aus dem Repository wird geofence momentan gesetzt
		return this.geofence == null || this.geofence.isEmpty() ? null : this.geofence;
	}

	public void setGeofence(final List<Location> geofence) {
		if (this.location != null) {
			throw new IllegalArgumentException("Ein Ort kan nur einen Punkt oder in einen Bereich darstellen.");
		}
		this.geofence = geofence;
	}

	@Override
	public boolean equals(final Object obj) {
		if ((null == obj) || (obj.getClass() != Ort.class)) {
			return false;
		}
		final Ort other = (Ort) obj;
		return this.getId().equals(other.getId());
	}

}
