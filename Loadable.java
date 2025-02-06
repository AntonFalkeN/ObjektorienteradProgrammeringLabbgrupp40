public interface Loadable {
    <T> void load(T car);
    <T> T unload();
    int getLoadSize(); // Returnerar antal bilar
}
