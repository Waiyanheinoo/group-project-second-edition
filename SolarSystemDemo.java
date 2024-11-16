import java.util.*;

// Core interfaces for celestial bodies
// testing 1-2-3
interface CelestialBody {
    String getName();

    double getMass(); // in kg

    double getRadius(); // in km

    Vector3D getPosition(); // in km

    Vector3D getVelocity(); // in km/s

    default double getGravitationalForce(CelestialBody other) {
        double G = 6.67430e-20; // gravitational constant in km³/kg⋅s²
        double distance = getPosition().distanceTo(other.getPosition());
        return G * (getMass() * other.getMass()) / (distance * distance);
    }
}

interface Orbital extends CelestialBody {
    CelestialBody getParentBody();

    double getOrbitalPeriod(); // in Earth days

    double getEccentricity();

    default double getSemiMajorAxis() {
        // Calculate semi-major axis using orbital period and parent mass
        double G = 6.67430e-20; // km³/kg⋅s²
        double T = getOrbitalPeriod() * 86400; // convert days to seconds
        double M = getParentBody().getMass();
        return Math.cbrt((G * M * T * T) / (4 * Math.PI * Math.PI));
    }
}

interface Rotatable extends CelestialBody {
    double getRotationPeriod(); // in Earth days

    Vector3D getAxisOfRotation();

    default double getAngularVelocity() {
        return 2 * Math.PI / (getRotationPeriod() * 86400); // in radians/second
    }
}

interface Habitable extends CelestialBody {
    double getSurfaceTemperature(); // in Kelvin

    double getAtmosphericPressure(); // in atmospheres

    List<String> getAtmosphericComposition();

    boolean hasWater();

    default boolean isInHabitableZone() {
        double temp = getSurfaceTemperature();
        return temp >= 273 && temp <= 323; // 0°C to 50°C
    }
}

// Helper class for 3D vector operations
class Vector3D {
    private final double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceTo(Vector3D other) {
        double dx = x - other.x;
        double dy = y - other.y;
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.x, y + other.y, z + other.z);
    }

    public Vector3D multiply(double scalar) {
        return new Vector3D(x * scalar, y * scalar, z * scalar);
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}

// Abstract base class for common implementations
abstract class AbstractCelestialBody implements CelestialBody {
    protected String name;
    protected double mass;
    protected double radius;
    protected Vector3D position;
    protected Vector3D velocity;

    public AbstractCelestialBody(String name, double mass, double radius,
            Vector3D position, Vector3D velocity) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.position = position;
        this.velocity = velocity;
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
    public Vector3D getPosition() {
        return position;
    }

    @Override
    public Vector3D getVelocity() {
        return velocity;
    }
}

// Implementation classes for different celestial bodies
class Star extends AbstractCelestialBody implements Rotatable {
    private final double luminosity; // in solar luminosities
    private final double temperature; // in Kelvin
    private final double rotationPeriod;
    private final Vector3D axisOfRotation;

    public Star(String name, double mass, double radius, Vector3D position,
            Vector3D velocity, double luminosity, double temperature,
            double rotationPeriod, Vector3D axisOfRotation) {
        super(name, mass, radius, position, velocity);
        this.luminosity = luminosity;
        this.temperature = temperature;
        this.rotationPeriod = rotationPeriod;
        this.axisOfRotation = axisOfRotation;
    }

    @Override
    public double getRotationPeriod() {
        return rotationPeriod;
    }

