package com.fapethedev.arangodb.sdt.runner;

import com.arangodb.springframework.core.ArangoOperations;
import com.fapethedev.arangodb.sdt.entity.Character;
import com.fapethedev.arangodb.sdt.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;

@RequiredArgsConstructor
@ComponentScan("com.fapethedev.arangodb.sdt")
public class CrudRunner implements CommandLineRunner
{
    private final ArangoOperations operations;
    private final CharacterRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // first drop the database so that we can run this multiple times with the same dataset
        operations.dropDatabase();

        // Save a single entity in the database,
        // there is no need of creating the collection first.This happens automatically
        final Character nedStark = new Character("Ned", "Stark", true, 41);
        repository.save(nedStark);

        // the generated id from the database is set in the original entity
        System.out.printf("Ned Stark saved in the database with id: '%s'%n", nedStark.getId());

        // let's take a look whether we can find Ned Stark in the database
        final Optional<Character> foundNed = repository.findById(nedStark.getId());
        assert foundNed.isPresent();
        System.out.printf("Found %s%n", foundNed.get());

        nedStark.setAlive(false);
        repository.save(nedStark);
        var deadNed = repository.findById(nedStark.getId());
        assert deadNed.isPresent();
        System.out.printf("The 'alive' flag of the persisted Ned Stark is now '%s'%n",deadNed.get().isAlive());
    }
}
