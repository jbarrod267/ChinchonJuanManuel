package ejercicio;

import java.util.Random;
import java.util.Stack;

/**
 * Representa un jugador controlado por la máquina (IA).
 * Su comportamiento es automático y aleatorio.
 */
public class AIPlayer extends Player {

    /**
     * Constructor de la IA.
     * @param name nombre del jugador
     */
    public AIPlayer(String name) {
        super(name);
    }

    /**
     * Ejecuta el turno del jugador IA.
     * Roba una carta y descarta una aleatoria.
     * Puede cerrar si cumple condiciones.
     */
    @Override
    public Card playTurn(Deck deck, Stack<Card> discard, boolean canClose) {
        addCard(deck.draw());

        if (canClose && CombinationHelper.canClose(hand)) {
            return null;
        }

        Card c = hand.get(new Random().nextInt(hand.size()));
        removeCard(c);
        return c;
    }
}