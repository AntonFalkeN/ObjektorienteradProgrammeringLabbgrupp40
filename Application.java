import java.awt.*;

public class Application {
    public static void main(String[] args) {
        // Instance of this class
        //Model model = new Model();
        CarController cc = new CarController();
        VehicleFactory VF = new VehicleFactory();
        //cc.cars.add(new Volvo240());

        // Start a new view and send a reference of self
        cc.model.frame = new CarView("CarSim 1.0", cc);

        //Gör i main
        Volvo240 v = new Volvo240(Color.black);
        cc.model.announcer.subscribeStopStart(v);
        Saab95 s = new Saab95(Color.blue);
        cc.model.announcer.subscribeStopStart(s);
        cc.model.announcer.subscribeTurboOn(s);
        Scania sc = new Scania();
        cc.model.announcer.subscribeStopStart(sc);

        cc.model.cars.add((Car)VF.CreateVehicle("Volvo240"));
        cc.model.cars.add((Car)VF.CreateVehicle("Saab95"));
        cc.model.cars.add((Car)VF.CreateVehicle("Scania"));

        // Start the timer
        cc.timer.start();

    }
}
