import java.util.*;

public class sol {

    // Base interface for any celestial body
    public interface CelestialBody {
        String getName();
        double getMass();
        double getRadius();
        double getOrbitalRadius();
        void move(double deltaTime);
        void displayInfo(); // Default method to display basic info

        default void detailsInfo() {
            System.out.println("\n=== Basic Info ===");
            System.out.println(" * Name: " + getName());
            System.out.println(" * Mass: " + (getMass() / 1.989e30) + " solar masses"); // Mass in solar masses
            System.out.println(" * Radius: " + getRadius() + " km");
        }
    }

    // Galaxy class implements CelestialBody
    public static class Galaxy implements CelestialBody {
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
        public String getName() { return name; }
        @Override
        public double getMass() { return mass; }
        @Override
        public double getRadius() { return radius; }
        @Override
        public double getOrbitalRadius() { return 0; }
        public String getGalaxyType(){return galaxyType;}
        public long getEstimateStars(){return estimatedStars;}
        @Override
        public void move(double deltaTime) { }

        @Override
        public void displayInfo() {
            CelestialBody.super.detailsInfo(); // Calling the default method in the interface
            System.out.println(" * Type: " + galaxyType);
            System.out.println(" * Estimated Stars: " + estimatedStars);
        }
    }

    // Planet class implements CelestialBody
    public static class Planet implements CelestialBody {
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
        public double getAngle(){return angle;}
        @Override
        public String getName() { return name; }
        @Override
        public double getMass() { return mass; }
        @Override
        public double getRadius() { return radius; }
        @Override
        public double getOrbitalRadius() { return orbitalRadius; }

        @Override
        public void move(double deltaTime) {
            double angularVelocity = 2 * Math.PI / orbitalPeriod;
            angle += angularVelocity * deltaTime;
            if (angle > 2 * Math.PI) angle -= 2 * Math.PI;
        }

        @Override
        public void displayInfo() {
            CelestialBody.super.detailsInfo(); // Calling the default method in the interface
            System.out.println(" * Orbital Radius: " + orbitalRadius + " km");
            System.out.println(" * Orbital Period: " + orbitalPeriod + " days");
            System.out.println(" * Current Angle: " + angle + " radians");
        }
    }

    // Moon class implements CelestialBody
    public static class Moon implements CelestialBody {
        private String name;
        private double mass;
        private double radius;
        private double orbitalRadius;
        private double orbitalPeriod;
        private double angle;

        public Moon(String name, double mass, double radius, double orbitalRadius, double orbitalPeriod) {
            this.name = name;
            this.mass = mass;
            this.radius = radius;
            this.orbitalRadius = orbitalRadius;
            this.orbitalPeriod = orbitalPeriod;
            this.angle = 0;
        }
        public double getAngle(){return angle;}

        @Override
        public String getName() { return name; }
        @Override
        public double getMass() { return mass; }
        @Override
        public double getRadius() { return radius; }
        @Override
        public double getOrbitalRadius() { return orbitalRadius; }
        public double getOrbitalPeriod() {return orbitalPeriod; }

        @Override
        public void move(double deltaTime) {
            double angularVelocity = 2 * Math.PI / orbitalPeriod;
            angle += angularVelocity * deltaTime;
            if (angle > 2 * Math.PI) angle -= 2 * Math.PI;
        }

        @Override
        public void displayInfo() {
            CelestialBody.super.detailsInfo(); // Calling the default method in the interface
            System.out.println(" * Orbital Radius: " + orbitalRadius + " km");
            System.out.println(" * Orbital Period: " + orbitalPeriod + " days");
            System.out.println(" * Current Angle: " + angle + " radians");
        }
    }

    // Star class implements CelestialBody
    public static class Star implements CelestialBody {
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
        public String getName() { return name; }
        @Override
        public double getMass() { return mass; }
        @Override
        public double getRadius() { return radius; }
        @Override
        public double getOrbitalRadius() { return 0; } // Stars do not orbit anything in this model
        public double getLuminosity() {return luminosity;}
        @Override
        public void move(double deltaTime) { }

        @Override
        public void displayInfo() {
            CelestialBody.super.detailsInfo(); // Calling the default method in the interface
            System.out.println(" * Luminosity: " + luminosity + " solar luminosities");
        }
    }

    // Main class to simulate celestial bodies and their interactions
    public static class Main {
        private static Map<String, List<CelestialBody>> celestialBodies = new HashMap<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            initializeBodies();
            showMenu();
        }

        public static void initializeBodies() {
            // Initialize some celestial bodies
            addBody(new Planet("Earth", 5.972e24, 6371, 150000000, 365.25));
            addBody(new Moon("Moon", 7.35e22, 1737, 384400, 27.3));
            addBody(new Planet("Mars", 6.417e23, 3389, 227900000, 687));
            addBody(new Galaxy("Milky Way", 1.5e12, 100000, "Spiral", 100000000000L));
            addBody(new Galaxy("Andromeda", 1.23e12, 220000, "Spiral", 1000000000000L));
            addBody(new Star("Sun", 1.989e30, 696340, 1));
        }

