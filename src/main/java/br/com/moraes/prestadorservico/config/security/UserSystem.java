package br.com.moraes.prestadorservico.config.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserSystem extends User {

	private static final long serialVersionUID = 1L;

	private br.com.moraes.prestadorservico.api.model.User usuario;

	public UserSystem(br.com.moraes.prestadorservico.api.model.User usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getUsername(), usuario.getPassword(), authorities);
		this.usuario = usuario;
	}

	public br.com.moraes.prestadorservico.api.model.User getUsuario() {
		return usuario;
	}
}
