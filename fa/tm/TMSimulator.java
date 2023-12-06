package fa.tm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class TMSimulator {

    public static void main(String[] args) {
        
        int numStates = 0;
        int numSymbols = 0;
        String transitions = "";
        ArrayList<String> tape = new ArrayList<String>();;

        //this if statement handles the arguments
        if(args.length == 2) {
            String[] strSplit = args[1].split("");
            tape = new ArrayList<String>(Arrays.asList(strSplit));
        } else if (args.length == 1) {
            tape.add("0");
        } else {
            System.out.println("\n****ERROR: invalid number of arguments****\n");
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
                transitions += fileScan.nextLine() + " ";
            }
            fileScan.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //here we create the Turing machine and run the simulation
        TM sim = new TM(numStates, numSymbols, transitions, tape);
        sim.runSimulation();
        String tapeString = sim.tapeToString();
        int tapeLength = tapeString.length();

        //here we construct the output
        if(tapeString.length() > 500) tapeString = "very large";
        String output = args[0] + "\n"
                        + "output: " + tapeString + "\n"
                        + "output length: " + tapeLength + "\n"
                        + "sum of symbols: " + sim.getSum();
         
        System.out.println("\n" + output + "\n");

    }


}