import java.awt.*;

public abstract class Truck extends Car{

    protected Ramp ramp;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, int maxAngle){
        super(nrDoors,enginePower,color,modelName);
        this.ramp = new Ramp(maxAngle);
    }

    public void raise(int amount) {
        if (getCurrentSpeed() == 0) {
            ramp.raise(amount);
        } else {
            throw new IllegalStateException("Cannot raise the door while the truck is moving");
        }
    }


    public void lower(int amount) {
        if (getCurrentSpeed() == 0) {
            ramp.lower(amount);
        } else {
            throw new IllegalStateException("Cannot raise the door while the truck is moving");
        }
    }

    public int getAngle() {return ramp.getAngle();}
}
