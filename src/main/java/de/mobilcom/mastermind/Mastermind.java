package de.mobilcom.mastermind;

import de.mobilcom.mastermind.frontend.Terminal;
import de.mobilcom.mastermind.model.GameState;
import de.mobilcom.mastermind.service.MastermindService;

public class Mastermind {
    public static void main(String[] args) {
        MastermindService service = new MastermindService();
       // service.newGame(6, 4, 10);
        System.out.println("Mastermind Game");
        Terminal terminal = new Terminal();
        terminal.start(service.newGame(6,4,7));

    }
}
