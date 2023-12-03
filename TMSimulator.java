import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TMSimulator {

    public static void main(String[] args) {
        
        int numStates;
        int numSymbols;
        String transitions = "";
        String tape = "";

        //this if statement handles the arguments
        if(args.length == 2) {
            tape = args[1];
        } else if (args.length == 1) {
            tape = "0000000";
        } else {
            System.out.println("\nERROR: invalid number of arguments");
        }
        
        //this try-catch block scans and stores the data in the file
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
            fileScan.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //here we create the Turing machine and run the simulation
        TM sim = new TM(numStates, numSymbols, transitions, tape);
        tape = sim.runSimulation();

        //here we construct the output
        if(tape.length() > 500) tape = "very large";
        String output = args[0] + "\n"
                        + "output: " + tape + "\n"
                        + "output length: " + tape.length() + "\n"
                        + "sum of symbols: " + sim.getSum();
         
        System.out.println("\n" + output + "\n");

    }


}