package thk.fae.ua.infrastructure.kafka.models.dvp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DvpModel {

    public UUID id;

    public Long version;

    public VornameModel vorname;

    public NachnameModel nachname;

    public TrackerModel tracker;

}
