import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
public class ScaniaTest {
    private Scania scania;

    @BeforeEach
    void setUp() {
        scania = new Scania();
    }

    @Test
    void testMinAngle() {
        scania.lower(100);
        assertEquals(0, scania.getCurrentSpeed(), "Vinkeln på flaket kan inte vara lägre än 0.");
    }
    @Test
    void testMaxAngle() {
        scania.raise(100);
        assertEquals(0, scania.getCurrentSpeed(), "Vinkeln på flaket kan inte vara högre än 70.");
    }

    @Test
    void testRaiseWhileMoving() {
        scania.startEngine();
        scania.gas(0.5);
        scania.raise(10);
        assertEquals(0, scania.getAngle(), "Flaket ska inte kunna höjas om lastbilen är i rörelse");
    }
    @Test
    void testGasWileRaised() {
        scania.raise(50);
        scania.startEngine();
        scania.gas(0.5);
        assertEquals(0.1, scania.getCurrentSpeed(), "Lastbilen ska inte kunna köra om flaket är uppfällt.");
    }

}
*/