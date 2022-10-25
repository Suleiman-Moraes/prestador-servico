package br.com.moraes.prestadorservico.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.moraes.prestadorservico.api.util.StringUtil;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UsernameOrPasswordNotFoundException extends PatternException {

    public UsernameOrPasswordNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
        this.httpStatus = httpStatus;
    }

    public UsernameOrPasswordNotFoundException() {
        super(StringUtil.getMessage("username_password_incorrect"), HttpStatus.BAD_REQUEST);
    }
}
