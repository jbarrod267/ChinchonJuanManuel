package ejercicio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CardParameterizedTest {

    static Stream<Object[]> cardProvider() {
        return Stream.of(
                new Object[]{Suit.OROS, 7},
                new Object[]{Suit.COPAS, 1},
                new Object[]{Suit.ESPADAS, 12},
                new Object[]{Suit.BASTOS, 5}
        );
    }

    @ParameterizedTest
    @MethodSource("cardProvider")
    @DisplayName("Test parametrizado de Card")
    public void testCard(Suit suit, int value) {
        Card c = new Card(suit, value);

        assertEquals(value, c.getValue());
        assertEquals(suit, c.getSuit());
        assertEquals(value, c.getPoints());
    }
}