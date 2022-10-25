package br.com.moraes.prestadorservico.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moraes.prestadorservico.api.model.Person;
import br.com.moraes.prestadorservico.api.repository.PersonRepository;
import br.com.moraes.prestadorservico.api.service.PersonService;
import br.com.moraes.prestadorservico.api.service.abstracts.CrudPatternServiceImpl;
import lombok.Getter;

@Service
public class PersonServiceImpl extends CrudPatternServiceImpl<Person> implements PersonService {

    @Getter
    @Autowired
    private PersonRepository repository;

    @Override
    public Optional<Person> findTopByUserId(Long id) {
        return repository.findTopByUserId(id);
    }
}
