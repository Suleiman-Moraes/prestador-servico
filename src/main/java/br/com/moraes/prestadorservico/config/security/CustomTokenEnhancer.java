package br.com.moraes.prestadorservico.config.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import br.com.moraes.prestadorservico.api.model.Person;
import br.com.moraes.prestadorservico.api.service.PersonService;

public class CustomTokenEnhancer implements TokenEnhancer {

	@Autowired
	private PersonService personService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		UserSystem usuarioSistema = (UserSystem) authentication.getPrincipal();

		Map<String, Object> addInfo = new HashMap<>();
		addInfo.put("login", usuarioSistema.getUsuario().getUsername());
		addInfo.put("id", usuarioSistema.getUsuario().getId());
		final Optional<Person> personOp = personService.findTopByUserId(usuarioSistema.getUsuario().getId());
		if (personOp.isPresent()) {
			final Person person = personOp.get();
			addInfo.put("name", person.getName());
			addInfo.put("cpf", person.getCpf());
		}

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
		return accessToken;
	}

}
