package com.fapethedev.arangodb.sdt.runner;

import com.fapethedev.arangodb.sdt.entity.Location;
import com.fapethedev.arangodb.sdt.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.geo.Point;

import java.util.Arrays;

@RequiredArgsConstructor
@ComponentScan("com.fapethedev.arangodb.sdt")
public class GeospatialRunner implements CommandLineRunner {

    private final LocationRepository repository;
 
    @Override
    public void run(final String... args) throws Exception {
        System.out.println("# Geospatial");
 
        repository.saveAll(Arrays.asList(
                new Location("Dragonstone",     new Point(-6.815096, 55.167801)),
                new Location("King's Landing",  new Point(18.110189, 42.639752)),
                new Location("The Red Keep",    new Point(14.446442, 35.896447)),
                new Location("Yunkai",          new Point(-7.129532, 31.046642)),
                new Location("Astapor",         new Point(-9.774249, 31.50974)),
                new Location("Winterfell",      new Point(-5.581312, 54.368321)),
                new Location("Vaes Dothrak",    new Point(-6.096125, 54.16776)),
                new Location("Beyond the wall", new Point(-21.094093, 64.265473))));
    }
}