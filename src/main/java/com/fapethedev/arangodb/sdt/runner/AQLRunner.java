package com.fapethedev.arangodb.sdt.runner;


import com.arangodb.ArangoCursor;
import com.fapethedev.arangodb.sdt.entity.Character;
import com.fapethedev.arangodb.sdt.entity.ChildOf;
import com.fapethedev.arangodb.sdt.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

@RequiredArgsConstructor
@ComponentScan("com.fapethedev.arangodb.sdt")
public class AQLRunner implements CommandLineRunner {

    private final CharacterRepository repository;

    @Override
    public void run(final String... args) throws Exception {
        System.out.println("# AQL queries");

        System.out.println("## Find all characters with surname 'Lannister' (sort by age ascending)");
        var lannisters = repository.getWithSurname("Lannister");
        lannisters.forEach(System.out::println);

        System.out.println("## Find all characters with surname 'Lannister' which are older than 35");
        var bindvars = new HashMap<String, Object>();
        bindvars.put("surname", "Lannister");
        bindvars.put("@col", Character.class);

        var oldLannisters = repository.getWithSurnameOlderThan(35, bindvars);
        System.out.printf("Found %s documents%n", ((ArangoCursor<Character>) oldLannisters).getCount());
        oldLannisters.forEach(System.out::println);

        System.out.println("## Find all children and grantchildren of 'Tywin Lannister' (sort by age descending)");
        repository.findByNameAndSurname("Tywin", "Lannister").ifPresent(tywin -> {
            var children = repository.getAllChildrenAndGrandchildren(tywin.getArangoId(), ChildOf.class);
            children.forEach(System.out::println);
        });
    }

}