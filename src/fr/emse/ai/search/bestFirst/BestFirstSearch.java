package fr.emse.ai.search.bestFirst;

import fr.emse.ai.search.core.AbstractTreeSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.*;

public class BestFirstSearch extends AbstractTreeSearch {

    private final Set<Object> explored = new HashSet<>();

    @Override
    public Collection<Node> initFrontier() {
        return new PriorityQueue<>(Comparator.comparingInt(node -> ((HeuristicState) node.getState()).getHValue()));
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        Node node = ((PriorityQueue<Node>) frontier).poll();
        if (node != null) {
            explored.add(node.getState());
        }
        return node;
    }

    @Override
    public Collection<Node> expand(Node node, Problem problem) {
        if (((HeuristicState) node.getState()).getHValue() == 0) {
            return Collections.emptyList(); // Goal state reached
        }

        Collection<Node> successors = super.expand(node, problem);
        successors.removeIf(n -> explored.contains(n.getState()));
        return successors;
    }
}
