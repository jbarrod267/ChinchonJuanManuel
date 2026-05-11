package ejercicio;

import java.util.*;

/**
 * Clase utilitaria encargada de evaluar y gestionar las combinaciones de cartas
 * en el juego de Chinchón.
 *
 * Permite detectar:
 * - Chinchón (7 cartas consecutivas del mismo palo)
 * - Combinaciones válidas para cerrar la partida
 * - Cálculo de cartas no combinadas (deadwood)
 *
 * Todas las operaciones trabajan sobre listas de cartas sin modificar el estado del jugador.
 */
public class CombinationHelper {

    /**
     * Comprueba si una mano forma un chinchón.
     * Debe contener exactamente 7 cartas del mismo palo en orden consecutivo.
     *
     * @param hand lista de cartas del jugador
     * @return true si es chinchón, false en caso contrario
     */
    public static boolean isChinchon(List<Card> hand) {
        if (hand.size() != 7) return false;

        List<Card> sorted = new ArrayList<>(hand);
        sorted.sort(Comparator.comparing(Card::getValue));

        Suit suit = sorted.get(0).getSuit();

        for (Card c : sorted)
            if (c.getSuit() != suit) return false;

        for (int i = 0; i < sorted.size() - 1; i++)
            if (sorted.get(i + 1).getValue() != sorted.get(i).getValue() + 1)
                return false;

        return true;
    }

    /**
     * Indica si el jugador puede cerrar la partida.
     * Se considera válido si tiene al menos 6 cartas combinadas.
     *
     * @param hand mano del jugador
     * @return true si puede cerrar, false si no
     */
    public static boolean canClose(List<Card> hand) {
        return countValidCards(hand) >= 6;
    }

    /**
     * Calcula la suma de puntos de las cartas no combinadas.
     *
     * @param hand mano del jugador
     * @return suma de puntos de cartas sueltas
     */
    public static int calculateDeadwood(List<Card> hand) {

        List<Card> temp = new ArrayList<>(hand);

        removeSets(temp);
        removeRuns(temp);

        int sum = 0;
        for (Card c : temp) sum += c.getPoints();

        return sum;
    }

    /**
     * Cuenta cuántas cartas pertenecen a combinaciones válidas.
     */
    private static int countValidCards(List<Card> hand) {
        List<Card> temp = new ArrayList<>(hand);
        return removeSets(temp) + removeRuns(temp);
    }

    /**
     * Elimina tríos o más cartas del mismo valor.
     *
     * @param cards lista modificable de cartas
     * @return número de cartas usadas en combinaciones
     */
    private static int removeSets(List<Card> cards) {

        Map<Integer, List<Card>> map = new HashMap<>();

        for (Card c : cards)
            map.computeIfAbsent(c.getValue(), k -> new ArrayList<>()).add(c);

        int used = 0;

        for (List<Card> group : map.values()) {
            if (group.size() >= 3) {
                used += group.size();
                cards.removeAll(group);
            }
        }

        return used;
    }

    /**
     * Elimina escaleras de al menos 3 cartas consecutivas del mismo palo.
     *
     * @param cards lista modificable de cartas
     * @return número de cartas usadas en combinaciones
     */
    private static int removeRuns(List<Card> cards) {

        cards.sort(Comparator.comparing(Card::getSuit)
                .thenComparing(Card::getValue));

        int used = 0;
        List<Card> run = new ArrayList<>();
        List<Card> toRemove = new ArrayList<>();

        for (Card c : cards) {

            if (run.isEmpty()) {
                run.add(c);
            } else {

                Card last = run.get(run.size() - 1);

                if (c.getSuit() == last.getSuit()
                        && c.getValue() == last.getValue() + 1) {
                    run.add(c);
                } else {

                    if (run.size() >= 3) {
                        used += run.size();
                        toRemove.addAll(run);
                    }

                    run.clear();
                    run.add(c);
                }
            }
        }

        if (run.size() >= 3) {
            used += run.size();
            toRemove.addAll(run);
        }

        cards.removeAll(toRemove);

        return used;
    }
}