```mermaid
classDiagram
    class CelestialBody {
        <<interface>>
        +getName() String
        +getMass() double
        +getRadius() double
        +getOrbitalRadius() double
        +move(deltaTime: double) void
        +displayInfo() void
        +detailsInfo()$ void
    }

    class Galaxy {
        -name: String
        -mass: double
        -radius: double
        -galaxyType: String
        -estimatedStars: long
        +Galaxy(name: String, mass: double, radius: double, galaxyType: String, estimatedStars: long)
        +getGalaxyType() String
        +getEstimateStars() long
    }

    class Planet {
        -name: String
        -mass: double
        -radius: double
        -orbitalRadius: double
        -orbitalPeriod: double
        -angle: double
        +Planet(name: String, mass: double, radius: double, orbitalRadius: double, orbitalPeriod: double)
        +getAngle() double
    }

    class Moon {
        -name: String
        -mass: double
        -radius: double
        -orbitalRadius: double
        -orbitalPeriod: double
        -angle: double
        +Moon(name: String, mass: double, radius: double, orbitalRadius: double, orbitalPeriod: double)
        +getAngle() double
        +getOrbitalPeriod() double
    }

    class Star {
        -name: String
        -mass: double
        -radius: double
        -luminosity: double
        +Star(name: String, mass: double, radius: double, luminosity: double)
        +getLuminosity() double
    }

    class Main {
        -celestialBodies: Map~String, List~CelestialBody~~
        -scanner: Scanner
        +main(args: String[]) void
        +initializeBodies() void
        +addBody(body: CelestialBody) void
        +showMenu() void
        +showBodiesByType(choice: int) void
        +moveCelestialBody(body: CelestialBody) void
        +addCelestialBodyMenu() void
        +removeCelestialBodyMenu() void
        +addPlanet() void
        +removePlanet() void
        +addMoon() void
        +removeMoon() void
        +addGalaxy() void
        +removeGalaxy() void
        +addStar() void
        +removeStar() void
        +removeBody(type: String, name: String) void
        +displayBodyDetailsMenu(body: CelestialBody, type: int) void
    }

    CelestialBody <|.. Galaxy
    CelestialBody <|.. Planet
    CelestialBody <|.. Moon
    CelestialBody <|.. Star
    Main ..> CelestialBody : uses
    Main "1" *-- "*" Galaxy : manages
    Main "1" *-- "*" Planet : manages
    Main "1" *-- "*" Moon : manages
    Main "1" *-- "*" Star : manages
    ```