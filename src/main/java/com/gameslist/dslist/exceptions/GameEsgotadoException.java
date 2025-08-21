package com.gameslist.dslist.exceptions;

import java.util.NoSuchElementException;

public class GameEsgotadoException extends NoSuchElementException {
    public GameEsgotadoException(){
        super("Game não encontrado.");
    }

    public GameEsgotadoException(String message){
        super(message);
    }
}
