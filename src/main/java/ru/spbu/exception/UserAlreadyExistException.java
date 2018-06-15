package ru.spbu.exception;

public class UserAlreadyExistException extends Throwable {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
