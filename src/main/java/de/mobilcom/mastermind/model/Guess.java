package de.mobilcom.mastermind.model;

import java.util.ArrayList;

public class Guess {

    private int[] attempts;
    private int rightPositionAndColorCount;
    private int rightColorCount;

    public Guess(int[] versuche, int rightPositionAndColorCount, int rightColorCount) {
        this.attempts = versuche;
        this.rightPositionAndColorCount = rightPositionAndColorCount;
        this.rightColorCount = rightColorCount;
    }

    public int[] getVersuche() {
        return attempts;
    }

    public void setVersuche(int[] versuche) {
        this.attempts = versuche;
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

}

