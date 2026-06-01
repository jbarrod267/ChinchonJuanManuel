package ejercicio;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationHelperTest {

    @Test
    public void testChinchonValido() {

        List<Card> hand = Arrays.asList(
                new Card(Suit.OROS, 4),
                new Card(Suit.OROS, 5),
                new Card(Suit.OROS, 6),
                new Card(Suit.OROS, 7),
                new Card(Suit.OROS, 8),
                new Card(Suit.OROS, 9),
                new Card(Suit.OROS, 10)
        );

        assertTrue(CombinationHelper.isChinchon(hand));
    }

    @Test
    public void testChinchonInvalido() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.OROS, 4),
                new Card(Suit.COPAS, 5),
                new Card(Suit.OROS, 6),
                new Card(Suit.OROS, 7),
                new Card(Suit.OROS, 10),
                new Card(Suit.OROS, 11),
                new Card(Suit.OROS, 12)
        );

        assertFalse(CombinationHelper.isChinchon(hand));
    }

    @Test
    public void testCanCloseTrue() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.OROS, 3),
                new Card(Suit.OROS, 3),
                new Card(Suit.OROS, 3),
                new Card(Suit.COPAS, 5),
                new Card(Suit.COPAS, 6),
                new Card(Suit.COPAS, 7),
                new Card(Suit.BASTOS, 12)
        );

        assertTrue(CombinationHelper.canClose(hand));
    }

    @Test
    public void testDeadwood() {
        List<Card> hand = Arrays.asList(
                new Card(Suit.OROS, 1),
                new Card(Suit.COPAS, 2),
                new Card(Suit.ESPADAS, 3),
                new Card(Suit.BASTOS, 4),
                new Card(Suit.OROS, 5),
                new Card(Suit.COPAS, 6),
                new Card(Suit.ESPADAS, 7)
        );

        assertTrue(CombinationHelper.calculateDeadwood(hand) >= 0);
    }
}