import java.util.Random;
public class Moon extends SolarObject {
    private double centreAngle;
    private double centreDistance;
    private double planetSpeed;
    private Random s;
    private Random d;
    private Random a;
    private double speed;
    private double distance;
    private double angle;
    private double planetSize;
    
    /**
     * The moons have a random distance, speed and starting orbital angle. 
     * All moons are also Gray and a fixed size. 
     * 
     * @param solarSystem To be able to use SolarSystem methods 
     * @param centreDistance Uses the Distance of the planet it's orbiting
     * @param centreAngle Uses the Angle of the Planet its orbiting 
     * @param planetSpeed Takes how fast the planet is orbiting the Sun to stay in the same pace 
     * @param planetSize Takes Size of the planet to find the distance needed for placement of Moons
     */
    public Moon(SolarSystem solarSystem, double centreDistance, double centreAngle, double planetSpeed, double planetSize){
        super(0, 3,"GRAY", 0, solarSystem); 
        this.angle = 0; 
        this.centreAngle = centreAngle;
        this.centreDistance = centreDistance;
        this.random();
        this.planetSpeed = planetSpeed;
        this.planetSize = planetSize;
        
        this.planetSize = this.planetSize * 0.470625;
        this.distance = this.planetSize + this.distance;
    }
    
    public double getDistance(){
        return distance;
    }

    public double getAngle(){
        return angle;
    }

    public double getSpeed(){
        return speed;
    }
    
    public double getCentreDistance(){
        return centreDistance;
    }

    public double getCentreAngle(){
        return centreAngle;
    }

    public double getPlanetSize(){
        return planetSize;
    }
    
    /**
     * random distance
     */
    public void distance(){
        d = new Random();
        this.distance = d.nextDouble(9-6) + 6;
    }
    
    /**
     * random angle
     */
    public void angle(){
        a = new Random();
        this.angle = a.nextInt(360);
    }

    /**
     * random speed
     */
    public void speed(){
        s = new Random();
        this.speed = s.nextDouble(20-15) + 15;
    }

    public void random(){
        this.speed() ;
        this.angle();
        this.distance();
    }

    /**
     * move method
     */
    public void move(){
        angle = angle + speed;
        this.centreAngle = this.centreAngle + planetSpeed;
    }
    /**
     * draw method to draw Moons
     */
    @Override
    public void draw(SolarSystem solarSystem){
        solarSystem.drawSolarObjectAbout(this.getDistance(), this.getAngle(), this.getSize(), this.getColour(), this.getCentreDistance(), this.getCentreAngle());
    }
}
