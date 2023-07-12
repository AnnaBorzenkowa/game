package ru.netology.javaqa;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException (String playerName){
        super("Игрок с ID " + playerName + " не зарегестрирован");
    }
}
