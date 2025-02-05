import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Peterbilt388CarCarrierTest {
    Peterbilt388CarCarrier p = new Peterbilt388CarCarrier(Color.cyan, 3);

    @BeforeEach
    void setUp() {
        //Peterbilt388CarCarrier p = new Peterbilt388CarCarrier(Color.cyan, 3);
    }

    @Test
    void rampUp() {
        p.rampUp();
        assertEquals(70, p.getDegree());
    }

    @Test
    void rampDown() {
        p.rampDown();
        assertEquals(0, p.getDegree());
    }

    @Test
    void loadCar() {
        int sizeBefore = p.getStorage().size();
        Volvo240 v = new Volvo240(Color.cyan);
        p.loadCar(v);
        assertEquals(sizeBefore+1, p.getStorage().size());
        assertFalse(p.getStorage().size() > 9);
    }

    @Test
    void unloadCar() {
        int sizeBefore = p.getStorage().size();
        Volvo240 v = new Volvo240(Color.cyan);
        p.loadCar(v);
        assertEquals(sizeBefore+1, p.getStorage().size());
        assertTrue(p.getStorage().isEmpty());
    }
}