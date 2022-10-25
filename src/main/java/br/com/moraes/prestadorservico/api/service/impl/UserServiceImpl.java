package br.com.moraes.prestadorservico.api.service.impl;

import java.util.Optional;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.moraes.prestadorservico.api.dto.ObjectWithIdDTO;
import br.com.moraes.prestadorservico.api.exception.ValidException;
import br.com.moraes.prestadorservico.api.model.User;
import br.com.moraes.prestadorservico.api.repository.UserRepository;
import br.com.moraes.prestadorservico.api.service.PersonService;
import br.com.moraes.prestadorservico.api.service.UserService;
import br.com.moraes.prestadorservico.api.service.abstracts.CrudPatternServiceImpl;
import br.com.moraes.prestadorservico.api.util.StringUtil;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl extends CrudPatternServiceImpl<User> implements UserService {

    @Getter
    @Autowired
    private UserRepository repository;

    @Autowired
    private PersonService personService;

    @Override
    public ObjectWithIdDTO findByToken() {
        try {
            final SecurityContext context = SecurityContextHolder.getContext();
            if (context != null) {
                final Authentication authentication = context.getAuthentication();
                if (authentication != null) {
                    final Long id = repository.findIdByUsername(authentication.getName());
                    return new ObjectWithIdDTO(id);
                }
            }
        } catch (Exception e) {
            log.warn("findByToken " + ExceptionUtils.getRootCauseMessage(e));
        }
        return null;
    }

    @Override
    public Optional<User> findTopByUsername(String username) {
        return repository.findTopByUsername(username);
    }

    @Transactional
    @Override
    public User create(User objeto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        objeto.setId(null);
        objeto.setPassword(passwordEncoder.encode(objeto.getPassword()));
        objeto.setPerson(personService.create(objeto.getPerson()));
        return save(objeto);
    }

    @Override
    public User save(User objeto) {
        objeto.getPerson().setUser(null);
        if (repository.existsByUsernameAndIdNot(objeto.getUsername(), objeto.getId() == null ? 0l : objeto.getId())) {
            throw new ValidException(StringUtil.getMessage("username_unique"));
        }
        objeto = repository.save(objeto);
        return objeto;
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }
}
