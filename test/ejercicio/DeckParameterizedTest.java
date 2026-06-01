package ejercicio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class DeckParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    @DisplayName("Robar carta del mazo con distintos decks")
    public void testDraw(int numDecks) {
        Deck deck = new Deck(numDecks);
        assertNotNull(deck.draw());
    }
}