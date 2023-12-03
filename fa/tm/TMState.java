package fa.tm;
import fa.State;
import java.util.*;

public class TMState extends State {
    
    private Map<Character, TMState> myTransitions;
    private boolean isHalt;

    public TMState(String name, int numberOfStates) {

        super(name);
        this.myTransitions = new HashMap<Character, TMState>();
        if(Integer.parseInt(name) != (numberOfStates - 1)) {
            this.isHalt = false;
        } else {
            this.isHalt = true;
        }
    }

    public boolean haltCheck() {
        return isHalt;
    }

    public void addTransitions(char symbol, TMState state) {
        myTransitions.put(symbol, state);
    }

}