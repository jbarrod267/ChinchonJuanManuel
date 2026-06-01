package ejercicio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerFactoryParameterizedTest {

    static Stream<Object[]> playerProvider() {
        return Stream.of(
                new Object[]{1, HumanPlayer.class},
                new Object[]{2, AIPlayer.class}
        );
    }

    @ParameterizedTest
    @MethodSource("playerProvider")
    @DisplayName("Factory crea jugadores correctamente")
    public void testFactory(int type, Class<?> expectedClass) {
        Player p = PlayerFactory.createPlayer(type, "Test", null);
        assertEquals(expectedClass, p.getClass());
    }
}