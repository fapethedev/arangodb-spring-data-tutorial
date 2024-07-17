package com.fapethedev.arangodb.sdt.runner;

import com.fapethedev.arangodb.sdt.entity.Character;
import com.fapethedev.arangodb.sdt.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;

@RequiredArgsConstructor
@ComponentScan("com.fapethedev.arangodb.sdt")
public class ByExampleRunner implements CommandLineRunner
{
    private final CharacterRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("# Query by example");

        var nedStark = new Character("Ned", "Stark", false, 41);
        System.out.printf("## Find character which exactly match %s%n", nedStark);
        var foundNedStark = repository.findOne(Example.of(nedStark));
        assert foundNedStark.isPresent();
        System.out.printf("Found %s%n", foundNedStark.get());

        System.out.println("## Find all dead Starks");
        var allDeadStarks = repository
                .findAll(Example.of(new Character(null, "Stark", false), ExampleMatcher.matchingAll()
                        .withMatcher("surname", GenericPropertyMatcher::exact).withIgnorePaths("name", "age")));
        allDeadStarks.forEach(System.out::println);

        System.out.println("## Find all Starks which are 30 years younger than Ned Stark");
        Iterable<Character> allYoungerStarks = repository.findAll(
                Example.of(foundNedStark.get(), ExampleMatcher.matchingAll()
                        .withMatcher("surname", GenericPropertyMatcher::exact)
                        .withIgnorePaths("id", "name", "alive")
                        .withTransformer("age", age -> age.map(it -> (int) it - 30))));
        allYoungerStarks.forEach(System.out::println);

        System.out.println("## Find all character which surname ends with 'ark' (ignore case)");
        Iterable<Character> ark = repository.findAll(Example.of(new Character(null, "ark", false),
                ExampleMatcher.matchingAll().withMatcher("surname", GenericPropertyMatcher::endsWith)
                        .withIgnoreCase()
                        .withIgnorePaths("name", "alive", "age")));
        ark.forEach(System.out::println);
    }
}
