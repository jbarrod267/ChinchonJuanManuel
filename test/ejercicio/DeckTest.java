package ejercicio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void testDraw() {
        Deck deck = new Deck(1);
        assertNotNull(deck.draw());
    }

    @Test
    public void testEmptyDeck() {
        Deck deck = new Deck();
        assertTrue(deck.isEmpty());
    }
}