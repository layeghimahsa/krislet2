package Krislet;

public class Action {
    public String action_type;
    public double arg;

    public Action(String action_type, double arg){
        this.action_type = action_type;
        this.arg = arg;
    }

    public void setAction_type(String action_type){
        this.action_type = action_type;
    }

    public void setArg(double arg){
        this.arg = arg;
    }

    public String getAction_type(){
        return action_type;
    }

    public double getArg(){
        return arg;
    }

    @Override
    public String toString(){
        return this.action_type + "("+ this.arg + ")";
    }
}
