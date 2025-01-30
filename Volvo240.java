import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    Volvo240(Color _color){
        super(4, 100, _color, "Volvo240", 0);
    }

    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
