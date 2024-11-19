package Collection;
<<<<<<< HEAD

import java.util.*;

public class SolarSystemSimMain {

    private static Map<String, List<CelestialBody>> celestialBodies = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBodies();
        showMenu();
    }

    public static void addBody(CelestialBody body) {
        String className = body.getClass().getSimpleName();
        celestialBodies.putIfAbsent(className, new ArrayList<>());
        celestialBodies.get(className).add(body);
    }
    

    public static void showMenu() {
        while (true) {
            System.out.println(
                    "-------------------------------------------------------------------------------------------------");
            System.out.println("\nMain Menu:");
            System.out.println("1. View Celestial Bodies by Type");
            System.out.println("2. Add Celestial Body");
            System.out.println("3. Remove Celestial Body");
            System.out.println("4. Move a Celestial Body");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
=======
import java.util.*;

public class SolarSystemSimMain {
    
    
        private static Map<String, List<CelestialBody>> celestialBodies = new HashMap<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            initializeBodies();
            showMenu();
        }
        

        public static void addBody(CelestialBody body) {
            String className = body.getClass().getSimpleName();
            celestialBodies.putIfAbsent(className, new ArrayList<>());
            celestialBodies.get(className).add(body);
        }

        public static void showMenu() {
            while (true) {
                System.out.println("-------------------------------------------------------------------------------------------------");
                System.out.println("\nMain Menu:");
                System.out.println("1. View Celestial Bodies by Type");
                System.out.println("2. Add Celestial Body");
                System.out.println("3. Remove Celestial Body");
                System.out.println("4. Move a Celestial Body");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        showBodiesByType(choice);
                        break;
                    case 2:
                        addCelestialBodyMenu();
                        break;
                    case 3:
                        removeCelestialBodyMenu();
                        break;
                    case 4:
                        showBodiesByType(choice);
                        break;
                    case 5:
                        System.exit(0); // it just quits the script
                        break;
                    default:
                        System.out.println("\n * Invalid choice! Please try again.");
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
                case 1:
                    type = "Planet";
                    break;
                case 2:
                    type = "Moon";
                    break;
                case 3:
                    type = "Galaxy";
                    break;
                case 4:
                    type = "Star";
                    break;
                default:
                    System.out.println("\n * Invalid type!");
                    return;
            }

            System.out.println("\n" + type + "s:");
            List<CelestialBody> bodies = celestialBodies.get(type);
            for (int i = 0; i < bodies.size(); i++) {
                System.out.println((i + 1) + ". " + bodies.get(i).getName());
            }
            if (choice == 4) {
                System.out.print("Select a " + type + " to move");
            } else {
                System.out.print("Select a " + type + " to view details: ");
            }

            int bodyChoice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            if (bodyChoice > 0 && bodyChoice <= bodies.size()) {
                CelestialBody body = bodies.get(bodyChoice - 1);

                // Here we need to pass the correct int for the celestial body type
                int typeIndex = 0;
                if (typeChoice == 1)
                    typeIndex = 1; // Planet
                else if (typeChoice == 2)
                    typeIndex = 2; // Moon
                else if (typeChoice == 3)
                    typeIndex = 3; // Galaxy
                else if (typeChoice == 4)
                    typeIndex = 4; // Star
                if (choice == 4) {
                    moveCelestialBody(body);
                } else {
                    displayBodyDetailsMenu(body, typeIndex); 
                }

            } else {
                System.out.println("\n * Invalid choice!");
            }
        }

        public static void moveCelestialBody(CelestialBody body) {
            // Check if the body can move (Planet or Moon in this case)
            if (body instanceof Planet || body instanceof Moon) { // instanceof checks if the class (Planet or Moon) implements the interface('body' in this case) or is an instance of the class.
                System.out.println("\nEnter the time interval for the move (in days): ");
                double deltaTime = scanner.nextDouble(); // Time in days for movement
                scanner.nextLine(); // Clear buffer

                if (body instanceof Planet) { // If it is a planet.
                    Planet planet = (Planet) body;
                    System.out.println("\n * Before move: " + planet.getName() + " at " + planet.getAngle() + " radians.");
                    planet.move(deltaTime); // this method just moves the angle base on time
                    System.out.println(" * After move: " + planet.getName() + " at " + planet.getAngle() + " radians.");
                } else if (body instanceof Moon) { // If it is a moon.
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
>>>>>>> e65ab61b1d6c8b0944f1596ae1b8acdeca97ab08
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
<<<<<<< HEAD
                    showBodiesByType(choice);
                    break;
                case 2:
                    addCelestialBodyMenu();
                    break;
                case 3:
                    removeCelestialBodyMenu();
                    break;
                case 4:
                    showBodiesByType(choice);
                    break;
                case 5:
                    System.exit(0); // it just quits the script
                    break;
                default:
                    System.out.println("\n * Invalid choice! Please try again.");
            }
        }
    }

    public static void showBodiesByType(int choice) {
        System.out.println("\nChoose a Celestial Body Type:");
        System.out.println("1. Planet");
        System.out.println("2. Moon");
        System.out.println("3. Galaxy");
        System.out.println("4. Star");
        System.out.println("5. Comet");
        System.out.println();
        System.out.print("Enter the number of the body type: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        String type = "";
        switch (typeChoice) {
            case 1:
                type = "Planet";
                break;
            case 2:
                type = "Moon";
                break;
            case 3:
                type = "Galaxy";
                break;
            case 4:
                type = "Star";
                break;
            case 5:
                type = "Comet";
                break;
            default:
                System.out.println("\n * Invalid type!");
                return;
        }

        System.out.println("\n" + type + "s:");
        List<CelestialBody> bodies = celestialBodies.get(type);
        for (int i = 0; i < bodies.size(); i++) {
            System.out.println((i + 1) + ". " + bodies.get(i).getName());
        }
        if (choice == 4) {
            System.out.print("Select a " + type + " to move");
        } else {
            System.out.print("Select a " + type + " to view details: ");
        }

        int bodyChoice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        if (bodyChoice > 0 && bodyChoice <= bodies.size()) {
            CelestialBody body = bodies.get(bodyChoice - 1);

            if (choice == 4) {
                moveCelestialBody(body);
            } else {
                displayBodyDetailsMenu(body, typeChoice);
            }

        } else {
            System.out.println("\n * Invalid choice!");
        }
    }

    public static void moveCelestialBody(CelestialBody body) {
        // Check if the body can move (Planet or Moon in this case)
        if (body instanceof Planet || body instanceof Moon) { // instanceof checks if the class (Planet or Moon)
                                                              // implements the interface('body' in this case) or is an
                                                              // instance of the class.
            System.out.println("\nEnter the time interval for the move (in days): ");
            double deltaTime = scanner.nextDouble(); // Time in days for movement
            scanner.nextLine(); // Clear buffer

            if (body instanceof Planet) { // If it is a planet.
                Planet planet = (Planet) body;
                System.out.println("\n * Before move: " + planet.getName() + " at " + planet.getAngle() + " radians.");
                planet.move(deltaTime); // this method just moves the angle base on time
                System.out.println(" * After move: " + planet.getName() + " at " + planet.getAngle() + " radians.");
            } else if (body instanceof Moon) { // If it is a moon.
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
        System.out.println("5. Add Comet");
        System.out.print("Enter the number of the body type you want to add: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1:
                addPlanet();
                break;
            case 2:
                addMoon();
                break;
            case 3:
                addGalaxy();
                break;
            case 4:
                addStar();
                break;
            case 5:
                addComet();
                break;
            default:
                System.out.println("\n * Invalid choice!");
                break;
        }
    }

    public static void removeCelestialBodyMenu() {
        System.out.println("\nRemove a Celestial Body:");
        System.out.println("1. Remove Planet");
        System.out.println("2. Remove Moon");
        System.out.println("3. Remove Galaxy");
        System.out.println("4. Remove Star");
        System.out.println("5. Remove Comet");
        System.out.print("Enter the number of the body type you want to remove: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1:
                removePlanet();
                break;
            case 2:
                removeMoon();
                break;
            case 3:
                removeGalaxy();
                break;
            case 4:
                removeStar();
                break;
            case 5:
                removeComet();
                break;
            default:
                System.out.println("\n * Invalid choice!");
                break;
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

    public static void addComet() {
        System.out.println("\nEnter details for the new comet:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Mass (kg): ");
        double mass = scanner.nextDouble();
        System.out.print("Radius (km): ");
        double radius = scanner.nextDouble();
        System.out.print("Orbital Radius (km): ");
        double orbitalRadius = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        Comet comet = new Comet(name, mass, radius, orbitalRadius);
        addBody(comet);
        System.out.println("\n * Comet added successfully.");
    }

    public static void removeComet() {
        // Code to remove a planet
        System.out.println("\nEnter the name of the comet to remove:");
        String name = scanner.nextLine();
        removeBody("Comet", name);
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
        List<CelestialBody> bodies = celestialBodies.get(type); // This just gets all the bodies from that type
        if (bodies != null) { // If there is one
            boolean removed = false; // To track if a body was removed
            Iterator<CelestialBody> iterator = bodies.iterator();

            while (iterator.hasNext()) { // loop throught that type of body
                CelestialBody body = iterator.next(); // Get the next body from the list
                if (body.getName().equalsIgnoreCase(name)) { // If the current body in the interator matchs the body we
                                                             // want to remove
                    iterator.remove(); // Removes the body
                    removed = true; // Mark as removed
                    break; // Stop once the body is removed (you can remove all matching bodies if you
                           // don't use 'break')
                }
            }

            if (removed) {
                System.out.println(type + " removed successfully.");
            } else {
                System.out.println("Body with name " + name + " not found.");
            }
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
        if (type == 1 || type == 5) {
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
            case 2:
                System.out.println(
                        "-------------------------------------------------------------------------------------------------");
                System.out.println(" * Mass: " + body.getMass() + " kg");
                break;
            case 3:
                System.out.println(
                        "-------------------------------------------------------------------------------------------------");
                System.out.println(" * Radius: " + body.getRadius() + " km");
                break;
            case 4:
                System.out.println(
                        "-------------------------------------------------------------------------------------------------");
                System.out.println(" * Orbital Radius: " + body.getOrbitalRadius() + " km");
                break;
            case 1:
                System.out.println(
                        "-------------------------------------------------------------------------------------------------");
                body.displayInfo();
                break;
            case 5:
                if (type == 3) {
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");
                    System.out.println(" * Galaxy Type: " + ((Galaxy) body).getGalaxyType());
                } else if (type == 4) {
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");
                    System.out.println(" * Luminosity: " + ((Star) body).getLuminosity() + " solar luminosities");
                } else {
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");
                    System.out.println(" * Invalid choice!");
                }
                break;
            case 6:
                if (type == 3) {
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");
                    System.out.println(" * Estimated Stars: " + ((Galaxy) body).getEstimateStars());
                } else {
                    System.out.println(
                            "-------------------------------------------------------------------------------------------------");
                    System.out.println(" * Invalid choice!");
                }
                break;
            default:
                System.out.println(
                        "-------------------------------------------------------------------------------------------------");
                System.out.println(" * Invalid choice!");
                break;
        }

    }

    public static void initializeBodies() {
        // Initialize some celestial bodies
        addBody(new Planet("Earth", 5.972e24, 6371, 150000000, 365.25));
        addBody(new Moon("Moon", 7.35e22, 1737, 384400, 27.3));
        addBody(new Planet("Mars", 6.417e23, 3389, 227900000, 687));
        addBody(new Galaxy("Milky Way", 1.5e12, 100000, "Spiral", 100000000000L));
        addBody(new Galaxy("Andromeda", 1.23e12, 220000, "Spiral", 1000000000000L));
        addBody(new Star("Sun", 1.989e30, 696340, 1));

        addBody(new Planet("Mercury", 3.285e23, 2439, 57900000, 88));
        addBody(new Planet("Venus", 4.867e24, 6051, 108200000, 224.7));
        addBody(new Planet("Jupiter", 1.898e27, 69911, 778500000, 4332.6));
        addBody(new Planet("Saturn", 5.683e26, 58232, 1434000000, 10759));
        addBody(new Planet("Uranus", 8.681e25, 25362, 287100000, 30687));
        addBody(new Planet("Neptune", 1.024e26, 24622, 449500000, 60190));

        addBody(new Moon("Europa", 4.8e22, 1560, 670900, 3.5));
        addBody(new Moon("Titan", 1.345e23, 2575, 1221870, 15.945));
        addBody(new Moon("Io", 8.93e22, 1821, 421700, 1.769));
        addBody(new Moon("Ganymede", 1.4819e23, 2634, 1070400, 7.155));
        addBody(new Moon("Callisto", 1.0759e23, 2410, 1882700, 16.69));

        addBody(new Star("Proxima Centauri", 2.446e29, 69620, 4.25));
        addBody(new Star("Alpha Centauri A", 2.188e30, 695508, 4.37));
        addBody(new Star("Alpha Centauri B", 1.804e30, 602000, 4.37));
        addBody(new Star("Sirius A", 4.017e30, 1189640, 8.6));
        addBody(new Star("Vega", 2.135e30, 1218000, 25));

        addBody(new Galaxy("Triangulum Galaxy", 5.0e11, 60000, "Spiral", 40000000000L));
        addBody(new Galaxy("Whirlpool Galaxy", 1.6e11, 76000, "Spiral", 150000000000L));
        addBody(new Galaxy("Sombrero Galaxy", 8.0e11, 49000, "Spiral", 100000000000L));
        addBody(new Galaxy("Large Magellanic Cloud", 1.5e10, 14000, "Irregular", 30000000000L));
        addBody(new Galaxy("Small Magellanic Cloud", 5.0e9, 7000, "Irregular", 15000000000L));

        addBody(new Planet("Kepler-22b", 2.4e25, 12000, 600000000, 290));
        addBody(new Planet("Gliese 581g", 4.7e24, 7200, 20000000, 37));
        addBody(new Planet("HD 209458 b", 1.1e27, 71492, 6800000, 3.525));

        addBody(new Star("Betelgeuse", 1.31e31, 764000000, 642.5));
        addBody(new Moon("Charon", 1.586e21, 606, 19591, 6.387));
        addBody(new Planet("Pluto", 1.309e22, 1188, 5906440628L, 90560));

        addBody(new Galaxy("NGC 1300", 8.0e11, 120000, "Barred Spiral", 100000000000L));
        addBody(new Star("Rigel", 2.1e31, 780000000, 863));
    }
}
=======
                    addPlanet();
                    break;
                case 2:
                    addMoon();
                    break;
                case 3:
                    addGalaxy();
                    break;
                case 4:
                    addStar();
                    break;
                default:
                    System.out.println("\n * Invalid choice!");
                    break;
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
                case 1:
                    removePlanet();
                    break;
                case 2:
                    removeMoon();
                    break;
                case 3:
                    removeGalaxy();
                    break;
                case 4:
                    removeStar();
                    break;
                default:
                    System.out.println("\n * Invalid choice!");
                    break;
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
            List<CelestialBody> bodies = celestialBodies.get(type); // This just gets all the bodies from that type
            if (bodies != null) { // If there is one
                boolean removed = false;  // To track if a body was removed
                Iterator<CelestialBody> iterator = bodies.iterator();
                
                while (iterator.hasNext()) { // loop throught that type of body
                    CelestialBody body = iterator.next(); // Get the next body from the list
                    if (body.getName().equalsIgnoreCase(name)) { // If the current body in the interator matchs the body we want to remove
                        iterator.remove();  // Removes the body 
                        removed = true;  // Mark as removed
                        break;  // Stop once the body is removed (you can remove all matching bodies if you don't use 'break')
                    }
                }
                
                if (removed) {
                    System.out.println(type + " removed successfully.");
                } else {
                    System.out.println("Body with name " + name + " not found.");
                }
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
                case 2:
                System.out.println("-------------------------------------------------------------------------------------------------");
                    System.out.println(" * Mass: " + body.getMass() + " kg");
                    break;
                case 3:
                System.out.println("-------------------------------------------------------------------------------------------------");
                    System.out.println(" * Radius: " + body.getRadius() + " km");
                    break;
                case 4:
                System.out.println("-------------------------------------------------------------------------------------------------");
                    System.out.println(" * Orbital Radius: " + body.getOrbitalRadius() + " km");
                    break;
                case 1:
                System.out.println("-------------------------------------------------------------------------------------------------");
                    body.displayInfo();
                    break;
                case 5:
                    if (type == 3) {
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.println(" * Galaxy Type: " + ((Galaxy) body).getGalaxyType());
                    } else if (type == 4) {
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.println(" * Luminosity: " + ((Star) body).getLuminosity() + " solar luminosities");
                    } else {
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.println(" * Invalid choice!");
                    }
                    break;
                case 6:
                    if (type == 3) {
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.println(" * Estimated Stars: " + ((Galaxy) body).getEstimateStars());
                    } else {
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.println(" * Invalid choice!");
                    }
                    break;
                default:
                System.out.println("-------------------------------------------------------------------------------------------------");
                    System.out.println(" * Invalid choice!");
                    break;
            }

        }
        public static void initializeBodies() {
            // Initialize some celestial bodies
            addBody(new Planet("Earth", 5.972e24, 6371, 150000000, 365.25));
            addBody(new Moon("Moon", 7.35e22, 1737, 384400, 27.3));
            addBody(new Planet("Mars", 6.417e23, 3389, 227900000, 687));
            addBody(new Galaxy("Milky Way", 1.5e12, 100000, "Spiral", 100000000000L));
            addBody(new Galaxy("Andromeda", 1.23e12, 220000, "Spiral", 1000000000000L));
            addBody(new Star("Sun", 1.989e30, 696340, 1));
        
            addBody(new Planet("Mercury", 3.285e23, 2439, 57900000, 88));
            addBody(new Planet("Venus", 4.867e24, 6051, 108200000, 224.7));
            addBody(new Planet("Jupiter", 1.898e27, 69911, 778500000, 4332.6));
            addBody(new Planet("Saturn", 5.683e26, 58232, 1434000000, 10759));
            addBody(new Planet("Uranus", 8.681e25, 25362, 287100000, 30687));
            addBody(new Planet("Neptune", 1.024e26, 24622, 449500000, 60190));
        
            addBody(new Moon("Europa", 4.8e22, 1560, 670900, 3.5));
            addBody(new Moon("Titan", 1.345e23, 2575, 1221870, 15.945));
            addBody(new Moon("Io", 8.93e22, 1821, 421700, 1.769));
            addBody(new Moon("Ganymede", 1.4819e23, 2634, 1070400, 7.155));
            addBody(new Moon("Callisto", 1.0759e23, 2410, 1882700, 16.69));
        
            addBody(new Star("Proxima Centauri", 2.446e29, 69620, 4.25));
            addBody(new Star("Alpha Centauri A", 2.188e30, 695508, 4.37));
            addBody(new Star("Alpha Centauri B", 1.804e30, 602000, 4.37));
            addBody(new Star("Sirius A", 4.017e30, 1189640, 8.6));
            addBody(new Star("Vega", 2.135e30, 1218000, 25));
        
            addBody(new Galaxy("Triangulum Galaxy", 5.0e11, 60000, "Spiral", 40000000000L));
            addBody(new Galaxy("Whirlpool Galaxy", 1.6e11, 76000, "Spiral", 150000000000L));
            addBody(new Galaxy("Sombrero Galaxy", 8.0e11, 49000, "Spiral", 100000000000L));
            addBody(new Galaxy("Large Magellanic Cloud", 1.5e10, 14000, "Irregular", 30000000000L));
            addBody(new Galaxy("Small Magellanic Cloud", 5.0e9, 7000, "Irregular", 15000000000L));
        
            addBody(new Planet("Kepler-22b", 2.4e25, 12000, 600000000, 290));
            addBody(new Planet("Gliese 581g", 4.7e24, 7200, 20000000, 37));
            addBody(new Planet("HD 209458 b", 1.1e27, 71492, 6800000, 3.525));
        
            addBody(new Star("Betelgeuse", 1.31e31, 764000000, 642.5));
            addBody(new Moon("Charon", 1.586e21, 606, 19591, 6.387));
            addBody(new Planet("Pluto", 1.309e22, 1188, 5906440628L, 90560));
        
            addBody(new Galaxy("NGC 1300", 8.0e11, 120000, "Barred Spiral", 100000000000L));
            addBody(new Star("Rigel", 2.1e31, 780000000, 863));
        }
    }

>>>>>>> e65ab61b1d6c8b0944f1596ae1b8acdeca97ab08
