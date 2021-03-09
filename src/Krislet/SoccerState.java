package Krislet;

import java.util.LinkedList;
import java.util.LinkedHashMap;


public class SoccerState {
    public double distance;
    public double direction;
    public LinkedList <SoccerState> states;

    public SoccerState(double distance, double direction){
        this.distance = distance;
        this.direction = direction;
    }

    public void setDistance(double distance){
        this.distance = distance;
    }

    public void setDirection(double direction){
        this.direction = direction;
    }



    public double getDistance(){
        return distance;
    }

    public double getDirection(){
        return direction;
    }



    public void addState(SoccerState state){
        states.add(state);
    }
    public SoccerState getState(){ return  states.get(0);}


    @Override
    public String toString(){
        return "(d: "+ this.distance + ", a: "+ this.direction+")";
    }


}
