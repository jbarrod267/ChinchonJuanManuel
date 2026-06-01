package ejercicio;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder para construir una instancia de Game de forma progresiva y configurable.
 * Permite definir parámetros como número de jugadores, número de barajas y la entrada de usuario.
 * Facilita la creación del objeto Game evitando constructores complejos.
 */
public class GameBuilder {

    private ConsoleInput input;
    private int numPlayers;
    private int numDecks;
    private List<Player> players = new ArrayList<>();

    /**
     * Establece la entrada por consola utilizada en el juego.
     * 
     * @param input objeto ConsoleInput para interacción con el usuario
     * @return el propio builder (fluidez)
     */
    public GameBuilder setInput(ConsoleInput input) {
        this.input = input;
        return this;
    }

    /**
     * Establece el número de jugadores del juego.
     * 
     * @param numPlayers número de jugadores
     * @return el propio builder
     */
    public GameBuilder setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
        return this;
    }

    /**
     * Establece el número de barajas que se usarán en la partida.
     * 
     * @param numDecks número de barajas (1 o 2)
     * @return el propio builder
     */
    public GameBuilder setNumDecks(int numDecks) {
        this.numDecks = numDecks;
        return this;
    }

    /**
     * Añade un jugador manualmente a la partida.
     * 
     * @param player jugador a añadir
     * @return el builder
     */
    public GameBuilder addPlayer(Player player) {
        players.add(player);
        return this;
    }

    /**
     * Construye la instancia final de Game usando los parámetros configurados.
     * 
     * @return objeto Game listo para jugar
     */
    public Game build() {
        Game game = new Game(input);
        game.setPlayers(players);
        game.setNumDecks(numDecks);
        return game;
    }
}