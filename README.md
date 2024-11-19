# Celestial Body Simulation

This project simulates a simple solar system with celestial bodies using object-oriented programming principles. The simulation includes gravitational interactions between celestial bodies, orbital mechanics for planets around a star, and a check for habitable planets within a specified temperature range.

## Features
- **Interfaces and Classes**: Organized interfaces and classes for modeling various celestial bodies and their properties.
- **Orbital Mechanics**: Implements elliptical orbits for planets, with adjustable eccentricity, orbital period, and rotation.
- **Habitable Zone Detection**: Identifies habitable planets based on surface temperature and atmospheric conditions.

## Class Diagram

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
