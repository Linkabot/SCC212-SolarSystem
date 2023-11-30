public class Planet extends SolarObject {
    /**
     * Extends from SolarObject and hard codes the planets in a fixed position. 
     * @param distance How far away the planet is fromt he sun.  
     * @param size how big the planet will be.
     * @param colour colour of the planet.
     * @param speed how fast it will orbit the sun.
     * @param solarSystem 
     */
    public Planet(double distance, double size, String colour, double speed, SolarSystem solarSystem){
        super(distance, size, colour, speed, solarSystem);
    }
}