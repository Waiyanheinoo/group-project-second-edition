package Collection;
// Base interface for any celestial body
public interface CelestialBody {
    String getName();

    double getMass();

    double getRadius();

    double getOrbitalRadius();

    void move(double deltaTime);

    
    void displayInfo();
    default void detailsInfo() {
        System.out.println("\n=== Basic Info ===");
        System.out.println(" * Name: " + getName());
        System.out.println(" * Mass: " + (getMass() / 1.989e30) + " solar masses"); // Mass in solar masses
        System.out.println(" * Radius: " + getRadius() + " km");
    }
}