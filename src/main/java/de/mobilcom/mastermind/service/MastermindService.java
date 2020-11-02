package de.mobilcom.mastermind.service;

import de.mobilcom.mastermind.model.GameState;
import de.mobilcom.mastermind.model.Guess;



public class MastermindService {

    public GameState newGame(int colorCount, int fieldCount, int maxTries) {
        GameState state = new GameState(colorCount, fieldCount, maxTries);
        return state;

    }

    public GameState guess(GameState current, int[] newGuess) throws IllegalArgumentException {


        /* check for correct length */
        if (newGuess.length != current.getFields()) {
            throw new IllegalArgumentException("invalid guess length");

        }

        /* check for valid colors */
        for (int i = 0; i < newGuess.length; i++) {
            int item = newGuess[i];
            // newGuess = [0,-1,0,0]
            if (item >= current.getColors() || item < 0) {
                throw new IllegalArgumentException("invalid color at index " + i + " : " + item);
            }
        }

        int rightPositionAndColorCount = 0;
        int rightColorCount = 0;

        boolean[] check2 = new boolean[current.getFields()];
        for (int i = 0; i < current.getFields(); i++) {
            if (current.getComputerCombination()[i] == newGuess[i]) {
                rightPositionAndColorCount++;
                check2[i] = true;
            }
        }

        boolean[] checked = new boolean[current.getFields()];
        for (int i = 0; i < current.getFields(); i++) {
            for (int j = 0; j < newGuess.length; j++) {
                if (i != j && current.getComputerCombination()[i] == newGuess[j] && !checked[j] && !check2[j]) {
                    rightColorCount++;
                    checked[j] = true;
                    break;
                }
            }
        }

        // TODO werte berechnen


        // max tries check
        Guess guess = new Guess(newGuess, rightPositionAndColorCount, rightColorCount);

        current.getAttempts().add(guess);

        if (rightPositionAndColorCount == current.getFields()) {
            return current;
        }

        if (current.getAttempts().size() >= current.getTryCount()) {
            throw new IllegalStateException(current);
        }


        return current;
    }
}

