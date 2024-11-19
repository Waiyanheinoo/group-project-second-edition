package Collection;

// Planet class implements CelestialBody
public class Comet implements CelestialBody {
    private String name;
    private double mass;
    private double radius;
    private double orbitalRadius;

    public Comet(String name, double mass, double radius, double orbitalRadius) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.orbitalRadius = orbitalRadius;

    }

    @Override
    public double getOrbitalRadius() {
        return orbitalRadius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public void move(double deltaTime) {
        ;
    }

    @Override
    public void displayInfo() {
        CelestialBody.super.detailsInfo(); // Calling the default method in the interface

    }
}