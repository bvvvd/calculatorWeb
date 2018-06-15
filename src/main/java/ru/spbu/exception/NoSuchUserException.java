package ru.spbu.exception;

public class NoSuchUserException extends Throwable {
    public NoSuchUserException(String message) {
        super(message);
    }
}
