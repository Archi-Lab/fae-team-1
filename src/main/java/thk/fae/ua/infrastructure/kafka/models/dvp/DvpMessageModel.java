package thk.fae.ua.infrastructure.kafka.models.dvp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DvpMessageModel {

    public UUID id;

    public String type;

    public Long version;

    public UUID key;

    public DvpModel payload;

}
