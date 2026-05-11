package ejercicio;

/**
 * Fábrica para crear jugadores del juego.
 */
public class PlayerFactory {

    /**
     * Crea un jugador según el tipo indicado.
     * 
     * @param type 1 = humano, 2 = máquina
     * @param name nombre del jugador
     * @param input entrada por consola (solo para humanos)
     * @return instancia de Player
     */
    public static Player createPlayer(int type, String name, ConsoleInput input) {
        switch (type) {
            case 1:
                return new HumanPlayer(name, input);
            case 2:
                return new AIPlayer(name);
            default:
                throw new IllegalArgumentException("Tipo de jugador no válido");
        }
    }
}