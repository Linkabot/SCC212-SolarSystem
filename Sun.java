public class Sun extends SolarObject {
    /**
     * extends of solarobject
     * Sun is hard coded in to stay in the middle
     * @param solarSystem
     */
    public Sun(SolarSystem solarSystem){
            super(0, ((1400*0.25)), "YELLOW", 0, solarSystem);
    }
}
