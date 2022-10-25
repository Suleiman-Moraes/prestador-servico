package br.com.moraes.prestadorservico.api.service;

import br.com.moraes.prestadorservico.api.interfaces.ICrudPatternService;
import br.com.moraes.prestadorservico.api.model.Profile;

public interface ProfileService extends ICrudPatternService<Profile>{

    Profile findTopByName(String name);
}
