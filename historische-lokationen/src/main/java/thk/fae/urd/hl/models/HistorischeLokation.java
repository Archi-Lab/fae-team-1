package thk.fae.urd.hl.models;

import java.time.Instant;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity(name = "HistorischeLokation")
public class HistorischeLokation {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Column(nullable = false)
    private Long dvpId;
    
    @NotNull @Valid
    @Column(nullable = false)
    private Instant zeitpunkt;
    
    @NotNull @Valid
    @Column(nullable = false)
    private Lokation lokation;
    
    public HistorischeLokation() {
    	super();
    }
    
    public HistorischeLokation(@NotNull Long dvpId, @NotNull @Valid Instant zeitpunkt, @NotNull @Valid Lokation lokation) {
		super();
		this.dvpId = dvpId;
		this.zeitpunkt = zeitpunkt;
		this.lokation = lokation;
	}

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
     * @return den Zeitpunkt
     */
    public Instant getZeitpunkt() {
        return zeitpunkt;
    }

    /**
     * @return die Lokation
     */
    public Lokation getLokation() {
        return lokation;
    }  
}