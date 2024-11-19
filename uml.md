````mermaid
classDiagram
    class CelestialBody {
        <<interface>>
        +updatePosition(time: double) void
        +getX() double
        +getY() double
        +getMass() double
        +getName() String
    }

    class Orbitable {
        <<interface>>
        +setOrbitCenter(center: CelestialBody) void
        +getOrbitalPeriod() double
        +getOrbitRadius() double
    }

    class Planet {
        -name: String
        -mass: double
        -x: double
        -y: double
        -orbitalPeriod: double
        -orbitRadius: double
        -centerBody: CelestialBody
        +Planet(name: String, mass: double, orbitalPeriod: double, orbitRadius: double)
        +updatePosition(time: double) void
        +setOrbitCenter(center: CelestialBody) void
        +getX() double
        +getY() double
        +getMass() double
        +getName() String
        +getOrbitalPeriod() double
        +getOrbitRadius() double
    }

    class Star {
        -name: String
        -mass: double
        -x: double
        -y: double
        +Star(name: String, mass: double, x: double, y: double)
        +updatePosition(time: double) void
        +getX() double
        +getY() double
        +getMass() double
        +getName() String
    }

    class SolarSystemSimulation {
        +main(args: String[]) void
    }

    CelestialBody <|.. Star: implements
    CelestialBody <|.. Planet: implements
    Orbitable <|.. Planet: implements
    SolarSystemSimulation ..> Planet: uses
    SolarSystemSimulation ..> Star: uses
    ```
````
