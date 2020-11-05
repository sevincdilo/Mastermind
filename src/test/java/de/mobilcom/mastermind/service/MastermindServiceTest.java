package de.mobilcom.mastermind.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import de.mobilcom.mastermind.model.*;


class MastermindServiceTest {

    private static final int COLOR_COUNT = 6;
    private static final int FIELD_COUNT = 4;
    private static final int MAX_TRIES = 10;
    
    private MastermindService service;

    @BeforeEach
    void setupService() {
    
        service = new MastermindService();
    }
    
    @Test
    @DisplayName("creation of a new GameState")
    void newGame() {

        /*
         * execute
         */
        GameState current = service.newGame(COLOR_COUNT, FIELD_COUNT, MAX_TRIES);

        /*
         * verify
         */
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
    @DisplayName("valid guess on a new game")
    void guess() {
    
        /*
         * prepare
         */    
        GameState current = service.newGame(COLOR_COUNT, FIELD_COUNT, MAX_TRIES);
        int[] newGuess = new int[]{0, 1, 2, 3};
        
        /*
         * execute
         */
        GameState nextState = service.guess(current, newGuess);
        
        /*
         * verify
         */
        assertNotNull(nextState);
        /* expect a new attempt with the new guess */
        assertEquals(1, nextState.getAttempts().size());
        assertArrayEquals(newGuess, nextState.getAttempts().get(0).getPlayerCombination());
    }
    
    /**
     * When a guess is made with a number of elements which is different from the 
     * game state's field count an IllegalArgumentException is expected.
     */
    @Test
    @DisplayName("a new guess with a wrong number of elements is invalid")
    void guessWithInvalidNumberOfElements() {
    
        /*
         * prepare
         */    
        GameState current = service.newGame(COLOR_COUNT, FIELD_COUNT, MAX_TRIES);
        int[] invalidGuess = new int[] {0,1,2,3,4};
        
        /*
         * execute
         */
        assertThrows(IllegalArgumentException.class, () -> service.guess(current, invalidGuess));
    }
    
    /**
     * When a guess is made with an invalid color an IllegalArgumentException is expected.
     */
    @Test
    @DisplayName("a new guess with an invalid color is invalid")
    void guessWithInvalidColor() {
    
        /*
         * prepare
         */    
        GameState current = service.newGame(COLOR_COUNT, FIELD_COUNT, MAX_TRIES);
        int[] invalidGuess = new int[] {0,0,0,COLOR_COUNT};
        
        /*
         * execute
         */
        assertThrows(IllegalArgumentException.class, () -> service.guess(current, invalidGuess));
    }
    
    /**
     * When the list of attempts reached the maximum of tries a new guess is forbidden
     * and leads to an IllegalStateException
     */
    @Test
    @DisplayName("a new guess is not allowed when the game is over")
   // @Disabled("until implementation of guess is complete")
    void guessWhenGameIsOver() {
    
        /*
         * prepare a game state with the maximum number of attempts,
         * the guesses of the attempts are not relevant and are all the same here
         */         
        GameState current = new GameState(COLOR_COUNT, FIELD_COUNT, MAX_TRIES);
        int[] playerCombination = new int[] {0,0,0,0};
        for (int i = 0; i < MAX_TRIES; i++) {
            current.getAttempts().add(new Guess(playerCombination, 0, 0));
        }
        int[] newGuess = new int[] {0,0,0,0};
        
        /*
         * execute
         */
        assertThrows(IllegalStateException.class, () -> service.guess(current, newGuess));
    }
    
    @Test
    @DisplayName("#1 example evaluation of a guess")
    void allColorsWrong() {
    
        /*
         * prepare
         */
        GameState current = createGameState(0,0,0,0);
        int[] newGuess = createGuess(1,1,1,1);
        
        /*
         * execute
         */
        GameState nextState = service.guess(current, newGuess);
        
        /*
         * verify
         */
        assertEvaluation(0, 0, nextState);
    }
    
    @Test
    @DisplayName("#2 example evaluation of a guess")
    void allFieldsCorrect() {
    
        /*
         * prepare
         */
        GameState current = createGameState(0,0,0,0);
        int[] newGuess = createGuess(0, 0, 0, 0);
        
        /*
         * execute
         */
        GameState nextState = service.guess(current, newGuess);
        
        /*
         * verify
         */
        assertEvaluation(4, 0, nextState);
    }

    @Test
    @DisplayName("#3 example evaluation of a guess")
    void mirrorFieldsCase(){

        /*
         * prepare
         */
        GameState current = createGameState(1,1,0,0);
        int[] newGuess = createGuess(0,0,1,1);

        /*
         * execute
         */
        GameState nextState = service.guess(current,newGuess);

        /*
         * verify
         */
        assertEvaluation(0, 4, nextState);
    }

    @Test
    @DisplayName("#4 example evaluation of a guess")
    void mirror2FieldsCase(){

        /*
         * prepare
         */
        GameState current = createGameState(0,0,1,1);
        int[] newGuess = createGuess(1,1,0,0);

        /*
         * execute
         */
        GameState nextState = service.guess(current, newGuess);

        /*
         * verify
         */
        assertEvaluation(0,4, nextState);

    }

    @Test
    @DisplayName("#5 example evaluation of a guess")
    void mixFieldCase(){

        /*
         * prepare
         */
        GameState current = createGameState(1,2,2,3);
        int[] newGuess = createGuess(0,2,3,1);

        /*
         * execute
         */
        GameState nextState = service.guess(current, newGuess);

        /*
         * verify
         */
        assertEvaluation(1,2, nextState);
    }

    @Test
    @DisplayName("#6 example evaluation of a guess")
    void mixedFieldsCase(){

        /*
         * prepare
         */
        GameState current = createGameState(4,2,0,5);
        int[] newGuess = createGuess(1,0,3,5);

        /*
         * execute
         */
        GameState nextState = service.guess(current,newGuess);

        /*
         * verify
         */
        assertEvaluation(1,1,nextState);
    }

    /**
     * Makes an assertion on the given game state.<p/>
     * 
     * It takes the last attempt from the game state and asserts
     * the given values.
     * 
     * @param expectedRightPositionAndColorCount
     * @param expectedRightColorCount
     * @param gameState
     */
    private void assertEvaluation(
        int expectedRightPositionAndColorCount, 
        int expectedRightColorCount, 
        GameState gameState) {
        
        Guess lastGuess = gameState.getAttempts()
            .get(gameState.getAttempts().size() - 1);
            
        assertEquals(expectedRightPositionAndColorCount, lastGuess.getRightPositionAndColorCount());
        assertEquals(expectedRightColorCount, lastGuess.getRightColorCount());
    }

    /**
     * Helper method to create a guess of length 4.
     */
    private int[] createGuess(int c0, int c1, int c2, int c3) {

        return new int[] { c0, c1, c2, c3 };
    }

    /**
     * Helper method which creates a game state with a given computer combination.
     * The game state will have six colors and four fields.
     */
    private GameState createGameState(int c0, int c1, int c2, int c3) {

        GameState result = new GameState(6, 4, 10);
        result.setComputerCombination(new int[] { c0, c1, c2, c3 });

        return result;
    }
}


