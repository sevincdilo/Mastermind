package de.mobilcom.mastermind.model;

import de.mobilcom.mastermind.service.MastermindService;

import java.util.*;

public class GameState  {

    private int[] computerCombination;
    private int colors;
    private int fields;
    private int tryCount;
    private List<Guess> attempts;
    Random random = new Random();

    public GameState(int colors, int fields, int tryCount) {
        this.colors = colors;
        this.fields = fields;
        this.tryCount = tryCount;
        this.attempts = new ArrayList<>();
        this.computerCombination = generateComputerCombination(fields, colors);
    }

    public int getColors() {

        return colors;
    }

    public void setColors(int colors) {

        this.colors = colors;
    }

    public int getFields() {
        return fields;
    }

    public void setFields(int fields) {
        this.fields = fields;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public List<Guess> getAttempts() {
        return attempts;
    }


    public int[] getComputerCombination() {
        return computerCombination;
    }

    public void setComputerCombination(int[] computerCombination) {
        this.computerCombination = computerCombination;
    }

    /**
     * Creates a random combination of size {@link #fields} where
     * each item is one of 1, ..., {@link #colors}.
     *
     * @param fields
     * @param colors
     * @return an int array of size #fields.
     */
    private int[] generateComputerCombination(int fields, int colors) {

        int[] result = new int[fields];

        for (int i = 0; i < fields; i++) {
            result[i] = random.nextInt(colors);
        }

        return result;
    }

    

}








