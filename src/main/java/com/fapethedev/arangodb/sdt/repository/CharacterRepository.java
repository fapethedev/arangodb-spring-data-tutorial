package com.fapethedev.arangodb.sdt.repository;

import com.arangodb.springframework.annotation.BindVars;
import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import com.fapethedev.arangodb.sdt.entity.Character;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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

    @Query("FOR c IN characters FILTER c.surname == @surname SORT c.age ASC RETURN c")
    Iterable<Character> getWithSurname(@Param("surname") String value);

    @Query("FOR c IN @@col FILTER c.surname == @surname AND c.age > @age RETURN c")
    Iterable<Character> getWithSurnameOlderThan(@Param("age") int value, @BindVars Map<String, Object> bindvars);
}
