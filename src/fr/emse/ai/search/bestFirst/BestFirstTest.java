package fr.emse.ai.search.bestFirst;

import fr.emse.ai.search.core.Node;

public class BestFirstTest {

    public static void main(String[] args) {
        BestFirstProblem problem = new BestFirstProblem();
        System.out.println("Solution to problem using best first search:");
        BestFirstSearch search = new BestFirstSearch();
        Node solution = search.solve(problem);
        if (solution != null) {
            System.out.println(solution.pathToString());

            System.out.println("Best First search path cost: "+ solution.getPathCost());
            System.out.println(solution.getPathCost());
        } else {
            System.out.println("No solution found.");
        }
    }
}
