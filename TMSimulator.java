import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TMSimulator {

    public static void main(String[] args) {
        
        int numStates;
        int numSymbols;
        String transitions = "";
        String tape = "0000000";

        try {
            Scanner fileScan = new Scanner(new File(args[0]));
            numStates = fileScan.nextInt();
            fileScan.nextLine();
            numSymbols = fileScan.nextInt();
            fileScan.nextLine();
            while (fileScan.hasNextLine()) {
                //Scanner lineScan = new Scanner(fileScan.nextLine());
                transitions += fileScan.nextLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // TM sim = new TM(numStates, numSymbols, transitions, tape);
        // sim.runSimulation();

    }


}