
package thk.fae.ua.infrastructure.kafka.models.dvp;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vorname",
    "nachname",
    "alter",
    "id",
    "version",
    "einwilligung",
    "bild",
    "tracker",
    "aggregateName"
})
public class DvpUpdateMessageModel {

    @JsonProperty("vorname")
    public Vorname vorname;
    @JsonProperty("nachname")
    public Nachname nachname;
    @JsonProperty("alter")
    public Alter alter;
    @JsonProperty("id")
    public String id;
    @JsonProperty("version")
    public Integer version;
    @JsonProperty("einwilligung")
    public Einwilligung einwilligung;
    @JsonProperty("bild")
    public Bild bild;
    @JsonProperty("tracker")
    public Tracker tracker;
    @JsonProperty("aggregateName")
    public String aggregateName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
