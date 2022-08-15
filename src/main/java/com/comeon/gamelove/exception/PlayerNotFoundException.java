package com.comeon.gamelove.exception;

import java.util.function.Supplier;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(Long id) {
        super("Could not find player " + id);
    }
}
