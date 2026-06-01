package ejercicio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationHelperParameterizedTest {

    static Stream<List<Card>> chinchonValidos() {
        return Stream.of(
                Arrays.asList(
                        new Card(Suit.OROS, 4),
                        new Card(Suit.OROS, 5),
                        new Card(Suit.OROS, 6),
                        new Card(Suit.OROS, 7),
                        new Card(Suit.OROS, 8),
                        new Card(Suit.OROS, 9),
                        new Card(Suit.OROS, 10)
                )
        );
    }

    static Stream<List<Card>> chinchonInvalidos() {
        return Stream.of(
                Arrays.asList(
                        new Card(Suit.OROS, 4),
                        new Card(Suit.COPAS, 5),
                        new Card(Suit.OROS, 6),
                        new Card(Suit.OROS, 7),
                        new Card(Suit.OROS, 8),
                        new Card(Suit.OROS, 9),
                        new Card(Suit.OROS, 10)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("chinchonValidos")
    @DisplayName("Chinchón válido")
    public void testChinchonValido(List<Card> hand) {
        assertTrue(CombinationHelper.isChinchon(hand));
    }

    @ParameterizedTest
    @MethodSource("chinchonInvalidos")
    @DisplayName("Chinchón inválido")
    public void testChinchonInvalido(List<Card> hand) {
        assertFalse(CombinationHelper.isChinchon(hand));
    }
}