package com.b2wdigital.selecao.peopleregistration.repository;

import com.b2wdigital.selecao.peopleregistration.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
}
