package br.com.moraes.prestadorservico.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.moraes.prestadorservico.api.exception.UserInactiveException;
import br.com.moraes.prestadorservico.api.exception.UsernameOrPasswordNotFoundException;
import br.com.moraes.prestadorservico.api.model.User;
import br.com.moraes.prestadorservico.api.service.UserService;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameOrPasswordNotFoundException {
        Optional<? extends User> userOp = service.findTopByUsername(username);
        User user = userOp.orElseThrow(UsernameOrPasswordNotFoundException::new);
        if (!user.isEnabled()) {
            throw new UserInactiveException();
        }
        return new UserSystem(user, user.getProfile().getAuthorities());
    }
}
