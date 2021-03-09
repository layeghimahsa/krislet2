package Krislet;

import java.util.LinkedList;

public class StatePlan {
    public SoccerState state;
    public Object plan;

    public StatePlan(SoccerState state, Object plan) {
        this.state = state;
        this.plan = plan;
    }

    @Override
    public String toString(){
        return "("+ this.state + ", "+ this.plan + ")";
    }
}
