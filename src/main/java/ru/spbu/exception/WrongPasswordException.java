package ru.spbu.exception;

public class WrongPasswordException extends Throwable {
    public WrongPasswordException(String message) {
        super(message);
    }
}