    @Override
    public Vector3D getAxisOfRotation() {
        return axisOfRotation;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public double getTemperature() {
        return temperature;
    }
}

class Planet extends AbstractCelestialBody
        implements Orbital, Rotatable, Habitable {
    private final CelestialBody parentStar;
    private final double orbitalPeriod;
    private final double eccentricity;
    private final double rotationPeriod;
    private final Vector3D axisOfRotation;
    private final double surfaceTemperature;
    private final double atmosphericPressure;
    private final List<String> atmosphericComposition;
    private final boolean hasWater;

    public Planet(String name, double mass, double radius, Vector3D position,
            Vector3D velocity, CelestialBody parentStar, double orbitalPeriod,
            double eccentricity, double rotationPeriod, Vector3D axisOfRotation,
            double surfaceTemperature, double atmosphericPressure,
            List<String> atmosphericComposition, boolean hasWater) {
        super(name, mass, radius, position, velocity);
        this.parentStar = parentStar;
        this.orbitalPeriod = orbitalPeriod;
        this.eccentricity = eccentricity;
        this.rotationPeriod = rotationPeriod;
        this.axisOfRotation = axisOfRotation;
        this.surfaceTemperature = surfaceTemperature;
        this.atmosphericPressure = atmosphericPressure;
        this.atmosphericComposition = atmosphericComposition;
        this.hasWater = hasWater;
    }

    // Implement Orbital interface
    @Override
    public CelestialBody getParentBody() {
        return parentStar;
    }

    @Override
    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    @Override
    public double getEccentricity() {
        return eccentricity;
    }

    // Implement Rotatable interface
    @Override
    public double getRotationPeriod() {
        return rotationPeriod;
    }

    @Override
    public Vector3D getAxisOfRotation() {
        return axisOfRotation;
    }

    // Implement Habitable interface
    @Override
    public double getSurfaceTemperature() {
        return surfaceTemperature;
    }

    @Override
    public double getAtmosphericPressure() {
        return atmosphericPressure;
    }

    @Override
    public List<String> getAtmosphericComposition() {
        return atmosphericComposition;
    }

    @Override
    public boolean hasWater() {
        return hasWater;
    }
}

// Simulation class to demonstrate the system
class CelestialSimulation {
    private final List<CelestialBody> bodies = new ArrayList<>();

    public void addBody(CelestialBody body) {
        bodies.add(body);
    }

    public void simulateGravitationalInteractions() {
        for (int i = 0; i < bodies.size(); i++) {
            for (int j = i + 1; j < bodies.size(); j++) {
                CelestialBody body1 = bodies.get(i);
                CelestialBody body2 = bodies.get(j);

                double force = body1.getGravitationalForce(body2);
                System.out.printf("Gravitational force between %s and %s: %.2e N%n",
                        body1.getName(), body2.getName(), force);
            }
        }
    }

    public void printHabitablePlanets() {
        bodies.stream()
                .filter(body -> body instanceof Habitable)
                .map(body -> (Habitable) body)
                .filter(Habitable::isInHabitableZone)
                .forEach(planet -> System.out.println(
                        "Habitable planet found: " + ((CelestialBody) planet).getName()));
    }
}

// Demo class
public class SolarSystemDemo {
    public static void main(String[] args) {
        // Create a simple solar system simulation
        CelestialSimulation simulation = new CelestialSimulation();

        // Create the Sun
        Star sun = new Star(
                "Sun",
                1.989e30, // mass in kg
                696340, // radius in km
                new Vector3D(0, 0, 0),
                new Vector3D(0, 0, 0),
                1.0, // luminosity (1 solar luminosity)
                5778, // surface temperature in K
                27.0, // rotation period in days
                new Vector3D(0, 0, 1));

        // Create Earth
        Planet earth = new Planet(
                "Earth",
                5.972e24, // mass in kg
                6371, // radius in km
                new Vector3D(149.6e6, 0, 0), // position (at 1 AU)
                new Vector3D(0, 29.78, 0), // velocity in km/s
                sun, // parent body
                365.26, // orbital period in days
                0.0167, // eccentricity
                1.0, // rotation period in days
                new Vector3D(0, 0, 1),
                288, // surface temperature in K
                1.0, // atmospheric pressure in atm
                List.of("Nitrogen", "Oxygen", "Argon"),
                true // has water
        );

        // Add bodies to simulation
        simulation.addBody(sun);
        simulation.addBody(earth);

        // Run simulation
        System.out.println("=== Celestial Body Simulation ===");
        simulation.simulateGravitationalInteractions();
        System.out.println("\n=== Checking for Habitable Planets ===");
        simulation.printHabitablePlanets();
    }
}