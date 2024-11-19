package Collection;
// Planet class implements CelestialBody
public class Planet implements CelestialBody {
    private String name;
    private double mass;
    private double radius;
    private double orbitalRadius;
    private double orbitalPeriod;
    private double angle;

    public Planet(String name, double mass, double radius, double orbitalRadius, double orbitalPeriod) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.orbitalRadius = orbitalRadius;
        this.orbitalPeriod = orbitalPeriod;
        this.angle = 0;
    }

    public double getAngle() {
        return angle;
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
        return orbitalRadius;
    }

    @Override
    public void move(double deltaTime) {
        double angularVelocity = 2 * Math.PI / orbitalPeriod;
        angle += angularVelocity * deltaTime;
        if (angle > 2 * Math.PI)
            angle -= 2 * Math.PI;
    }

    @Override
    public void displayInfo() {
        CelestialBody.super.detailsInfo(); // Calling the default method in the interface
        System.out.println(" * Orbital Radius: " + orbitalRadius + " km");
        System.out.println(" * Orbital Period: " + orbitalPeriod + " days");
        System.out.println(" * Current Angle: " + angle + " radians");
    }
}