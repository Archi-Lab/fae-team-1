package thk.fae.ua.infrastructure.kafka.models.tracker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackerModel {

    public UUID trackerId;

    public PositionModel currentPosition;

}
