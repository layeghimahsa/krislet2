package Krislet;


import java.util.LinkedList;

public class SoccerProblem {

    public SoccerState soccerState;

    public static SoccerState dash(SoccerState current_state, double p){
        SoccerState next_state;
        double next_distance;
        double next_alpha;
        double distance = current_state.distance;
        double direction = current_state.direction;
        double randomness = Math.random();
        System.out.println("Current distance in dash: "+distance+", direction: "+direction);
        double distance_not_rounded = Math.sqrt(Math.pow(p*distance,2) + Math.pow(distance,2) - 2*p*Math.pow(distance, 2)*Math.cos(Math.toRadians(direction)));
        System.out.println("Distance_not_rounded: "+ distance_not_rounded);
        next_distance = Math.min(0.5*Math.floor(2*distance_not_rounded),60);
        double alpha_not_rounded = direction + Math.asin((p*distance*Math.sin(Math.toRadians(direction)))/next_distance);
        if (next_distance != 0){
            next_alpha = 0.5*Math.floor(2*alpha_not_rounded);
        }else{
            next_alpha = 0;
        }

        System.out.println("Next distance in dash: "+next_distance+", direction: "+next_alpha);
        next_state = new SoccerState(next_distance,next_alpha);
        return next_state;
    }


    public static SoccerState turn(SoccerState current_state, double alpha){
        SoccerState next_state;
        double distance = current_state.distance;
        double direction = current_state.direction;
        next_state = new SoccerState(distance,direction-alpha);
        return next_state;
    }

    //result
    public LinkedList<SoccerState> next_state(SoccerState current_state, Action action){
        LinkedList <SoccerState> next_state = new LinkedList<SoccerState>();
        double d;
        if(action.getAction_type().equals("turn")){
            next_state.add(turn(current_state,action.getArg()));
        }else if(action.getAction_type().equals("dash")){
            next_state.add(dash(current_state,action.getArg()));
        }
        SoccerState non_rand_state = next_state.get(0);
        /*if ((non_rand_state.getDistance() >= 5.0) && (non_rand_state.getDistance() <= 6.0)) {
            next_state.add(new SoccerState(non_rand_state.getDistance(), non_rand_state.getDirection() + 60));
        }*/

        return next_state;
    }

    public boolean testGoal(SoccerState current_state){
        boolean is_reached = false;
        if(current_state.getDistance() == 0.0) return true;
        return false;
    }


    public LinkedList <Action> actions(SoccerState state){
        LinkedList <Action> actions = new LinkedList <Action>();

        actions.add(new Action("turn", state.direction));
        actions.add(new Action("dash", 0.03));



        /*for (int i = -45; i <= 45; i+=45) {
            actions.add(new Action("turn", i));
        }*/

        return actions;
    }

    public SoccerState initial_state(){
        return soccerState.getState();
    }



    /*public SoccerState next_state(SoccerState current, String action){
        if(action == "dash"){
            dash()
        }

    }

    public boolean is_on_path(SoccerState current){
        if(soccerState.states.contains(current)){
            return false;
        }
        return true;
    }*/

}
