package de.mobilcom.mastermind.service;
import de.mobilcom.mastermind.model.GameState;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;


class MastermindServiceTest {
    private static final int COLOR_COUNT =6;
    private static final int FIELD_COUNT =4;
    private static final int MAX_TRIES =10;

    @Test
        public void testGameState()
        { MastermindService firstTest = new MastermindService();

        GameState stateTest = firstTest.newGame(COLOR_COUNT, FIELD_COUNT, MAX_TRIES);

            assertEquals(COLOR_COUNT,stateTest.getColors());
            assertEquals(FIELD_COUNT,stateTest.getFields());
            assertEquals(MAX_TRIES,stateTest.getTrycount());
        }
    }


