package de.mobilcom.mastermind.service;

import de.mobilcom.mastermind.model.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class MastermindServiceTest {
    private static final int COLOR_COUNT = 6;
    private static final int FIELD_COUNT = 4;
    private static final int MAX_TRIES = 10;
    // private static final int[] newGuess =

    @Test
    public void testGameState() {
        MastermindService service = new MastermindService();

        GameState current = service.newGame(COLOR_COUNT, FIELD_COUNT, MAX_TRIES);

        assertEquals(COLOR_COUNT, current.getColors());
        assertEquals(FIELD_COUNT, current.getFields());
        assertEquals(MAX_TRIES, current.getTryCount());
        assertTrue(current.getAttempts().isEmpty());
        assertNotNull(current.getComputerCombination());
        assertEquals(FIELD_COUNT, current.getComputerCombination().length);
        for (int i = 0; i < FIELD_COUNT; i++) {
            int color = current.getComputerCombination()[i];
            assertTrue(0 <= color);
            assertTrue(color < COLOR_COUNT);

        }
    }

    @Test
    public void testGameStateGuess() {
        MastermindService service = new MastermindService();
        GameState current = service.newGame(COLOR_COUNT, FIELD_COUNT, MAX_TRIES);
        GameState nextState = service.guess(current, new int[]{0, 1, 2, 3});
    }
}


