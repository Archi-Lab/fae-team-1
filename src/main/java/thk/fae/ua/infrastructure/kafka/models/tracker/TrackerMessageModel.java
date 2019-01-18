package thk.fae.ua.infrastructure.kafka.models.tracker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackerMessageModel {

    public UUID id;

    public String type;

    public Long version;

    public UUID key;

    public String time;

    public TrackerModel payload;

}
