import java.awt.*;

public class Application {
    public static void main(String[] args) {
        // Instance of this class
        //Model model = new Model();
        CarController cc = new CarController();

        //cc.cars.add(new Volvo240());

        // Start a new view and send a reference of self
        cc.model.frame = new CarView("CarSim 1.0", cc);

        //Gör i main
        Volvo240 v = new Volvo240(Color.black);
        Saab95 s = new Saab95(Color.blue);
        Scania sc = new Scania();

        cc.model.cars.add(v);
        cc.model.cars.add(s);
        cc.model.cars.add(sc);

        // Start the timer
        cc.timer.start();

    }
}
