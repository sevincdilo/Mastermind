package de.mobilcom.mastermind.model;

public class Guess {

    private int[] playerCombination;
    private int rightPositionAndColorCount;
    private int rightColorCount;

    public Guess(int[] playerCombination, int rightPositionAndColorCount, int rightColorCount) {
        this.playerCombination = playerCombination;
        this.rightPositionAndColorCount = rightPositionAndColorCount;
        this.rightColorCount = rightColorCount;
    }

    public int[] getPlayerCombination() {
        return playerCombination;
    }

    public void setPlayerCombination(int[] playerCombination) {
        this.playerCombination = playerCombination;
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

