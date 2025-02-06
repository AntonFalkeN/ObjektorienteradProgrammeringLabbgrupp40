import java.awt.*;

public class Scania extends Car{
    protected int angle;

    Scania(){
        super(2, 200, Color.red, "Scania", 0);
        this.angle = 0;
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public int getAngle() {
        return angle;
    }

    public void raise(int amount) {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
            if (getCurrentSpeed() == 0) {
                angle = Math.min(angle + amount, 70);
            } else {
                throw new IllegalStateException("Cannot raise the door while the truck is moving");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void lower(int amount) {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount must be positive");
            }
            if (getCurrentSpeed() == 0) {
                throw new IllegalStateException("Cannot raise the door while the truck is moving");
            }
            angle = Math.max(angle - amount, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
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
        try {
            if (angle == 0) {  // Endast om flaket är helt nere
                super.Move();
            } else {
                throw new IllegalStateException("Cannot move while the door is raised");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return x_value;
    }


}
