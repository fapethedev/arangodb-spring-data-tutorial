package com.fapethedev.arangodb.sdt.runner;


import com.fapethedev.arangodb.sdt.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

@RequiredArgsConstructor
public class AQLRunner implements CommandLineRunner {

    private final CharacterRepository repository;

    @Override
    public void run(final String... args) throws Exception {
        System.out.println("# AQL queries");

        System.out.println("## Find all characters with surname 'Lannister' (sort by age ascending)");
        var lannisters = repository.getWithSurname("Lannister");
        lannisters.forEach(System.out::println);

    }

}