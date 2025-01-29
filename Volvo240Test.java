import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    Volvo240 v = new Volvo240(4, Color.red);
    @Test
    void speedFactor() {
        assertEquals(4*0.01*1.25, v.speedFactor());
    }

    @Test
    void incrementSpeed() {
        v.startEngine();
        double speed = v.getCurrentSpeed();
        v.incrementSpeed(0.5);
        assertEquals(v.currentSpeed, Math.min(speed + v.speedFactor() * 0.5,v.getEnginePower()));
    }
}