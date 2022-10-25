package br.com.moraes.prestadorservico.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moraes.prestadorservico.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findTopByUserId(Long id);
}
