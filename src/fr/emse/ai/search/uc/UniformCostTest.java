package fr.emse.ai.search.uc;

import fr.emse.ai.search.simple.SimpleOrientedGraphProblem;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;
import fr.emse.ai.search.core.Node;

public class UniformCostTest {
    public static void main(String[] args) {
        UniformCostProblem problem = new UniformCostProblem();
        System.out.println("Solution to problem using depth first : ");
        Node solutionDF = new DepthFirstTreeSearch().solve(problem);
        System.out.println(solutionDF.pathToString());
        System.out.println("Depth first path cost: "+ solutionDF.getPathCost());
        System.out.println(solutionDF.getPathCost());

        System.out.println();

        System.out.println("Solution to problem using uniform cost search:");
        UniformCostSearch search = new UniformCostSearch();
        Node solutionUC = search.solve(problem);
        System.out.println(solutionUC.pathToString());
        System.out.println("Uniform cost search path cost: "+ solutionUC.getPathCost());
        System.out.println(solutionUC.getPathCost());
    }
}
