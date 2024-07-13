package com.fapethedev.arangodb.sdt.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.fapethedev.arangodb.sdt.entity.Character;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends ArangoRepository<Character, String> {
    Iterable<Character> findBySurname(String surname);

    Collection<Character> findTop2DistinctBySurnameIgnoreCaseOrderByAgeDesc(String surname);

    List<Character> findBySurnameEndsWithAndAgeBetweenAndNameInAllIgnoreCase(
        String suffix,
        Integer lowerBound,
        Integer upperBound,
        Collection<String> nameList);

    Optional<Character> findByNameAndSurname(String name, String surname);

    Integer countByAliveTrue();

    void removeBySurnameNotLikeOrAliveFalse(String surname);
}
