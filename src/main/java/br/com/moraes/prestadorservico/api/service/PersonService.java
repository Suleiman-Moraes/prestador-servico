package br.com.moraes.prestadorservico.api.service;

import java.util.Optional;

import br.com.moraes.prestadorservico.api.interfaces.ICrudPatternService;
import br.com.moraes.prestadorservico.api.model.Person;

public interface PersonService extends ICrudPatternService<Person> {

    Optional<Person> findTopByUserId(Long id);
}
