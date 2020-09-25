package main.java.service;
import main.java.Code;
import main.java.model.GameState;

public class MastermindService {


    public GameState newGame(int colorCount, int fieldCount, int maxTries){
        GameState state = new GameState(colorCount, fieldCount, maxTries);
        return state;

    }

    public GameState guess(GameState current, Code newGuess){
       return current;
    }
}
