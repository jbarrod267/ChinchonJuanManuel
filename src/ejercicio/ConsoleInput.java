package ejercicio;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase encargada de gestionar la entrada de datos por consola.
 * 
 * Proporciona métodos seguros para leer distintos tipos de datos
 * evitando errores de entrada del usuario.
 */
public class ConsoleInput {

	private Scanner keyboard;

	/**
	 * Constructor que recibe el Scanner de entrada.
	 * 
	 * @param keyboard Scanner usado para leer datos desde consola
	 */
	public ConsoleInput(Scanner keyboard) {
		this.keyboard = keyboard;
	}

	/**
	 * Limpia el buffer del Scanner para evitar errores de lectura.
	 */
	private void cleanInput() {
		keyboard.nextLine();
	}

	// -------------------- INT --------------------

	/**
	 * Lee un número entero desde consola.
	 * 
	 * @return entero introducido por el usuario
	 */
	public int readInt() {
		int value = 0;
		boolean valid = false;

		do {
			try {
				System.out.print("Introduce un entero: ");
				value = keyboard.nextInt();
				valid = true;
			} catch (InputMismatchException e) {
				System.err.println("Error: no es un entero válido.");
			} finally {
				cleanInput();
			}
		} while (!valid);

		return value;
	}

	/**
	 * Lee un entero dentro de un rango.
	 * 
	 * @param lowerBound límite inferior
	 * @param upperBound límite superior
	 * @return entero dentro del rango
	 */
	public int readIntInRange(int lowerBound, int upperBound) {
		if (lowerBound > upperBound) {
			throw new IllegalArgumentException("Rango incorrecto");
		}

		int value;
		do {
			value = readInt();
			if (value < lowerBound || value > upperBound) {
				System.err.println("Debe estar entre " + lowerBound + " y " + upperBound);
			}
		} while (value < lowerBound || value > upperBound);

		return value;
	}

	/**
	 * Lee un entero positivo (> 0).
	 * 
	 * @return entero positivo
	 */
	public int readPositiveInt() {
		return readIntGreaterThan(0);
	}

	/**
	 * Lee un entero mayor que un valor mínimo.
	 * 
	 * @param lowerBound valor mínimo
	 * @return entero válido
	 */
	public int readIntGreaterThan(int lowerBound) {
		int value;
		do {
			value = readInt();
			if (value <= lowerBound) {
				System.err.println("Debe ser mayor que " + lowerBound);
			}
		} while (value <= lowerBound);
		return value;
	}

	// -------------------- DOUBLE --------------------

	/**
	 * Lee un número decimal double.
	 * 
	 * @return double introducido por el usuario
	 */
	public double readDouble() {
		double value = 0;
		boolean valid = false;

		do {
			try {
				System.out.print("Introduce un double: ");
				value = keyboard.nextDouble();
				valid = true;
			} catch (InputMismatchException e) {
				System.err.println("Error: no es un double válido.");
			} finally {
				cleanInput();
			}
		} while (!valid);

		return value;
	}

	// -------------------- FLOAT --------------------

	/**
	 * Lee un número decimal float.
	 * 
	 * @return float introducido por el usuario
	 */
	public float readFloat() {
		float value = 0;
		boolean valid = false;

		do {
			try {
				System.out.print("Introduce un float: ");
				value = keyboard.nextFloat();
				valid = true;
			} catch (InputMismatchException e) {
				System.err.println("Error: no es un float válido.");
			} finally {
				cleanInput();
			}
		} while (!valid);

		return value;
	}

	// -------------------- BYTE --------------------

	/**
	 * Lee un valor byte (-128 a 127).
	 * 
	 * @return byte introducido por el usuario
	 */
	public byte readByte() {
		byte value = 0;
		boolean valid = false;

		do {
			try {
				System.out.print("Introduce un byte (-128 a 127): ");
				value = keyboard.nextByte();
				valid = true;
			} catch (InputMismatchException e) {
				System.err.println("Error: no es un byte válido.");
			} finally {
				cleanInput();
			}
		} while (!valid);

		return value;
	}

	// -------------------- STRING --------------------

	/**
	 * Lee una cadena de texto.
	 * 
	 * @return string introducido
	 */
	public String readString() {
		System.out.print("Introduce una cadena: ");
		return keyboard.nextLine();
	}

	/**
	 * Lee una cadena no vacía.
	 * 
	 * @return string válido
	 */
	public String readNonEmptyString() {
		String value;
		do {
			System.out.print("Introduce una cadena no vacía: ");
			value = keyboard.nextLine().trim();
			if (value.isEmpty()) {
				System.err.println("La cadena no puede estar vacía.");
			}
		} while (value.isEmpty());

		return value;
	}

	// -------------------- CHAR --------------------

	/**
	 * Lee un carácter.
	 * 
	 * @return carácter introducido
	 */
	public char readChar() {
		String input;
		do {
			System.out.print("Introduce un carácter: ");
			input = keyboard.nextLine();
			if (input.length() != 1) {
				System.err.println("Debes introducir solo un carácter.");
			}
		} while (input.length() != 1);

		return input.charAt(0);
	}

	// -------------------- BOOLEAN --------------------

	/**
	 * Lee un booleano (si/no).
	 * 
	 * @return true si "si", false si "no"
	 */
	public boolean readBoolean() {
		String input;
		do {
			System.out.print("Introduce si/no: ");
			input = keyboard.nextLine().toLowerCase();
			if (!input.equals("si") && !input.equals("no")) {
				System.err.println("Debes escribir 'si' o 'no'.");
			}
		} while (!input.equals("si") && !input.equals("no"));

		return input.equals("si");
	}

	/**
	 * Lee un booleano usando caracteres personalizados.
	 * 
	 * @param affirmativeValue valor positivo
	 * @param negativeValue valor negativo
	 * @return true si coincide con affirmativeValue
	 */
	public boolean readBooleanUsingChar(char affirmativeValue, char negativeValue) {
		char af = Character.toLowerCase(affirmativeValue);
		char ne = Character.toLowerCase(negativeValue);

		if (af == ne) {
			throw new IllegalArgumentException("Los caracteres deben ser distintos");
		}

		char input;
		do {
			input = Character.toLowerCase(readChar());
			if (input != af && input != ne) {
				System.err.println("Introduce '" + affirmativeValue + "' o '" + negativeValue + "'");
			}
		} while (input != af && input != ne);

		return input == af;
	}

	/**
	 * Lee un booleano con mensaje de error personalizado.
	 */
	public boolean readBooleanUsingChar(char affirmativeValue, char negativeValue, String errorMessage) {
		char af = Character.toLowerCase(affirmativeValue);
		char ne = Character.toLowerCase(negativeValue);

		if (af == ne) {
			throw new IllegalArgumentException("Los caracteres deben ser distintos");
		}

		char input;
		do {
			input = Character.toLowerCase(readChar());
			if (input != af && input != ne) {
				System.err.println(errorMessage);
			}
		} while (input != af && input != ne);

		return input == af;
	}
}