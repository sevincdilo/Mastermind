package main.java.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameState {

    private List<Integer> computerCombination = this.generateCombination();
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
        Collections.shuffle(xCombination);
        System.out.println(xCombination.subList(0,4));
        return xCombination.subList(0,4);
    }

}


