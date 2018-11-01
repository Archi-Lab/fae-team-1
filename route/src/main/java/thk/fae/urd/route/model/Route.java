package thk.fae.urd.route.model;

import javax.persistence.*;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Embedded
    private Location location;
/*
    @Embedded
    private DVP dvp;

    @Embedded
    private Bezugsperson bezugsperson;*/

    public Route() {

    }

    public Route(Location location) {
        this.location = location;
    }

    public Long getId() { return this.id; }

    public String getName() { return this.name;}

    public void setName(String name) { this.name=name;}

    public Location getLocation() { return this.location; }
}
