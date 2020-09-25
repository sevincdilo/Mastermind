package main.java;

import java.util.ArrayList;

public class Guess {

    private int[] versuche;
    private int rightPositionAndColorCount;
    private int rightColorCount;

    public Guess(int[] versuche, int rightPositionAndColorCount, int rightColorCount) {
        this.versuche = versuche;
        this.rightPositionAndColorCount = rightPositionAndColorCount;
        this.rightColorCount = rightColorCount;
    }

    public int[] getVersuche() {
        return versuche;
    }

    public void setVersuche(int[] versuche) {
        this.versuche = versuche;
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

