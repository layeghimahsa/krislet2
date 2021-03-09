package Krislet;

import java.util.LinkedList;

public class TestAndOrSearch {
    public static void main(String[] args) {
        AndOrSearch andOrSearch = new AndOrSearch();
        SoccerProblem problem = new SoccerProblem();
        SoccerState initial_state = new SoccerState(10,10);

        LinkedList <Object> result = andOrSearch.and_or_search(problem, initial_state);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("And Or Search plan "+ i+": "+ result.get(i));
        }
    }
}
