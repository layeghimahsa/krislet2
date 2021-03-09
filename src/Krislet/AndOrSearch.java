package Krislet;

import javax.swing.plaf.nimbus.State;
import java.util.LinkedList;
import java.util.Queue;


public class AndOrSearch {

    LinkedList <Action> actions;

    public AndOrSearch(){ }


    public LinkedList <Object> and_or_search(SoccerProblem problem, SoccerState initial_state){
        LinkedList <SoccerState> result = new LinkedList <SoccerState>( );
        return or_search(initial_state, problem, result);
        //or_search(problem.)
    }

    public LinkedList <Object> or_search(SoccerState state, SoccerProblem problem, LinkedList <SoccerState> path){
        LinkedList <Object> plan = new LinkedList <Object>();
        System.out.println("distance in or: "+ state.getDistance()+ ", direction: " + state.getDirection());
        if (problem.testGoal(state)){
            System.out.println("Goal Reached:");
            for (int i = 0; i < path.size(); i++) {
                System.out.println(path.get(i));
                System.out.println("state = "+ state);
                System.out.println("********************");
            }
            return plan;
        }
        //System.out.println("path: "+ path);
        //test if it is on the path
        boolean contains = false;
        for (int i = 0; i < path.size(); i++) {
            SoccerState path_state = path.get(i);
            System.out.println("Distance on path: "+path_state.getDistance()+", direction: "+ path_state.getDirection());
            if((path.get(i).getDistance() == state.getDistance()) && (path.get(i).getDirection() == state.getDirection())){
                contains = true;
                break;
            }
        }

        if(contains){
            System.out.println("Failed or-search since path contains the current state.");
            return null; //failure
        }


        for (int i = 0; i < problem.actions(state).size(); i++) {
            path.add(0,state);
            Action action = problem.actions(state).get(i);
            System.out.println("actions' size: "+ problem.actions(state).size());
            System.out.println("action: "+action.getAction_type()+ ", arg: "+ action.getArg());
            plan = and_search(problem.next_state(state,action),problem,path);
            System.out.println("plan : " + plan);
            //System.out.println("action: "+action);
            if (plan != null) {
                plan.add(0,action);
                return plan;
            }
        }

        return null; //failure

    }


    public LinkedList <Object> and_search(LinkedList <SoccerState> states, SoccerProblem problem, LinkedList <SoccerState> path){
        LinkedList <Object> plan = new LinkedList <Object>();
        for (int i = 0; i < states.size() ; i++) {
            SoccerState state = states.get(i);
            System.out.println("distance in and: "+ state.getDistance()+ ", direction: " + state.getDirection());
            plan.add(i, or_search(state,problem,path));
            if(plan.get(i) == null) return null;
        }

        LinkedList <Object> result = new LinkedList <Object>();
        for (int i = 0; i < states.size(); i++) {
            StatePlan statePlan = new StatePlan(states.get(i), plan.get(i));
            result.add(statePlan);
        }

        return result;



    }
}
