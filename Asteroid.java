import java.util.Random;

public class Asteroid extends SolarObject{
    private Random s;
    private Random d;
    private Random a;
    private Random f;
    private double speed;
    private double distance;
    private double angle;
    private double size;

    /**
     * The Asteroid belt will have Asteroids of different speeds, distances in a fixed area, orbiting angle and size. 
     * @param solarSystem 
     */
    public Asteroid(SolarSystem solarSystem){
        super (0, 0, "DARK_GRAY", 0, solarSystem);
        this.random();
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

    public double getSize(){
        return size;
    }

    /**
     * random distance
     */
    public void distance(){
        d = new Random();
        this.distance = d.nextDouble(400 - 310) + 310;
    }
    /**
     * random angle
     */
    public void angle(){
        a = new Random();
        this.angle = a.nextDouble(360);
    }

    /**
     * random speed
     */
    public void speed(){
        s = new Random();
        this.speed = s.nextDouble(4 - 1) + 1;
    }
    /**
     * random Size
     */
    public void size(){
        f = new Random();
        this.size = f.nextDouble(10 - 2) + 2;
    }

    
    public void random(){
        this.speed();
        this.angle();
        this.distance();
        this.size();
    }

    public void move(){
        angle = angle + speed;
    }
}
