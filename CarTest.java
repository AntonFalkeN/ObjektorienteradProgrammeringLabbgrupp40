import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

class CarTest {
    Volvo240 c = new Volvo240(Color.red);
    Saab95 s = new Saab95(Color.black);

    @org.junit.jupiter.api.Test
    void setColor() {
        c.setColor(Color.black);
        assertEquals(Color.black, c.getColor());
    }

    @org.junit.jupiter.api.Test
    void startEngine() {
        c.startEngine();
        assertEquals(0.1d, c.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        c.stopEngine();
        assertEquals(0.0d, c.getCurrentSpeed());
    }


    @org.junit.jupiter.api.Test
    void gas() {
        c.startEngine();
        double temp = c.getCurrentSpeed();
        c.gas(0.5);
        assertTrue(c.getCurrentSpeed()>temp);
    }

    @org.junit.jupiter.api.Test
    void brake() {
        c.startEngine();
        c.gas(0.5);
        double temp = c.getCurrentSpeed();
        c.brake(0.5);
        assertTrue(c.getCurrentSpeed()<temp);
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        c.startEngine();
        c.gas(0.6);
        c.turnWest();
        assertEquals("left", c.currentDirection);
        assertEquals(c.x_value-c.currentSpeed, c.Move());
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        c.startEngine();
        c.gas(0.6);
        c.turnEast();
        assertEquals("right", c.currentDirection);
        assertEquals(c.x_value+c.currentSpeed, c.Move());
    }
}