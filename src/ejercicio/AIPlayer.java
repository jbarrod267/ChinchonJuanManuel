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

        System.out.println("\n--------------------");
        System.out.println("Turno de " + name);
        System.out.println("--------------------");

        Card robada = deck.draw();

        addCard(robada);

        System.out.println(name + " roba: " + robada);

        if (canClose && CombinationHelper.canClose(hand)) {

            System.out.println(name + " decide cerrar.");
            return null;
        }

        Card descartada =
                hand.get(new Random().nextInt(hand.size()));

        removeCard(descartada);

        System.out.println(name + " descarta: " + descartada);

        return descartada;
    }
}