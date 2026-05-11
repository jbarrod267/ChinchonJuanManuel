package ejercicio;

import java.util.*;

/**
 * Controla la partida completa.
 */
public class Game {

    private List<Player> players = new ArrayList<>();
    private ConsoleInput input;
    private int numDecks = 1;
    private final int LIMIT = 100;

    public Game(ConsoleInput input) {
        this.input = input;
    }


    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setNumDecks(int numDecks) {
        this.numDecks = numDecks;
    }
    
    /**
     * Configura la partida.
     */
    public void setup() {

        System.out.println("Número de jugadores:");
        int n = input.readIntInRange(2, 5);

        System.out.println("Número de barajas (1 o 2):");
        numDecks = input.readIntInRange(1, 2);

        for (int i = 0; i < n; i++) {

            System.out.println("Jugador " + (i + 1) + " (1 Humano / 2 Máquina):");
            int type = input.readIntInRange(1, 2);

            Player p = PlayerFactory.createPlayer(type, "Jugador " + (i + 1), input);
            players.add(p);
        }
    }

    /**
     * Inicia la partida.
     */
    public void start() {

        while (players.size() > 1) {

        	new Round(players, numDecks).start();

            players.removeIf(p -> p.getPoints() >= LIMIT);
        }

        System.out.println("Ganador: " + players.get(0).getName());
    }
}