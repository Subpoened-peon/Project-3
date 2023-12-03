package fa.tm;
import java.util.ArrayList;

import fa.State;

public class TM{

    private TMState currState;
    private int allowedSymbols;
    private ArrayList<TMState> turStates;
    private ArrayList<String> tape;
    private int numberOfStates;
    private int sum;
    private String remTransitions;

/**
 * Constructor
 * @param numberOfStates
 * @param allowedSymbols
 * @param transitions
 * @param inputString
 */
    public TM(int numberOfStates, int allowedSymbols, String transitions, ArrayList<String> inputString) {
        this.allowedSymbols = allowedSymbols;
        this.numberOfStates = numberOfStates;
        this.tape = inputString;
        for(int i = 0; i < this.numberOfStates; i++) {
            TMState state = new TMState(String.valueOf(i), this.numberOfStates);
            this.turStates.add(state);
        }
        for(int i = 0; i < (this.numberOfStates - 1); i++) {
                for(int j = 0; j < this.numberOfStates; j++) {
                    this.turStates.get(i).addTransitions(String.valueOf(j), turStates.get(j));
                }
        }
        this.currState = turStates.get(0);
        this.remTransitions = transitions;
    }

    public void runSimulation() {

    }

    public String tapeToString() {
        String tapeString = "";
        this.sum = 0;

        for(int i = 0; i < tape.size(); i++) {
            if(tape.get(i) != "0") {
                sum += Integer.parseInt(tape.get(i));
                tapeString += tape.get(i);
            }
        }

        return tapeString;
    }

    public int getSum() {
        return this.sum;
    }
}