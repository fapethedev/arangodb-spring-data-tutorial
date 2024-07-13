package com.fapethedev.arangodb.sdt.runner;

import com.fapethedev.arangodb.sdt.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

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

        System.out.println("## Find top 2 Lannnisters ordered by age");
        var top2 = repository.findTop2DistinctBySurnameIgnoreCaseOrderByAgeDesc("lannister");
        top2.forEach(System.out::println);

        System.out.println("## Find all characters which name is 'Bran' or 'Sansa' and it's surname ends with 'ark' and are between 10 and 16 years old");
        var youngStarks = repository.findBySurnameEndsWithAndAgeBetweenAndNameInAllIgnoreCase(
                "ark",
                10,
                16,
                List.of(new String[]{"Bran", "Sansa"})
        );
        youngStarks.forEach(System.out::println);

        System.out.println("## Find a single character by name & surname");
        var tyrion = repository.findByNameAndSurname("Tyrion", "Lannister");
        tyrion.ifPresent(c -> System.out.printf("Found %s%n", c));
    }
}
