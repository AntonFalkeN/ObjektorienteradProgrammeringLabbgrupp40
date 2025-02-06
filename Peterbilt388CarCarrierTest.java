import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Peterbilt388CarCarrierTest {
    Peterbilt388CarCarrier p = new Peterbilt388CarCarrier(2);

    @BeforeEach
    void setUp() {
        //Peterbilt388CarCarrier p = new Peterbilt388CarCarrier(Color.cyan, 3);
    }

    @Test
    void raise() {
        p.lower(70);
        assertEquals(70, p.getDegree());
    }

    @Test
    void lower() {
        p.raise(70);
        assertEquals(0, p.getDegree());
    }

    @Test
    void load() {
        int sizeBefore = p.getStorage().size();
        Volvo240 v = new Volvo240(Color.cyan);
        p.load(v);
        assertEquals(sizeBefore+1, p.getStorage().size());
        assertFalse(p.getStorage().size() > 9);
    }

    @Test
    void unload() {
        int sizeBefore = p.getStorage().size();
        Volvo240 v = new Volvo240(Color.cyan);
        p.unload();
        assertEquals(sizeBefore+1, p.getStorage().size());
        assertTrue(p.getStorage().isEmpty());
    }
}