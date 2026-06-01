package ejercicio;

import java.util.Stack;

/**
 * Jugador humano controlado por consola.
 */
public class HumanPlayer extends Player {

    private ConsoleInput input;

    public HumanPlayer(String name, ConsoleInput input) {
        super(name);
        this.input = input;
    }

    @Override
    public Card playTurn(Deck deck, Stack<Card> discard, boolean canClose) {

        System.out.println("\nTurno de " + name);
        showHand();

        System.out.println("Robar de: 1) Mazo  2) Descarte");
        int option = input.readIntInRange(1, 2);

        if (option == 1) addCard(deck.draw());
        else addCard(discard.pop());

        showHand();

        if (canClose) {
            System.out.println("¿Quieres cerrar? (s/n)");
            if (input.readBooleanUsingChar('s', 'n')) {
                return null;
            }
        }

        System.out.println("Selecciona carta a descartar:");
        int idx = input.readIntInRange(0, hand.size() - 1);

        Card c = hand.get(idx);
        removeCard(c);
        return c;
    }
}