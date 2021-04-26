package hu.nwh9yb.loginapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String username){
        super(MessageFormat.format("User already exists with name {0}!", username));
    }
}
