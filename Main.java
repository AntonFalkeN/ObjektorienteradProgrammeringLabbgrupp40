import java.awt.*;

public static void main(String[] args){
    Volvo240 V = new Volvo240(4, 100, Color.black, "Volvo240", 0);
    V.gas(0.5);
    System.out.println(V.getCurrentSpeed());
}
