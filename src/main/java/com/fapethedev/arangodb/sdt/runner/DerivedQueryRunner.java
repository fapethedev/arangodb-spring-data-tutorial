package com.fapethedev.arangodb.sdt.runner;

import com.fapethedev.arangodb.sdt.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

@RequiredArgsConstructor
@ComponentScan("com.fapethedev.arangodb.sdt")
public class DerivedQueryRunner implements CommandLineRunner
{
    private final CharacterRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("# Derived queries");

        System.out.println("## Find all characters with surname 'Lannister'");
        var lannisters = repository.findBySurname("Lannister");
        lannisters.forEach(System.out::println);
    }
}
