package com.fapethedev.arangodb.sdt.runner;

import com.fapethedev.arangodb.sdt.entity.Character;
import com.fapethedev.arangodb.sdt.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;

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
    }
}
