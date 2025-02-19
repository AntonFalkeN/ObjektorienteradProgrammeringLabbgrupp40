import java.awt.*;

public class Scania extends Truck{

    Scania(){
        super(2, 200, Color.red, "Scania", 0);
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


    @Override
    public void startEngine(){
        try {
            if (angle == 0) {  // Endast om flaket är helt nere
                super.startEngine();
            } else {
                throw new IllegalStateException("Cannot start the engine while the door is raised");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void incrementSpeed(double amount) {
        try {
            if (angle == 0) {
                super.incrementSpeed(amount);
            } else {
                throw new IllegalStateException("Cannot accelerate while the door is raised");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public double Move() {
        double x=0;
        try {
            if (angle == 0) {  // Endast om flaket är helt nere
                x = super.Move();
            } else {
                throw new IllegalStateException("Cannot move while the door is raised");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return x;
    }
}
