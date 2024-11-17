public class sol {

    // Base interface for any celestial body
    public interface CelestialBody {
        String getName();
        double getMass();
        double getRadius();
    
        // New method to get orbital radius
        double getOrbitalRadius();
    
        void move(double deltaTime);
        double calculateGravitationalForce(CelestialBody other);
    
        default void displayInfo() {
            System.out.println("Name: " + getName());
            System.out.println("Mass: " + getMass() + " kg");
            System.out.println("Radius: " + getRadius() + " km");
        }
    }
    

    // Planet class implements CelestialBody
    public static class Planet implements CelestialBody {
        private String name;
        private double mass;
        private double radius;
        private double orbitalRadius; // Distance from the sun (in kilometers)
        private double orbitalPeriod; // Orbital period (in days)
        private double angle; // Current angle in orbit (in radians)

        public Planet(String name, double mass, double radius, double orbitalRadius, double orbitalPeriod) {
            this.name = name;
            this.mass = mass;
            this.radius = radius;
            this.orbitalRadius = orbitalRadius;
            this.orbitalPeriod = orbitalPeriod;
            this.angle = 0; // Starting at a reference position
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
            // Move the planet based on time (orbital motion)
            double angularVelocity = 2 * Math.PI / orbitalPeriod; // radians per day
            angle += angularVelocity * deltaTime; // Update angle based on time step
            if (angle > 2 * Math.PI) {
                angle -= 2 * Math.PI; // Keep angle within range [0, 2π]
            }
        }

        @Override
        public void displayInfo() {
            CelestialBody.super.displayInfo(); // Call the default display method from CelestialBody interface
            System.out.println("Orbital Radius: " + orbitalRadius + " km");
            System.out.println("Orbital Period: " + orbitalPeriod + " days");
            System.out.println("Current Angle: " + angle + " radians");
        }

        @Override
        public double calculateGravitationalForce(CelestialBody other) {
            double G = 6.67430e-11; // Gravitational constant
            double distance = Math.abs(this.getOrbitalRadius() - other.getOrbitalRadius()); // Use the new method
            return G * this.mass * other.getMass() / (distance * distance);
        }

         @Override
        public double getOrbitalRadius() {
            return orbitalRadius;
        }

    }

    // Moon class implements CelestialBody
    public static class Moon implements CelestialBody {
        private String name;
        private double mass;
        private double radius;
        private double orbitalRadius; // Orbital radius (in km)
        private double orbitalPeriod; // Orbital period in days
        private double angle; // Current angle in orbit (in radians)

        public Moon(String name, double mass, double radius, double orbitalRadius, double orbitalPeriod) {
            this.name = name;
            this.mass = mass;
            this.radius = radius;
            this.orbitalRadius = orbitalRadius;
            this.orbitalPeriod = orbitalPeriod;
            this.angle = 0; // Starting at a reference position
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
            // Move the moon based on its orbital motion
            double angularVelocity = 2 * Math.PI / orbitalPeriod; // radians per day
            angle += angularVelocity * deltaTime;
            if (angle > 2 * Math.PI) {
                angle -= 2 * Math.PI; // Keep angle within range [0, 2π]
            }
        }

        @Override
        public void displayInfo() {
            CelestialBody.super.displayInfo(); // Use the default method for common information
            System.out.println("Orbital Radius: " + orbitalRadius + " km");
            System.out.println("Orbital Period: " + orbitalPeriod + " days");
            System.out.println("Current Angle: " + angle + " radians");
        }

        @Override
        public double calculateGravitationalForce(CelestialBody other) {
            double G = 6.67430e-11; // Gravitational constant
            double distance = Math.abs(this.getOrbitalRadius() - other.getOrbitalRadius()); // Use the new method
            return G * this.mass * other.getMass() / (distance * distance);
        }

    }

    // Main class to simulate celestial bodies and their interactions
    public static class Main {
        public static void main(String[] args) {
            // Create celestial bodies (Earth and its Moon)
            CelestialBody earth = new Planet("Earth", 5.972e24, 6371, 150000000, 365.25); // Earth, orbital period 365.25 days
            CelestialBody moon = new Moon("Moon", 7.35e22, 1737, 384400, 27.3); // Moon, orbital period 27.3 days

            // Display initial information about both celestial bodies
            earth.displayInfo();
            System.out.println();
            moon.displayInfo();

            // Simulate movement for 1 day
            earth.move(1); // Move Earth 1 day forward
            moon.move(1); // Move Moon 1 day forward

            // Display updated information after movement
            System.out.println("\nAfter 1 day of movement:");
            earth.displayInfo();
            System.out.println();
            moon.displayInfo();

            // Display gravitational force between Earth and Moon
            System.out.println("\nGravitational Force between Earth and Moon: " + earth.calculateGravitationalForce(moon) + " N");
        }
    }
}