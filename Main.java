import java.awt.*;

public static void main(String[] args){
    Volvo240 V = new Volvo240(4, Color.black);
    Saab95 S = new Saab95();

    S.gas(0.5);
    System.out.println(S.currentSpeed);
    S.brake(0.5);
    S.setTurboOn();
    S.gas(0.5);
    System.out.println(S.currentSpeed);

   /* System.out.println(S.currentSpeed);
    V.gas(0.5);
    System.out.println(V.getCurrentSpeed());*/
}
