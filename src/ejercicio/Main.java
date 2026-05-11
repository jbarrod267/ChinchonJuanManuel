package ejercicio;

import java.util.Scanner;

/**
 * Clase principal del programa.
 */
public class Main {

    public static void main(String[] args) {

    	ConsoleInput input = new ConsoleInput(new Scanner(System.in));

    	GameBuilder builder = new GameBuilder()
    	        .setInput(input)
    	        .setNumPlayers(3)
    	        .setNumDecks(1);

    	Game game = builder.build();
    	game.setup();
    	game.start();
    }
}