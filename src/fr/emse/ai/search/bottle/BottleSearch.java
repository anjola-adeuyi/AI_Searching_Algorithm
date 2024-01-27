package fr.emse.ai.search.bottle;

import fr.emse.ai.search.core.AbstractTreeSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.*;

public class BottleSearch extends AbstractTreeSearch {
    private final Set<Bottles> visited = new HashSet<>();

    @Override
    public Collection<Node> initFrontier() {
        return new PriorityQueue<>(Comparator.comparingInt(node -> ((Bottles) node.getState()).HValue()));
    }

    @Override
    public Collection<Node> expand(Node node, Problem problem) {
        Bottles state = (Bottles) node.getState();
        if (visited.contains(state)) {
            return Collections.emptyList();
        }
        visited.add(state);
        return super.expand(node, problem);
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((PriorityQueue<Node>) frontier).poll();
    }
}
