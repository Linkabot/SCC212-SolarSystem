import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Driver implements SolarSystemController {
    private int width = 900;
    private int height = 1400;

    private double inner = (100);
    private double outer = (270);

    HashMap<String, SolarObject> objects = new HashMap<String, SolarObject>();
    ArrayList < SolarObject > SolarObjects;

    private SolarSystem ss;
    private SolarSystemGUI ssg;
    

    public Driver(){
        ss = new SolarSystem(height, width);
        ssg = new SolarSystemGUI();
        ssg.addSolarSystemController(this);

        SolarObjects = new ArrayList <> ();
        SolarObjects.add(new Sun(ss));
        //Inner
        SolarObjects.add(new Planet((182.5), (inner * 0.10), "GRAY", 4, ss));        //mercury   01
        SolarObjects.add(new Planet((210), (inner * 0.30), "LIGHT_GRAY", 2.92, ss)); //venus     02
        SolarObjects.add(new Planet(250.5, (inner * 0.32), "BLUE", 2.48, ss));       //earth     03
        SolarObjects.add(new Planet(287, (inner * 0.16), "RED", 2, ss));             //mars      04
        //Outer
        SolarObjects.add(new Planet(460,(outer * 0.34) , "ORANGE", 1.092, ss));      //jupiter   05
        SolarObjects.add(new Planet(560, (outer * 0.34), "ORANGE", 0.808, ss));      //Saturns Ring
        SolarObjects.add(new Planet(560, (outer * 0.32), "BLACK", 0.808, ss));       //Black background
        SolarObjects.add(new Planet(560, (outer * 0.27), "YELLOW", 0.808, ss));      //saturn    06
        SolarObjects.add(new Planet(630, (outer * 0.14), "CYAN", 0.5676, ss));       //uranus    07
        SolarObjects.add(new Planet(680, (outer * 0.14), "BLUE", 0.448, ss));        //neptune   08
        

        //earth moon
        SolarObjects.add(new Moon(ss, SolarObjects.get(3).getDistance(), SolarObjects.get(3).getAngle(), SolarObjects.get(3).getSpeed(), SolarObjects.get(3).getSize())); 
        //mars moons
        SolarObjects.add(new Moon(ss, SolarObjects.get(4).getDistance(), SolarObjects.get(4).getAngle(), SolarObjects.get(4).getSpeed(), SolarObjects.get(4).getSize())); 
        SolarObjects.add(new Moon(ss, SolarObjects.get(4).getDistance(), SolarObjects.get(4).getAngle(), SolarObjects.get(4).getSpeed(), SolarObjects.get(4).getSize()));
        //jupiter moons
        for (int i = 0; i < 79; i ++){
            SolarObjects.add(new Moon(ss, SolarObjects.get(5).getDistance(), SolarObjects.get(5).getAngle(), SolarObjects.get(5).getSpeed(), SolarObjects.get(5).getSize()));
        }
        //Saturn moons 
        for (int i = 0; i < 82; i++){
            SolarObjects.add(new Moon(ss, SolarObjects.get(6).getDistance(), SolarObjects.get(6).getAngle(), SolarObjects.get(6).getSpeed(), SolarObjects.get(6).getSize()));
        }
        //Uranus moons
        for (int i = 0; i < 27; i ++){
            SolarObjects.add(new Moon(ss, SolarObjects.get(7).getDistance(), SolarObjects.get(7).getAngle(), SolarObjects.get(7).getSpeed(), SolarObjects.get(7).getSize()));
        }
        //Neptune moons
        for (int i = 0; i < 14; i ++){
            SolarObjects.add(new Moon(ss, SolarObjects.get(8).getDistance(), SolarObjects.get(8).getAngle(), SolarObjects.get(8).getSpeed(), SolarObjects.get(8).getSize()));
        }

        //Asteroids
        for (int i = 0; i < 500; i ++){
            SolarObjects.add(new Asteroid(ss));
        }
        
        while (true){
    
            for (SolarObject SolarObject : SolarObjects) {
                SolarObject.draw(ss); // draws planets 
                SolarObject.move(); // Move planets
            }

            for (Map.Entry<String, SolarObject> object : objects.entrySet()) {
                object.getValue().draw(ss);
                object.getValue().move();
            }

        ss.finishedDrawing();
        }

    //Implements Interface SolarSystemGUI
    }
    public void add(String name, double orbitalDistance, double initialAngle, double size, double speed, String colour){
        objects.put(name, new Planet(orbitalDistance, size, colour, speed, ss));
    }
    public void add(String name, double orbitalDistance, double initialAngle, double size, double speed, String colour, String parentName){
        objects.put(name, new Moon(ss, objects.get(parentName).getDistance(), objects.get(parentName).getAngle(), objects.get(parentName).getSpeed(), objects.get(parentName).getSize()));
    }
    public void remove(String name){
        objects.remove(name);
    }
}
