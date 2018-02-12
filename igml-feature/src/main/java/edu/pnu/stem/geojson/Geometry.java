package edu.pnu.stem.geojson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type"
)
@JsonSubTypes( {
  @JsonSubTypes.Type(value=Solid.class, name="Solid"  )
} )

@JsonPropertyOrder({"type", "coordinates", "bbox"})
public abstract class Geometry extends GeoJSON {
    @JsonCreator
    public Geometry() {
        super();
    }
}