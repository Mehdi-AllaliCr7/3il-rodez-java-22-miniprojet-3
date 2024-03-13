package Modele;
import Modele.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotTest {
    @Test
    public void testGetMot() {
        Mot mot = new Mot("test", "test definition");
        assertEquals("test", mot.getMot());
    }

    @Test
    public void testGetDefinition() {
        Mot mot = new Mot("test", "test definition");
        assertEquals("test definition", mot.getDefinition());
    }
}
