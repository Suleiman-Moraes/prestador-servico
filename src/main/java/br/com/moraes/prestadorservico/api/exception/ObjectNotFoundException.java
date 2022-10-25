package br.com.moraes.prestadorservico.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.moraes.prestadorservico.api.util.StringUtil;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends PatternException{

    public ObjectNotFoundException(){
        this(StringUtil.getMessage("object_not_found"));
    }

    public ObjectNotFoundException(String message) {
        this(message, HttpStatus.NOT_FOUND);
    }

    public ObjectNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
