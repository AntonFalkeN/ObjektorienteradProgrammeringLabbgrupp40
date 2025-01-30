import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    Saab95 s = new Saab95();
    @BeforeEach
    void setUp() {
        s = new Saab95();
    }
    @Test
    void setTurboOn() {
        s.startEngine();
        s.gas(0.5);
        double noTurbo = s.getCurrentSpeed();
        s.brake(0.5);
        s.setTurboOn();
        s.gas(0.5);
        assertTrue(noTurbo < s.getCurrentSpeed());
    }

    @Test
    void speedFactor() {
        s.startEngine();
        s.speedFactor();
        assertEquals(s.enginePower *0.01, s.speedFactor());
        s.setTurboOn();
        assertEquals(s.enginePower*0.01*1.3, s.speedFactor());
    }

    @Test
    void incrementSpeed() {
        s.startEngine();
        double speed = s.getCurrentSpeed();
        s.incrementSpeed(0.5);
        assertEquals(s.currentSpeed, speed+s.speedFactor()*0.5);
    }
}