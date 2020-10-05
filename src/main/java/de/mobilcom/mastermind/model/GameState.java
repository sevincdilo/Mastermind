package de.mobilcom.mastermind.model;

import java.util.*;

public class GameState {  // guesses um einzelne versuche zu speichern

    private int[] computerCombination;
    private int colors;
    private int fields;
    private int trycount;
    private List<Guess> attempts;
    Random random = new Random();

    public GameState(int colors, int fields, int trycount) {
        this.colors = colors;
        this.fields = fields;
        this.trycount = trycount;
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

    public int getTrycount() {
        return trycount;
    }

    public void setTrycount(int trycount) {
        this.trycount = trycount;
    }

    public List<Guess> getAttempts() {
        return attempts;
    }

    public int[] getComputerCombination() {
        return computerCombination;
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

        for (int i=0;i<fields;i++) {
            result[i] = random.nextInt(colors);
        }

        return result;
    }
}








