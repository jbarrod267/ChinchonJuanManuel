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

        System.out.println("\n====================");
        System.out.println("TURNO DE " + name);
        System.out.println("====================");

        System.out.println("Carta visible del descarte: "
                + discard.peek());

        showHand();

        System.out.println("\nRobar de:");
        System.out.println("1) Mazo");
        System.out.println("2) Descarte");

        int option = input.readIntInRange(1, 2);

        if (option == 1) {
            addCard(deck.draw());
        } else {
            addCard(discard.pop());
        }

        System.out.println("\nTras robar:");

        showHand();

        if (canClose && CombinationHelper.canClose(hand)) {

            System.out.println("\nPuedes cerrar.");
            System.out.println("¿Quieres cerrar? (s/n)");

            if (input.readBooleanUsingChar('s', 'n')) {
                return null;
            }
        }

        System.out.println("\nSelecciona carta a descartar:");

        int idx = input.readIntInRange(0, hand.size() - 1);

        Card c = hand.get(idx);

        removeCard(c);

        return c;
    }
}