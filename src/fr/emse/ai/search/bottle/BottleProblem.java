package fr.emse.ai.search.bottle;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BottleProblem implements Problem {

    Bottles initialState = new Bottles(0, 0);
    Bottles goalState1 = new Bottles(2, 0);
    Bottles goalState2 = new Bottles(0, 2);

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        Bottles bottles = (Bottles) state;
        return bottles.equals(goalState1) || bottles.equals(goalState2);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        List<Object> actions = new ArrayList<>();
        actions.add(BottleAction.FILL_B1);
        actions.add(BottleAction.FILL_B2);
        actions.add(BottleAction.EMPTY_B1);
        actions.add(BottleAction.EMPTY_B2);
        actions.add(BottleAction.TRANSFER_B1_TO_B2);
        actions.add(BottleAction.TRANSFER_B2_TO_B1);
        return actions;
    }

//    @Override
//    public Object getNextState(Object state, Object action) {
//        Bottles bottles = (Bottles) state;
//        switch ((BottleAction) action) {
//            case FILL_B1:
//                return new Bottles(4, bottles.bottle2);
//            case FILL_B2:
//                return new Bottles(bottles.bottle1, 3);
//            case EMPTY_B1:
//                return new Bottles(0, bottles.bottle2);
//            case EMPTY_B2:
//                return new Bottles(bottles.bottle1, 0);
//            case TRANSFER_B1_TO_B2:
//                int newB2 = Math.min(bottles.bottle1 + bottles.bottle2, 3);
//                int newB1 = bottles.bottle1 - (newB2 - bottles.bottle2);
//                return new Bottles(newB1, newB2);
//            case TRANSFER_B2_TO_B1:
//                newB1 = Math.min(bottles.bottle1 + bottles.bottle2, 4);
//                newB2 = bottles.bottle2 - (newB1 - bottles.bottle1);
//                return new Bottles(newB1, newB2);
//        }
//        return state;
//    }


    @Override
    public Object getNextState(Object state, Object action) {
        Bottles bottles = (Bottles) state;
        return switch ((BottleAction) action) {
            case FILL_B1 -> new Bottles(4, bottles.bottle2);
            case FILL_B2 -> new Bottles(bottles.bottle1, 3);
            case EMPTY_B1 -> new Bottles(0, bottles.bottle2);
            case EMPTY_B2 -> new Bottles(bottles.bottle1, 0);
            case TRANSFER_B1_TO_B2 -> {
                int transferToB2 = Math.min(bottles.bottle1, 3 - bottles.bottle2);
                yield new Bottles(bottles.bottle1 - transferToB2, bottles.bottle2 + transferToB2);
            }
            case TRANSFER_B2_TO_B1 -> {
                int transferToB1 = Math.min(bottles.bottle2, 4 - bottles.bottle1);
                yield new Bottles(bottles.bottle1 + transferToB1, bottles.bottle2 - transferToB1);
            }
        };
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1; // Each action costs 1
    }
}
