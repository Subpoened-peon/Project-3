package fa.tm;
import fa.State;
import java.util.*;

public class TMState extends State implements Comparable<TMState>{
    
    private Map<Character, Set<TMState>> myTransitions;

    public TMState(String name) {

        super(name);
        myTransitions = new HashMap<
    }

    @Override
    public int compareTo(TMState o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}