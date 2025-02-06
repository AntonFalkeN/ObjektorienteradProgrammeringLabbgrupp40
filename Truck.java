import java.awt.*;

public abstract class Truck extends Car{
    protected int angle;
    public Truck(int nrDoors, double enginePower, Color color, String modelName, double currentSpeed){
        super(nrDoors,enginePower,color,modelName,currentSpeed);
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
            if (getCurrentSpeed() != 0) {
                throw new IllegalStateException("Cannot raise the door while the truck is moving");
            }
            angle = Math.max(angle - amount, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int getAngle() {
        return angle;
    }
}
