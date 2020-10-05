package de.mobilcom.mastermind.service;

import de.mobilcom.mastermind.model.GameState;

public class MastermindService {


    public GameState newGame(int colorCount, int fieldCount, int maxTries){
        GameState state = new GameState(colorCount, fieldCount, maxTries);
        return state;

    }

    public GameState guess(GameState current, int[] newGuess){
       return current;
    } // aktueller spielstand muss angepasst werden
}
