package Collection;
// Star class implements CelestialBody
public class Star implements CelestialBody {
    private String name;
    private double mass;
    private double radius;
    private double luminosity;

    public Star(String name, double mass, double radius, double luminosity) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.luminosity = luminosity;
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
    public double getOrbitalRadius() {
        return 0;
    } // Stars do not orbit anything in this model

    public double getLuminosity() {
        return luminosity;
    }

    @Override
    public void move(double deltaTime) {
    }

    @Override
    public void displayInfo() {
        CelestialBody.super.detailsInfo(); // Calling the default method in the interface
        System.out.println(" * Luminosity: " + luminosity + " solar luminosities");
    }
}
