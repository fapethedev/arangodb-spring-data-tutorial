package com.fapethedev.arangodb.sdt.entity;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.GeoIndexed;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

@ToString
@Getter
@Setter
@Document("locations")
public class Location {

    @Id
    private String id;
    private final String name;

    @GeoIndexed(geoJson = true)
    private final Point location;

    public Location(final String name, final Point location) {
        super();
        this.name = name;
        this.location = location;
    }
}

