package Krislet;

import java.util.LinkedList;
import java.util.LinkedHashMap;


public class SoccerState {
    public double distance;
    public double direction;

    public SoccerState(double distance, double direction){
        this.distance = distance;
        this.direction = direction;
    }


    public double getDistance(){
        return distance;
    }

    public double getDirection(){
        return direction;
    }



    @Override
    public String toString(){
        return "(d: "+ this.distance + ", a: "+ this.direction+")";
    }


}
