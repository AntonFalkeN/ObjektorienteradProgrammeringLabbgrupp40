import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Peterbilt388CarCarrierTest {
    private Peterbilt388CarCarrier p;
    @BeforeEach
    void setUp() {
        p = new Peterbilt388CarCarrier(1);
    }

    @Test
    void raise() {
        p.raise(70);
        assertEquals(70, p.getAngle());
    }

    @Test
    void lower() {
        p.stopEngine();
        p.lower(70);
        assertEquals(0, p.getAngle());
    }

    @Test
    void load() {
        p.stopEngine();
        int sizeBefore = p.getStorage().size();
        Volvo240 v = new Volvo240(Color.cyan);
        p.raise(70);
        p.load(v);
        assertEquals(sizeBefore+1, p.getStorage().size());
        assertFalse(p.getStorage().size() > 1);
    }

    @Test
    void unload() {
        p.stopEngine();
        p.raise(70);
        Volvo240 v = new Volvo240(Color.cyan);
        p.load(v);
        int sizeBefore = p.getStorage().size();
        p.unload();
        assertEquals(sizeBefore-1, p.getStorage().size());
        assertTrue(p.getStorage().isEmpty());
    }
}