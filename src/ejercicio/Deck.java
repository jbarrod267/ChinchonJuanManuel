package ejercicio;

import java.util.*;

/**
 * Representa el mazo de cartas.
 */
public class Deck {

    private List<Card> cards;

    /**
     * Crea un mazo con 1 o 2 barajas.
     */
    public Deck(int numDecks) {
        cards = new ArrayList<>();

        for (int d = 0; d < numDecks; d++) {
            for (Suit suit : Suit.values()) {

                for (int v = 1; v <= 7; v++)
                    cards.add(new Card(suit, v));

                for (int v = 10; v <= 12; v++)
                    cards.add(new Card(suit, v));
            }
        }

        Collections.shuffle(cards);
    }

    public Deck() {
        cards = new ArrayList<>();
    }

    public void setCards(List<Card> newCards) {
        cards = newCards;
    }

    /**
     * Roba una carta.
     */
    public Card draw() {
        if (cards.isEmpty()) return null;
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}