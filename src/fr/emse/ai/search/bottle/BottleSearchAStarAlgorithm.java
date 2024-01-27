package fr.emse.ai.search.bottle;

import fr.emse.ai.search.core.AbstractTreeSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.*;

public class BottleSearchAStarAlgorithm extends AbstractTreeSearch {
    private final Set<Bottles> closed = new HashSet<>();

    @Override
    public Collection<Node> initFrontier() {
        Comparator<Node> comparator = Comparator.comparingInt(
                node -> ((Bottles) node.getState()).HValue() + (int) node.getPathCost());
        return new PriorityQueue<>(comparator);
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        Node node = ((PriorityQueue<Node>) frontier).poll();
        assert node != null;
        closed.add((Bottles) node.getState());
        return node;
    }

    @Override
    public Collection<Node> expand(Node node, Problem problem) {
        Collection<Node> successors = super.expand(node, problem);
        Collection<Node> newNodes = new ArrayList<>();
        for (Node successor : successors) {
            Bottles state = (Bottles) successor.getState();
            if (!closed.contains(state) && !containsState(frontier, state)) {
                newNodes.add(successor);
            }
        }
        return newNodes;
    }

    private boolean containsState(Collection<Node> nodes, Bottles state) {
        return nodes.stream().anyMatch(node -> node.getState().equals(state));
    }
}
