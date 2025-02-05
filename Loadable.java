public interface Loadable {
    void load(Car car);
    Car unload();
    int getLoadSize(); // Returnerar antal bilar
}
