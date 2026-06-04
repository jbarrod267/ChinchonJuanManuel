package ejercicio;

import java.util.*;

/**
 * Gestiona una ronda del juego.
 */
public class Round {

    private List<Player> players;
    private Deck deck;
    private Stack<Card> discard = new Stack<>();
    private int reshuffleCount = 0;

    public Round(List<Player> players, int numDecks) {
        this.players = players;
        this.deck = new Deck(numDecks);
    }

    /**
     * Inicia la ronda.
     */
    public Player start() {

        for (int i = 0; i < 7; i++)
            for (Player p : players)
                p.addCard(deck.draw());

        discard.push(deck.draw());
        
        System.out.println("\n=================================");
        System.out.println("COMIENZA UNA NUEVA RONDA");
        System.out.println("=================================");

        System.out.println("Carta inicial del descarte: "
                + discard.peek());

        boolean firstTurn = true;

        while (true) {

            for (Player p : players) {

            	System.out.println("\nCarta superior del descarte: "
            	        + discard.peek());
            	
                if (deck.isEmpty()) {
                    if (reshuffleCount < 2) reshuffleDeck();
                    else return null;
                }

                Card result = p.playTurn(deck, discard, !firstTurn);

                if (result == null) {
                	if (!firstTurn && CombinationHelper.canClose(p.getHand())) {

                	    System.out.println("\n" + p.getName()
                	            + " HA CERRADO LA RONDA");

                	    score(p);

                	    return p;
                	}
                } else {
                    discard.push(result);
                }

                if (!firstTurn && CombinationHelper.isChinchon(p.getHand())) {
                    System.out.println(p.getName() + " GANA POR CHINCHÓN!");
                    return p;
                }
            }

            firstTurn = false;
        }
    }

    private void reshuffleDeck() {

    	System.out.println(
    	        "\nEl mazo se ha agotado. Rebarajando descarte...");
    	
        if (discard.isEmpty()) return;

        Card top = discard.pop();

        List<Card> newDeckCards = new ArrayList<>(discard);
        Collections.shuffle(newDeckCards);

        discard.clear();
        discard.push(top);

        deck = new Deck();
        deck.setCards(newDeckCards);

        reshuffleCount++;
    }

    private void score(Player closer) {

        System.out.println("\n=================================");
        System.out.println("PUNTUACIONES");
        System.out.println("=================================");

        for (Player p : players) {

            int points =
                    CombinationHelper.calculateDeadwood(
                            p.getHand());

            if (p == closer && points == 0)
                p.addPoints(-10);
            else
                p.addPoints(points);

            System.out.println(
                    p.getName()
                    + " -> "
                    + p.getPoints()
                    + " puntos");
        }
    }
}