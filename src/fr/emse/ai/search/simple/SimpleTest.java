package fr.emse.ai.search.simple;

import fr.emse.ai.search.solver.DepthFirstTreeSearch;

public class SimpleTest {

    public static void main(String[] args) {
        SimpleOrientedGraphProblem p1 = new SimpleOrientedGraphProblem();
        System.out.println("Solution to problem using depth first : ");
        System.out.println(new DepthFirstTreeSearch().solve(p1).pathToString());
    }
}