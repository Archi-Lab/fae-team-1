package thk.fae.urd.lh.model;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class HistoricalLocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Column(nullable = false)
    private Long dvpId;
    
    @NotNull @Valid
    @Column(nullable = false)
    private Instant timestamp;
    
    @NotNull @Valid
    @Column(nullable = false)
    private Location location;
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @return the dvpId
     */
    public Long getDvpId() {
        return dvpId;
    }
    
    /**
     * @return the timestamp
     */
    public Instant getTimestamp() {
        return timestamp;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }  
}