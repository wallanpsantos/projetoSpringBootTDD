import br.ce.wcaquino.entidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class AssertsTest {

    @Test
    public void testeSimples() {

        Assertions.assertEquals(0.51334, 0.51379, 0.001);

        String palavra1 = "Bolo";
        Assertions.assertTrue("bOLo".equalsIgnoreCase(palavra1));

        String palavra2 = "Caneta";
        Assertions.assertTrue(palavra2.startsWith("Ca"));

        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 1");
        Usuario usuario3 = usuario2;
        Usuario usuario4 = new Usuario();


        Assertions.assertEquals(usuario1, usuario2);

        // Comparar se as duas instancia/objeto  são da mesma classe
        Assertions.assertSame(usuario2, usuario3);

        Assertions.assertFalse(Objects.isNull(usuario4));
    }
}
