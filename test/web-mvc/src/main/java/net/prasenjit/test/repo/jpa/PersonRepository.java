package net.prasenjit.test.repo.jpa;

import net.prasenjit.test.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
