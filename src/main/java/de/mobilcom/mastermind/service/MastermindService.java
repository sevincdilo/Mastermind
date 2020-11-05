package de.mobilcom.mastermind.service;

import de.mobilcom.mastermind.model.GameState;
import de.mobilcom.mastermind.model.Guess;

/**
 * Creates new games and is able to calculate new game states from
 * given game states by evaluating new guesses.
 */
public class MastermindService {

    /**
     * Creates a new game state with the given game parameters.
     *
     * @param colorCount the number of colors to be chosen for each field.
     *                   The colors will have values &gt;=0
     *                   and &lt; colorCount
     * @param fieldCount the number of fields to be guessed
     * @param maxTries   the maxmimum number of tries/attempts.
     * @return a new game state with the given parameters and an empty list of attempts
     */
    public GameState newGame(int colorCount, int fieldCount, int maxTries) {
        GameState state = new GameState(colorCount, fieldCount, maxTries);
        return state;

    }

    /**
     * Calculates a new game state based on the given game state and a new guess.<p/>
     * <p>
     * If the newGuess has an invalid length or contains invalid color values
     * an IllegalArgumentException will be thrown.<br/>
     * If the given game state already has a list of attempts with the
     * size of the maximum tries an IllegalArgumentException will be thrown
     * (game is already over, no more guesses allowed).<p/>
     * <p>
     * Afterwards the returned game state will be a "copy" of the given
     * game state with one more attempt. The last attempt will
     * be the new evaluated guess.
     *
     * @param current
     * @param newGuess
     * @return
     * @throws IllegalArgumentException
     */


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

        if (current.getAttempts().size() >= current.getTryCount()) {
            throw new IllegalStateException("game already finished");
        }


        int rightPositionAndColorCount = 0;
        int rightColorCount = 0;

        boolean[] check2 = new boolean[current.getFields()];
        for (
                int i = 0; i < current.getFields(); i++) {
            if (current.getComputerCombination()[i] == newGuess[i]) {
                rightPositionAndColorCount++;
                check2[i] = true;
            }
        }

        boolean[] checked = new boolean[current.getFields()];
        for (
                int i = 0; i < current.getFields(); i++) {
            for (int j = 0; j < newGuess.length; j++) {
                if (i != j && current.getComputerCombination()[i] == newGuess[j] && !checked[j] && !check2[j]) {
                    rightColorCount++;
                    checked[j] = true;
                    break;
                }
            }
        }
        Guess guess = new Guess(newGuess, rightPositionAndColorCount, rightColorCount);

        current.getAttempts().add(guess);
        return current;
    }

}

// TODO werte berechnen



