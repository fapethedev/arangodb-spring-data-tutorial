package com.fapethedev.arangodb.sdt.repository;


import com.arangodb.springframework.repository.ArangoRepository;
import com.fapethedev.arangodb.sdt.entity.ChildOf;

public interface ChildOfRepository extends ArangoRepository<ChildOf, String> {
}
