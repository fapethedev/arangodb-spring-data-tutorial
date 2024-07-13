package com.fapethedev.arangodb.sdt.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.fapethedev.arangodb.sdt.entity.Character;

public interface CharacterRepository extends ArangoRepository<Character, String> {
    Iterable<Character> findBySurname(String surname);
}
