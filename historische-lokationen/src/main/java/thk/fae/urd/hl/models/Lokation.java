package thk.fae.urd.hl.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Embeddable
public class Lokation {

	@NotNull
    @Column(nullable = false)
    private Double latitude;
    
    @NotNull
    @Column(nullable = false)
    private Double longitude;
    
    @NotNull
    @Column(nullable = false)
    private Double altitude;
    
    public Lokation() {
    	super();
    }
    
    public Lokation(@NotNull Double latitude, @NotNull Double longitude, @NotNull Double altitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}
     
    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }
    
    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }
    
    /**
     * @return the altitude
     */
    public Double getAltitude() {
        return altitude;
    }
       
}
