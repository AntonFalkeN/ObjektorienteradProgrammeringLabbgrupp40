import java.awt.*;

public class Scania extends Truck{

    public Scania(){
        super(2, 200, Color.red, "Scania", 70);
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


    @Override
    public void startEngine() {
        if (ramp.isLowered()) {
            super.startEngine();
        } else {
            throw new IllegalStateException("Cannot start the engine while the ramp is lowered");
        }
    }

    @Override
    protected void incrementSpeed(double amount) {
        if (ramp.isLowered()) {
            super.incrementSpeed(amount);
        } else {
            throw new IllegalStateException("Cannot accelerate while the ramp is lowered");
        }
    }

    @Override
    public void move() {
        if (ramp.isLowered()) {
            super.move();
        } else {
            //System.out.println("Cannot move while the rap is raised or raise when moving");
            //throw new IllegalStateException("Cannot move while the ramp is raised");
        }
    }

}
