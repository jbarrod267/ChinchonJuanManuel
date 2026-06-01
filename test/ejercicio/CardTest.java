package ejercicio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testCard() {
        Card c = new Card(Suit.OROS, 7);

        assertEquals(7, c.getValue());
        assertEquals(Suit.OROS, c.getSuit());
        assertEquals(7, c.getPoints());
    }
}