        public static void addBody(CelestialBody body) {
            String className = body.getClass().getSimpleName();
            celestialBodies.putIfAbsent(className, new ArrayList<>());
            celestialBodies.get(className).add(body);
        }

        public static void showMenu() {
            while (true) {
                System.out.println("\nMain Menu:");
                System.out.println("1. View Celestial Bodies by Type");
                System.out.println("2. Add Celestial Body");
                System.out.println("3. Remove Celestial Body");
                System.out.println("4. Move a Celestial Body");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Clear buffer

                switch (choice) {   
                    case 1: showBodiesByType(choice); break;
                    case 2: addCelestialBodyMenu(); break;
                    case 3: removeCelestialBodyMenu(); break;
                    case 4: showBodiesByType(choice); break;
                    case 5: System.exit(0); break;
                    default: System.out.println("\n * Invalid choice! Please try again.");
                }
            }
        }

        public static void showBodiesByType(int choice) {
            System.out.println("\nChoose a Celestial Body Type:");
            System.out.println("1. Planet");
            System.out.println("2. Moon");
            System.out.println("3. Galaxy");
            System.out.println("4. Star");
            System.out.print("Enter the number of the body type: ");
            int typeChoice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
        
            String type = "";
            switch (typeChoice) {
                case 1: type = "Planet"; break;
                case 2: type = "Moon"; break;
                case 3: type = "Galaxy"; break;
                case 4: type = "Star"; break;
                default: System.out.println("Invalid type!"); return;
            }
        
            System.out.println("\n" + type + "s:");
            List<CelestialBody> bodies = celestialBodies.get(type);
            for (int i = 0; i < bodies.size(); i++) {
                System.out.println((i + 1) + ". " + bodies.get(i).getName());
            }
            if(choice == 4){
                System.out.print("Select a " + type + " to move");
            }
            else{
                System.out.print("Select a " + type + " to view details: ");
            }
            
            
            int bodyChoice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
        
            if (bodyChoice > 0 && bodyChoice <= bodies.size()) {
                CelestialBody body = bodies.get(bodyChoice - 1);
        
                // Here we need to pass the correct int for the celestial body type
                int typeIndex = 0;
                if (typeChoice == 1) typeIndex = 1;  // Planet
                else if (typeChoice == 2) typeIndex = 2;  // Moon
                else if (typeChoice == 3) typeIndex = 3;  // Galaxy
                else if (typeChoice == 4) typeIndex = 4;  // Star
                if(choice == 4){
                    moveCelestialBody(body);
                }else{
                    displayBodyDetailsMenu(body, typeIndex);  // Pass the int instead of the String
                }
                
                
            } else {
                System.out.println("\n * Invalid choice!");
            }
        }
        public static void moveCelestialBody(CelestialBody body) {
            // Check if the body can move (Planet or Moon in this case)
            if (body instanceof Planet || body instanceof Moon) {
                System.out.println("\nEnter the time interval for the move (in days): ");
                double deltaTime = scanner.nextDouble(); // Time in days for movement
                scanner.nextLine(); // Clear buffer
        
                if (body instanceof Planet) {
                    Planet planet = (Planet) body;
                    System.out.println("\n * Before move: " + planet.getName() + " at " + planet.getAngle() + " radians.");
                    planet.move(deltaTime);
                    System.out.println(" * After move: " + planet.getName() + " at " + planet.getAngle() + " radians.");
                } else if (body instanceof Moon) {
                    Moon moon = (Moon) body;
                    System.out.println("\n * Before move: " + moon.getName() + " at " + moon.getAngle() + " radians.");
                    moon.move(deltaTime);
                    System.out.println(" * After move: " + moon.getName() + " at " + moon.getAngle() + " radians.");
                }
            } else {
                System.out.println("\n * This body cannot be moved.");
            }
        }
        
        

        public static void addCelestialBodyMenu() {
            System.out.println("\nAdd a New Celestial Body: ");
            System.out.println("1. Add Planet");
            System.out.println("2. Add Moon");
            System.out.println("3. Add Galaxy");
            System.out.println("4. Add Star");
            System.out.print("Enter the number of the body type you want to add: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: addPlanet(); break;
                case 2: addMoon(); break;
                case 3: addGalaxy(); break;
                case 4: addStar(); break;
                default: System.out.println("\n * Invalid choice!"); break;
            }
        }

        public static void removeCelestialBodyMenu() {
            System.out.println("\nRemove a Celestial Body:");
            System.out.println("1. Remove Planet");
            System.out.println("2. Remove Moon");
            System.out.println("3. Remove Galaxy");
            System.out.println("4. Remove Star");
            System.out.print("Enter the number of the body type you want to remove: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: removePlanet(); break;
                case 2: removeMoon(); break;
                case 3: removeGalaxy(); break;
                case 4: removeStar(); break;
                default: System.out.println("\n * Invalid choice!"); break;
            }
        }

