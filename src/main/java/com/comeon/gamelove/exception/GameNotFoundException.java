package com.comeon.gamelove.exception;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(Long id) {
        super("Could not find game " + id);
    }
}
