package fa.tm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * This file implements the guts of the Turing machine.
 * It takes a list of instructions and it can execute them.
 */

public class TM{

    private TMState currState;
    private int allowedSymbols;
    private ArrayList<TMState> turStates;
    private ArrayList<String> tape;
    private int numberOfStates;
    private int sum;
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
        System.out.println(tape);
        System.out.println(transitions + "\n");
        
        //sets up the states and transitions
        this.turStates = new ArrayList<TMState>();
        Scanner scan = new Scanner(transitions);
        scan.useDelimiter(" ");
        for(int i = 0; i < this.numberOfStates; i++) {
            TMState state = new TMState(String.valueOf(i), this.numberOfStates, this.allowedSymbols);
            
            if(i == this.numberOfStates - 1) {
                state.setHalt(true);
                turStates.add(state);
            } else {
                int j = 0;
                for(; j <= allowedSymbols; j++) {
                    
                    //splitting the transition symbols into individual values
                    String[] tSplit = scan.next().split(",");
                    state.addTransitions(j, tSplit[0], tSplit[1], tSplit[2]);
                }
                
                this.turStates.add(state);
            }
            
        }
        scan.close();
        //for debugging, prints transitions of each state
        for(int a = 0; a < numberOfStates - 1; a++) {
            System.out.println("State: " + a);
            for(int b = 0; b <= allowedSymbols; b++) {
                System.out.println(Arrays.toString(turStates.get(a).getTransitions()[b]));
            }
            System.out.println();
        }
        //state 0 is alwyas the start state
        this.currState = turStates.get(0);
    }

    public void runSimulation() {
        int index = 0;
        this.visited = 0;
        while(!currState.haltCheck()) {
           
            //getting the information we need to setup the transition
            int inputSymbol = Integer.parseInt(tape.get(index)); 
            String writeSymbol = currState.getTransitions()[inputSymbol][1];
            String direction = currState.getTransitions()[inputSymbol][2];
            //this is the transition
            TMState nextState = turStates.get(Integer.parseInt(currState.getTransitions()[inputSymbol][0]));
            currState = nextState;

            tape.set(index, writeSymbol);

            //these conditions manage the tape and the R/W pointer (which is at 'index')
            if(direction.equals("R")) {
                index++;
                if(index >= tape.size()) tape.add("0");
                if(this.visited < index) {
                    this.visited = index;
                }
            } else if(direction.equals("L")) {
                if(index == 0) {
                    this.visited++;
                    if(!currState.haltCheck()) {
                        tape.add(0, "0");
                    }
                }
                else index--;
            }
        }
    }

    //gets the tape and ignores the edge zeroes
    public String tapeToString() {
        String tapeString = "";
        this.sum = 0;
        for(int i = 0; i <= this.visited; i++) {
            this.sum += Integer.parseInt(tape.get(i));
            tapeString += tape.get(i);
        }
        return tapeString;
    }

    public int getSum() {
        return this.sum;
    }
}