import java.awt.*;

class Main {
    public static void main(String[] args) {
        Peterbilt388CarCarrier P = new Peterbilt388CarCarrier(Color.green, 2);
        Volvo240 v = new Volvo240(Color.cyan);
        P.startEngine();
        P.gas(0.4);
        P.stopEngine();
        P.loadCar(v);
        System.out.println(P.currentSpeed);
        System.out.println(P.storage);

   /* System.out.println(S.currentSpeed);
    V.gas(0.5);
    System.out.println(V.getCurrentSpeed());*/
    }
}