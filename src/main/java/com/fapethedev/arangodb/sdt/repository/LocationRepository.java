package com.fapethedev.arangodb.sdt.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.fapethedev.arangodb.sdt.entity.Location;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Range;
import org.springframework.data.geo.*;

public interface LocationRepository extends ArangoRepository<Location, String> {
    GeoPage<Location> findByLocationNear(Point point, PageRequest of);

    GeoResults<Location> findByLocationWithin(Point location, Distance distance);

    Iterable<Location> findByLocationWithin(Point location, Range<Double> distanceRange);

    Iterable<Location> findByLocationWithin(Polygon polygon);
}