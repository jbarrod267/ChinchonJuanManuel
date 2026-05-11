package ejercicio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerFactoryTest {

    @Test
    public void testHumanPlayer() {
        Player p = PlayerFactory.createPlayer(1, "Juan", null);
        assertTrue(p instanceof HumanPlayer);
    }

    @Test
    public void testAIPlayer() {
        Player p = PlayerFactory.createPlayer(2, "Bot", null);
        assertTrue(p instanceof AIPlayer);
    }

    @Test
    public void testInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> PlayerFactory.createPlayer(99, "X", null));
    }
}