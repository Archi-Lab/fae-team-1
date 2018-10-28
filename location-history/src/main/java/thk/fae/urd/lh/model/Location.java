package thk.fae.urd.lh.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Embeddable
public class Location implements Serializable {
    
    @NotNull
    @Column(nullable = false)
    private Double latitude;
    
    @NotNull
    @Column(nullable = false)
    private Double longitude;
    
    @NotNull
    @Column(nullable = false)
    private Double altitude;
    
    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return latitude;
    }
    
    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    
    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }
    
    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    /**
     * @return the altitude
     */
    public Double getAltitude() {
        return altitude;
    }

    /**
     * @param altitude the altitude to set
     */
    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }
       
}
