import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    Volvo240(Color _color){
        super(4, 100, _color, "Volvo240", 0);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    //Kör dessa som abstrakta klasser istället för @Override
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
