package br.com.moraes.prestadorservico.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.moraes.prestadorservico.api.util.StringUtil;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdNotInformedException extends PatternException {

    public IdNotInformedException() {
        this(StringUtil.getMessage("id_not_found"));
    }

    public IdNotInformedException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }

    public IdNotInformedException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
