package fa.tm;

import fa.State;

//This class extends State to provide special functionality for the Turing machine
//Its most important feature is its array of transitions.

public class TMState extends State {
    
    //the index of myTransitions indicates which input it's for, and the second index is one of the 3 pieces of transition info  
    private String[][] myTransitions;
    private boolean isHalt;

    public TMState(String name, int numberOfStates, int numSymbols) {

        super(name);
        this.myTransitions = new String[numSymbols + 1][3];
        if(Integer.parseInt(name) != (numberOfStates - 1)) {
            this.isHalt = false;
        } else {
            this.isHalt = true;
        }
    }

    public void setHalt(boolean halt) {
        this.isHalt = halt;
    }
    public boolean haltCheck() {
        return isHalt;
    }

    //this format aligns with the format of the external file instructions
    public void addTransitions(int read, String toState, String write, String move) {
        myTransitions[read][0] = toState;
        myTransitions[read][1] = write;
        myTransitions[read][2] = move;
    }
    public String[][] getTransitions() {
        return myTransitions;
    }


}