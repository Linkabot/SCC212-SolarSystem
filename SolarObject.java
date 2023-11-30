public class SolarObject  {
    private SolarSystem solarSystem;
    private double angle;
    private double distance;
    private String colour;
    private double size;
    private double speed;
    
    /**
     * 
     * @param distance How far away the planet is fromt he sun.
     * @param size how big the planet will be.
     * @param colour colour of the planet.
     * @param speed how fast it will orbit the sun.
     * @param solarSystem
     */
    public SolarObject(double distance, double size, String colour, double speed, SolarSystem solarSystem){
        this.distance = distance;
        this.angle = 90;
        this.size = size;
        this.colour = colour;
        this.speed = speed;
        this.solarSystem = solarSystem;
    }
    
    public double getDistance(){
        return distance;
    }
    public double getAngle(){
        return angle;
    }
    public String getColour(){
        return colour;
    }
    public double getSize(){
        return size;
    }
    public double getSpeed(){
        return speed;
    }
    /**
     * move method
     */
    public void move(){
        this.angle = this.angle + this.speed;
    }
    public double get(){
        return angle;
    }
    
    /**
     * draw method to draw objects
     * @param solarSystem
     */
    public void draw(SolarSystem solarSystem){
        this.solarSystem.drawSolarObject(this.getDistance(), this.getAngle(), this.getSize(), this.getColour());    
    }
}
