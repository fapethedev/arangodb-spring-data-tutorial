package com.fapethedev.arangodb.sdt.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.fapethedev.arangodb.sdt.entity.Location;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.GeoPage;
import org.springframework.data.geo.Point;

public interface LocationRepository extends ArangoRepository<Location, String> {
    GeoPage<Location> findByLocationNear(Point point, PageRequest of);
}