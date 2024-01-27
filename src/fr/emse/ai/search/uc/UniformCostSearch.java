package fr.emse.ai.search.uc;

import fr.emse.ai.search.core.AbstractTreeSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

public class UniformCostSearch extends AbstractTreeSearch {

    @Override
    public Collection<Node> initFrontier() {
        return new ArrayList<>();
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        Optional<Node> nextNode = frontier.stream()
                .min(Comparator.comparing(Node::getPathCost));
        nextNode.ifPresent(frontier::remove);
        return nextNode.orElse(null);
    }

}
