package de.mobilcom.mastermind.model;

import java.util.*;

public class GameState {  // guesses um einzelne versuche zu speichern

    private int[] computerCombination;
    private int colors;
    private int fields;
    private int trycount;
    private Guess[] attemps;


    public GameState(int colors, int fields, int trycount) {
        this.colors = colors;
        this.fields = fields;
        this.trycount = trycount;
       // this.computerCombination =this.generateComputerCombination();
      //  this.attemps = ;

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


    /**
     * Creates a random combination of size {@link #fields} where
     * each item is one of 1, ..., {@link #colors}.
     *
     * @return
     */
//    public int[] generateComputerCombination() {
//        List<Integer> selectedNumbers = new ArrayList<Integer>();
//        Random combination = new Random();
//        int colors;
//
//        for(int i=0; i< colors; i++){
//            int randomIndex = combination.nextInt(selectedNumbers());
//            Integer randomElement = selectedNumbers.get(randomIndex);
//            selectedNumbers.add(randomElement);
//        }
//        System.out.println(selectedNumbers);
//        return selectedNumbers;
//
//    }

    public int generateComputerCombination() {
        Integer[] computerCombination = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = Arrays.asList(computerCombination);
        Collections.shuffle(list);
        list.toArray(computerCombination);
        return computerCombination[0-3];
    }








