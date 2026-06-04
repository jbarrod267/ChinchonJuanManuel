package ejercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Clase abstracta que representa un jugador.
 */
public abstract class Player {

    protected String name;
    protected List<Card> hand = new ArrayList<>();
    protected int points = 0;

    public Player(String name) {
        this.name = name;
    }

    public void addCard(Card c) { hand.add(c); }

    public void removeCard(Card c) { hand.remove(c); }

    public List<Card> getHand() { return hand; }

    public int getPoints() { return points; }

    public void addPoints(int p) { points += p; }

    public String getName() { return name; }

    /**
     * Muestra las cartas en mano.
     */
    public void showHand() {

        System.out.println("\nMano de " + name + ":");

        for (int i = 0; i < hand.size(); i++) {
            System.out.println("[" + i + "] " + hand.get(i));
        }
    }

    /**
     * Método abstracto para jugar turno.
     */
    public abstract Card playTurn(Deck deck, Stack<Card> discard, boolean canClose);
}