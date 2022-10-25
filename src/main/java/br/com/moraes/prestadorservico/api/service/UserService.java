package br.com.moraes.prestadorservico.api.service;

import java.util.Optional;

import br.com.moraes.prestadorservico.api.dto.ObjectWithIdDTO;
import br.com.moraes.prestadorservico.api.interfaces.ICrudPatternService;
import br.com.moraes.prestadorservico.api.model.User;

public interface UserService extends ICrudPatternService<User> {

    ObjectWithIdDTO findByToken();

    Optional<User> findTopByUsername(String username);

    boolean existsByUsername(String username);
}
