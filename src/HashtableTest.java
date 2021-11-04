import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HashtableTest {


    public static void main(String[] args) {
        int arg1 = -1;
        Double arg2 = -1.0;
        int arg3 = 0;
        int twinPrime;
        HashObject addObj;
        Random random;
        Scanner fileScan;
        TwinPrimeGenerator twinPrimeGen = new TwinPrimeGenerator();

        twinPrime = twinPrimeGen.twinPrimeGenerator(95500, 96000);

        //Parse through arguments and make sure the arguments are valid
        if (args.length < 2 || args.length > 3) {
            printUsage();
            System.exit(0);
        }

        //If debug level is not specified, default to 0
        if (args.length == 2) {

            try {
                arg1 = Integer.parseInt(args[0]);
                arg2 = Double.parseDouble(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Input type, load factor, and debug level must be numbers.\n");
                printUsage();
                System.exit(0);
            }
        }

        //If debug level is specified, parse it from arguments
        if (args.length == 3) {
            try {
                arg1 = Integer.parseInt(args[0]);
                if (arg1 < 1 || arg1 > 3) {
                    printUsage();
                    System.exit(-1);
                }
                arg2 = Double.parseDouble(args[1]);
                if (arg2 < 0 || arg2 > 1) {
                    printUsage();
                    System.exit(-1);
                }
                arg3 = Integer.parseInt(args[2]);
                if (arg3 < 0 || arg3 > 2) {
                    printUsage();
                    System.exit(-1);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input type, load factor, and debug level must be numbers.\n");
                printUsage();
                System.exit(-1);
            }
        }

        //Find twin prime within range specified on assignment PDF if debug level is 0 or 1
        if (arg3 == 0 || arg3 == 1) {
            System.out.println("HashtableTest: Twin prime table size found in the range [95500..96000]: " + twinPrime);
        }

        //If input type is 1 - Random Numbers
        if (arg1 == 1) {
            random = new Random();
            LinearProbing<Integer> linearProbe = new LinearProbing<Integer>(twinPrime);
            DoubleHashing<Integer> doubleHash = new DoubleHashing<Integer>(twinPrime);
            while (linearProbe.getLoadFactor() < arg2 && doubleHash.getLoadFactor() < arg2) {
                linearProbe.hashInsert(random.nextInt());
                doubleHash.hashInsert(random.nextInt());
            }
        }

        //If input type is 2 - System Time
        else if (arg1 == 2) {
            LinearProbing<Long> linearProbe = new LinearProbing<Long>(twinPrime);
            DoubleHashing<Long> doubleHash = new DoubleHashing<Long>(twinPrime);
            while (linearProbe.getLoadFactor() < arg2 && doubleHash.getLoadFactor() < arg2) {
                long currentTime = System.currentTimeMillis();
                linearProbe.hashInsert(currentTime);
                doubleHash.hashInsert(currentTime);
            }
        }

        //If input type is 3 - Word List
        else if (arg1 == 3) {
            try {
                String nextLine;
                fileScan = new Scanner(new File("word-list"));
                LinearProbing<String> linearProbe = new LinearProbing<String>(twinPrime);
                DoubleHashing<String> doubleHash = new DoubleHashing<String>(twinPrime);
                while (linearProbe.getLoadFactor() < arg2 && doubleHash.getLoadFactor() < arg2) {
                    nextLine = fileScan.nextLine();
                    linearProbe.hashInsert(nextLine);
                    doubleHash.hashInsert(nextLine);
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found.");
                System.exit(-1);
            }
        }


    }


    public static void printUsage() {
        System.out.println("Input type, load factor, and debug level must be numbers.\n");
        System.out.println("Usage: java HashtableTest <input type> <load factor> [<debug level>]\n"
                + "\tinput type = 1 for random numbers, 2 for system time, 3 for word list\n"
                + "\tdebug = 0 ==> print summary of experiment\n"
                + "\tdebug = 1 ==> save the two hash tables to a file at the end\n"
                + "\tdebug = 2 ==> print debugging output for each insert\n");
    }

}
