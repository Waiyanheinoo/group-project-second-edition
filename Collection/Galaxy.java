package Collection;
 // Galaxy class implements CelestialBody
 public class Galaxy implements CelestialBody {
    private String name;
    private double mass;
    private double radius;
    private String galaxyType;
    private long estimatedStars;

    public Galaxy(String name, double mass, double radius, String galaxyType, long estimatedStars) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.galaxyType = galaxyType;
        this.estimatedStars = estimatedStars;
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
    }

    public String getGalaxyType() {
        return galaxyType;
    }

    public long getEstimateStars() {
        return estimatedStars;
    }

    @Override
    public void move(double deltaTime) {
    }

    @Override
    public void displayInfo() {
        CelestialBody.super.detailsInfo(); // Calling the default method in the interface
        System.out.println(" * Type: " + galaxyType);
        System.out.println(" * Estimated Stars: " + estimatedStars);
    }
}