package main.java;

import main.java.service.MastermindService;

public class Mastermind {
    public static void main(String[] args) {
        MastermindService service = new MastermindService();
        service.newGame(1,2,3);
    }
}