        // Add methods for each body type
        public static void addPlanet() {
            System.out.println("\nEnter details for the new planet:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Mass (kg): ");
            double mass = scanner.nextDouble();
            System.out.print("Radius (km): ");
            double radius = scanner.nextDouble();
            System.out.print("Orbital Radius (km): ");
            double orbitalRadius = scanner.nextDouble();
            System.out.print("Orbital Period (days): ");
            double orbitalPeriod = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer

            Planet planet = new Planet(name, mass, radius, orbitalRadius, orbitalPeriod);
            addBody(planet);
            System.out.println("\n * Planet added successfully.");
        }

        public static void removePlanet() {
            // Code to remove a planet
            System.out.println("\nEnter the name of the planet to remove:");
            String name = scanner.nextLine();
            removeBody("Planet", name);
        }

        public static void addMoon() {
            // Similar code for adding a Moon
            System.out.println("\nEnter details for the new moon:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Mass (kg): ");
            double mass = scanner.nextDouble();
            System.out.print("Radius (km): ");
            double radius = scanner.nextDouble();
            System.out.print("Orbital Radius (km): ");
            double orbitalRadius = scanner.nextDouble();
            System.out.print("Orbital Period (days): ");
            double orbitalPeriod = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer

            Moon moon = new Moon(name, mass, radius, orbitalRadius, orbitalPeriod);
            addBody(moon);
            System.out.println("\n * Moon added successfully.");
        }

        public static void removeMoon() {
            // Code to remove a moon
            System.out.println("\nEnter the name of the moon to remove: ");
            String name = scanner.nextLine();
            removeBody("Moon", name);
        }

        public static void addGalaxy() {
            // Similar code for adding a Galaxy
            System.out.println("\nEnter details for the new galaxy:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Mass (kg): ");
            double mass = scanner.nextDouble();
            System.out.print("Radius (km): ");
            double radius = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer
            System.out.print("Galaxy Type: ");
            String galaxyType = scanner.nextLine();
            System.out.print("Estimated Stars: ");
            long estimatedStars = scanner.nextLong();
            scanner.nextLine(); // Clear buffer

            Galaxy galaxy = new Galaxy(name, mass, radius, galaxyType, estimatedStars);
            addBody(galaxy);
            System.out.println("\n * Galaxy added successfully.");
        }

        public static void removeGalaxy() {
            // Code to remove a galaxy
            System.out.println("\nEnter the name of the galaxy to remove: ");
            String name = scanner.nextLine();
            removeBody("Galaxy", name);
        }

        public static void addStar() {
            // Similar code for adding a Star
            System.out.println("\nEnter details for the new star:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Mass (kg): ");
            double mass = scanner.nextDouble();
            System.out.print("Radius (km): ");
            double radius = scanner.nextDouble();
            System.out.print("Luminosity: ");
            double luminosity = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer

            Star star = new Star(name, mass, radius, luminosity);
            addBody(star);
            System.out.println("\n * Star added successfully.");
        }

        public static void removeStar() {
            // Code to remove a star
            System.out.println("\nEnter the name of the star to remove:");
            String name = scanner.nextLine();
            removeBody("Star", name);
        }

        public static void removeBody(String type, String name) {
            List<CelestialBody> bodies = celestialBodies.get(type);
            if (bodies != null) {
                bodies.removeIf(body -> body.getName().equalsIgnoreCase(name));
                System.out.println(type + " removed successfully.");
            } else {
                System.out.println(type + " not found.");
            }
        }

        public static void displayBodyDetailsMenu(CelestialBody body, int type) {
            System.out.println("\nWhich detail would you like to see?");
            System.out.println("1. Display Full Info");
            System.out.println("2. Mass");
            System.out.println("3. Radius");
            System.out.println("4. Orbital Radius");
            
            
        
            // Add additional options based on body type
            if (type == 1) {
                // No unique property, so nothing additional here
            } else if (type == 3) {
                System.out.println("5. Galaxy Type");
                System.out.println("6. Estimated Stars");
            } else if (type == 4) {
                System.out.println("5. Luminosity");
            }
            
        
            System.out.print("Enter the number of your choice: ");
            int detailChoice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
        
            switch (detailChoice) {
                case 2: System.out.println("\n * Mass: " + body.getMass() + " kg"); break;
                case 3: System.out.println("\n * Radius: " + body.getRadius() + " km"); break;
                case 4: System.out.println("\n * Orbital Radius: " + body.getOrbitalRadius() + " km"); break;
                case 1: body.displayInfo(); break;
                case 5: 
                    if (type == 3) {
                        System.out.println("\n * Galaxy Type: " + ((Galaxy) body).getGalaxyType());
                    } else if (type == 4) {
                        System.out.println("\n * Luminosity: " + ((Star) body).getLuminosity() + " solar luminosities");
                    } else {
                        System.out.println("\n * Invalid choice!");
                    }
                    break;
                case 6: 
                    if (type == 3) {
                        System.out.println("\n * Estimated Stars: " + ((Galaxy) body).getEstimateStars());
                    } else {
                        System.out.println("\n * Invalid choice!");
                    }
                    break;
                default: System.out.println("\n * Invalid choice!"); break;
            }
        
        }
    }
}
