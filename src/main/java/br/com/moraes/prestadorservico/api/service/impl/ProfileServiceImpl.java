package br.com.moraes.prestadorservico.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moraes.prestadorservico.api.model.Profile;
import br.com.moraes.prestadorservico.api.repository.ProfileRepository;
import br.com.moraes.prestadorservico.api.service.ProfileService;
import br.com.moraes.prestadorservico.api.service.abstracts.CrudPatternServiceImpl;
import lombok.Getter;

@Service
public class ProfileServiceImpl extends CrudPatternServiceImpl<Profile> implements ProfileService {

    @Autowired
    @Getter
    private ProfileRepository repository;

    @Override
    public Profile findTopByName(String name) {
        return repository.findTopByName(name);
    }
}
