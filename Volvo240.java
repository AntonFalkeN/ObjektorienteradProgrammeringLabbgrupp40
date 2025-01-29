import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    Volvo240(double _enginePower, Color _color){
        super(4, _enginePower, _color, "Volvo240", 0);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
