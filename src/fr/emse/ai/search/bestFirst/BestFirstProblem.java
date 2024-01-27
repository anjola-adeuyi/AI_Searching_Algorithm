package fr.emse.ai.search.bestFirst;

import fr.emse.ai.search.uc.UniformCostProblem;

public class BestFirstProblem extends UniformCostProblem {

    public BestFirstProblem() {
        initialState = new HeuristicState(HeuristicState.A);
        finalState = new HeuristicState(HeuristicState.H);
    }

    @Override
    public Object getNextState(Object state, Object action) {
        if (!(state instanceof HeuristicState)) {
            throw new IllegalArgumentException("State must be a HeuristicState");
        }

        String stateVal = ((HeuristicState) state).value;

        if (stateVal.equals(HeuristicState.A) && action.equals("go to B")) {
            return new HeuristicState(HeuristicState.B);
        } else if (stateVal.equals(HeuristicState.A) && action.equals("go to C")) {
            return new HeuristicState(HeuristicState.C);
        } else if (stateVal.equals(HeuristicState.B) && action.equals("go to D")) {
            return new HeuristicState(HeuristicState.D);
        } else if (stateVal.equals(HeuristicState.B) && action.equals("go to E")) {
            return new HeuristicState(HeuristicState.E);
        } else if (stateVal.equals(HeuristicState.C) && action.equals("go to D")) {
            return new HeuristicState(HeuristicState.D);
        } else if (stateVal.equals(HeuristicState.D) && action.equals("go to G")) {
            return new HeuristicState(HeuristicState.G);
        } else if (stateVal.equals(HeuristicState.E) && action.equals("go to F")) {
            return new HeuristicState(HeuristicState.F);
        } else if (stateVal.equals(HeuristicState.F) && action.equals("go to H")) {
            return new HeuristicState(HeuristicState.H);
        } else if (stateVal.equals(HeuristicState.G) && action.equals("go to H")) {
            return new HeuristicState(HeuristicState.H);
        }

        return null;
    }
}
