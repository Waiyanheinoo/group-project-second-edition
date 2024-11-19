// Interface defining common behaviors of celestial bodies
interface CelestialBody {
    void move();
    void display();
    double getMass();
    String getName();
}

// A concrete class implementing the CelestialBody interface
class Planet implements CelestialBody {
    private String name;
    private double mass;
    private double x, y;    // position
    private double velocityX, velocityY;

    public Planet(String name, double mass, double x, double y) {
        this.name = name;
        this.mass = mass;
        this.x = x;
        this.y = y;
        this.velocityX = 0;
        this.velocityY = 0;
    }

    @Override
    public void move() {
        // Simple movement implementation
        x += velocityX;
        y += velocityY;
        System.out.println(name + " moved to position (" + x + ", " + y + ")");
    }

    @Override
    public void display() {
        System.out.println("Planet: " + name);
        System.out.println("Mass: " + mass + " kg");
        System.out.println("Position: (" + x + ", " + y + ")");
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Another class implementing the same interface
class Star implements CelestialBody {
    private String name;
    private double mass;
    private double luminosity;

    public Star(String name, double mass, double luminosity) {
        this.name = name;
        this.mass = mass;
        this.luminosity = luminosity;
    }

    @Override
    public void move() {
        // Stars typically move very slowly or appear stationary
        System.out.println(name + " maintains its position");
    }

    @Override
    public void display() {
        System.out.println("Star: " + name);
        System.out.println("Mass: " + mass + " kg");
        System.out.println("Luminosity: " + luminosity + " watts");
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Main class to demonstrate the usage
class SolarSystemDemo {
    public static void main(String[] args) {
        // Create an array of CelestialBody objects
        CelestialBody[] solarSystem = new CelestialBody[3];
        
        // Add different types of celestial bodies
        solarSystem[0] = new Star("Sun", 1.989e30, 3.828e26);
        solarSystem[1] = new Planet("Earth", 5.972e24, 149.6e6, 0);
        solarSystem[2] = new Planet("Mars", 6.39e23, 227.9e6, 0);

        // Demonstrate polymorphism - treating different objects through the same interface
        System.out.println("Solar System Simulation:");
        System.out.println("------------------------");
        
        for (CelestialBody body : solarSystem) {
            body.display();
            body.move();
            System.out.println("------------------------");
        }
    }
}
