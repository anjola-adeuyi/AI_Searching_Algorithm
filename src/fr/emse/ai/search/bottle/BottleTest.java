package fr.emse.ai.search.bottle;

import fr.emse.ai.search.core.AbstractTreeSearch;
import fr.emse.ai.search.core.Node;

import java.util.List;

public class BottleTest {

    public static void main(String[] args) {
        BottleProblem problem = new BottleProblem();

        // Testing Best First Search
        System.out.println("Starting Best First Search for the Bottle Problem...");
        testSearchAlgorithm(new BottleSearch(), problem);

        // Testing A* Search
        System.out.println("\nStarting A* Search for the Bottle Problem...");
        testSearchAlgorithm(new BottleSearchAStarAlgorithm(), problem);
    }

    private static void testSearchAlgorithm(AbstractTreeSearch searchAlgorithm, BottleProblem problem) {
        Node solution = searchAlgorithm.solve(problem);

        if (solution != null) {
            System.out.println("Solution found!");
            List<Node> path = solution.getPathFromRoot();
            for (Node node : path) {
                System.out.println(node.getState() + " -> Path Cost: " + node.getPathCost());
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}
