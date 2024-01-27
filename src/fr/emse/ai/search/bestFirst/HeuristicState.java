package fr.emse.ai.search.bestFirst;

import fr.emse.ai.search.simple.SimpleState;

public class HeuristicState extends SimpleState {

    public final static int hA = 10;
    public final static int hB = 2;
    public final static int hC = 12;
    public final static int hD = 9;
    public final static int hE = 4;
    public final static int hF = 2;
    public final static int hG = 3;
    public final static int hH = 0;

    public HeuristicState(String value) {
        super(value);
    }

    public int getHValue() {
        if (value.equals("A")){
            return hA;
        }
        if (value.equals("B")){
            return hB;
        }
        if (value.equals("C")){
            return hC;
        }
        if (value.equals("D")){
            return hD;
        }
        if (value.equals("E")){
            return hE;
        }
        if (value.equals("F")){
            return hF;
        }
        if (value.equals("G")){
            return hG;
        }
        if (value.equals("H")){
            return hH;
        }

        return Integer.MAX_VALUE;
    }
}
