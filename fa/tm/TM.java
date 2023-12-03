package fa.tm;
import java.util.ArrayList;
import java.util.Scanner;


public class TM{

    private TMState currState;
    private int allowedSymbols;
    private ArrayList<TMState> turStates;
    private ArrayList<String> tape;
    private int numberOfStates;
    private int sum;
    private String remTransitions;
    private int visited;

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
        int index = 0;
        this.visited = 0;
        Scanner scan = new Scanner(this.remTransitions);

        while(!currState.haltCheck() && scan.hasNext()) {
            String transition = scan.next();
            String[] transitionParts = transition.split(",");
            String nextState = transitionParts[0].trim();
            String writeSymbol = transitionParts[1].trim();
            String direction = transitionParts[2].trim();

            currState = turStates.get(Integer.parseInt(nextState));

            tape.set(index, writeSymbol);

            if(direction == "R") {
                index++;
                if(this.visited < index) {
                    this.visited = index;
                }
            } else if(direction == "L") {
                if(index == 0) {
                    this.visited++;
                    tape.add(0, "0");
                }
                else index--;
            }


        }

        scan.close();
    }

    public String tapeToString() {
        String tapeString = "";
        this.sum = 0;
        for(int i = 0; i < this.visited; i++) {
            this.sum += this.sum + Integer.parseInt(tape.get(i));
            tapeString += tape.get(i);
        }
        return tapeString;
    }

    public int getSum() {
        return this.sum;
    }
}