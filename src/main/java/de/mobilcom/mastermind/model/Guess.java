package de.mobilcom.mastermind.model;

import java.util.ArrayList;

public class Guess {

    private int[] playerCombination;
    private int rightPositionAndColorCount;
    private int rightColorCount;
    private int[] attemps;

    public Guess(int[] playMove, int rightPositionAndColorCount, int rightColorCount) {
        this.playerCombination = playMove; // spieler combination
        this.rightPositionAndColorCount = rightPositionAndColorCount;
        this.rightColorCount = rightColorCount;
    }

    public int[] getPlayMove() {
        return playerCombination;
    }

    public void setPlayMove(int[] playMove) {
        this.playerCombination = playMove;
    }

    public int getRightPositionAndColorCount() {
        return rightPositionAndColorCount;
    }

    public void setRightPositionAndColorCount(int rightPositionAndColorCount) {
        this.rightPositionAndColorCount = rightPositionAndColorCount;
    }

    public int getRightColorCount() {
        return rightColorCount;
    }

    public void setRightColorCount(int rightColorCount) {
        this.rightColorCount = rightColorCount;
    }

    public int[] getAttemps() {
        return attemps;
    }


}

