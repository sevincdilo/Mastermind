package de.mobilcom.mastermind.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameState {  // guesses um einzelne versuche zu speichern

    private List<Integer> allColors= this.generateCombination();
    private List<Integer> computerCombination = this.xCombination_RandomElements();
    private int colors;
    private int fields;
    private int trycount;


    public GameState(int colors, int fields, int trycount) {
        this.colors = colors;
        this.fields = fields;
        this.trycount = trycount;

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


    private List<Integer> generateCombination() {
        ArrayList<Integer> xCombination = new ArrayList<Integer>();
        xCombination.add(1);
        xCombination.add(2);
        xCombination.add(3);
        xCombination.add(4);
        xCombination.add(5);
        xCombination.add(6);
        xCombination.add(7);
        xCombination.add(8);

        return xCombination;

    }

    public List<Integer> xCombination_RandomElements() {
        List<Integer> selectedNumbers = new ArrayList<Integer>();
        Random rand = new Random();
        int numberOfElements = 4;

        for(int i=0; i< numberOfElements; i++){
            int randomIndex = rand.nextInt(this.allColors.size());
            Integer randomElement = this.allColors.get(randomIndex);
            selectedNumbers.add(randomElement);
        }
        return selectedNumbers;
    }

}


