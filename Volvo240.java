import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    Volvo240(int _nrDoors, double _enginePower, Color _color, String _modelName, double _currentSpeed){
        super(_nrDoors, _enginePower, _color, _modelName, _currentSpeed);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    //Kör dessa som abstrakta klasser istället för @Override
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
