package br.com.moraes.prestadorservico.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.moraes.prestadorservico.api.util.StringUtil;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserInactiveException extends PatternException {

    public UserInactiveException() {
        this(StringUtil.getMessage("user_inactive"));
    }

    public UserInactiveException(String message) {
        this(message, HttpStatus.FORBIDDEN);
    }

    public UserInactiveException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
