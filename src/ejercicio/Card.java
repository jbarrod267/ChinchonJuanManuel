package ejercicio;

/**
 * Representa una carta de la baraja española.
 */
public class Card {

    private Suit suit;
    private int value;

    /**
     * Constructor de carta.
     * @param suit palo
     * @param value valor
     */
    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() { return suit; }

    public int getValue() { return value; }

    /**
     * Devuelve los puntos de la carta.
     */
    public int getPoints() {
        return value;
    }

    @Override
    public String toString() {

        String simbolo = switch (suit) {
            case OROS -> "♦";
            case COPAS -> "♥";
            case ESPADAS -> "♠";
            case BASTOS -> "♣";
        };

        return value + simbolo;
    }
}