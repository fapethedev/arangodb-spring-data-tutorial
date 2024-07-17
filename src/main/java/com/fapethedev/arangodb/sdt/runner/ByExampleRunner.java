package com.fapethedev.arangodb.sdt.runner;

import com.fapethedev.arangodb.sdt.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

@RequiredArgsConstructor
@ComponentScan("com.fapethedev.arangodb.sdt")
public class ByExampleRunner implements CommandLineRunner
{
    private final CharacterRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("# Query by example");
    }
}
