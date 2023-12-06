package fa.tm;

import fa.State;

public class TMState extends State {
    
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

    public void addTransitions(int read, String toState, String write, String move) {
        myTransitions[read][0] = toState;
        myTransitions[read][1] = write;
        myTransitions[read][2] = move;
    }
    public String[][] getTransitions() {
        return myTransitions;
    }


}