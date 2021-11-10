import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HashtableTest {


    public static void main(String[] args) {
        int inputType = -1;
        Double loadFactor = -1.0;
        int debugLevel = 0;     //default to 0
        int twinPrime;
        int numLinearElements;
        int numDoubleElements;
        int numLinearDuplicates;
        int numDoubleDuplicates;


        Random random;
        Scanner fileScan = null;
        TwinPrimeGenerator twinPrimeGen = new TwinPrimeGenerator();

        twinPrime = twinPrimeGen.twinPrimeGenerator(95500, 96000);

        //Check if number of arguments is valid
        if (args.length < 2 || args.length > 3) {
            printUsage();
            System.exit(0);
        }

        //Parse through arguments and make sure the arguments are valid

        //If arguments don't specify debugLevel
        if (args.length == 2) {

            try {
                inputType = Integer.parseInt(args[0]);
                loadFactor = Double.parseDouble(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Input type, load factor, and debug level must be numbers.\n");
                printUsage();
                System.exit(0);
            }
        }

        //If arguments specify debugLevel
        if (args.length == 3) {
            try {
                inputType = Integer.parseInt(args[0]);
                if (inputType < 1 || inputType > 3) {
                    printUsage();
                    System.exit(-1);
                }
                loadFactor = Double.parseDouble(args[1]);
                if (loadFactor < 0 || loadFactor > 1) {
                    printUsage();
                    System.exit(-1);
                }
                debugLevel = Integer.parseInt(args[2]);
                if (debugLevel < 0 || debugLevel > 2) {
                    printUsage();
                    System.exit(-1);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input type, load factor, and debug level must be numbers.\n");
                printUsage();
                System.exit(-1);
            }
        }

        //Print twin prime within range specified on assignment PDF if debug level is 0 or 1
        if (debugLevel == 0 || debugLevel == 1) {
            System.out.println("HashtableTest: Twin prime table size found in the range [95500..96000]: " + twinPrime);
        }

        //If input type is 1 - Random Numbers
        if (inputType == 1) {
            if (debugLevel == 0 || debugLevel == 1) {
                System.out.println("HashtableTest: Data source type --> random numbers");
            }
            random = new Random();
            LinearProbing<Integer> linearProbe = new LinearProbing<>(twinPrime);
            numLinearElements = 0;
            DoubleHashing<Integer> doubleHash = new DoubleHashing<>(twinPrime);
            if (debugLevel == 0 || debugLevel == 1) {
                System.out.println("\nHashtableTest: Using Linear Hashing....");
            }

            while (linearProbe.getLoadFactor() < loadFactor) {
                linearProbe.hashInsert(random.nextInt());
                numLinearElements++;
            }
            if (debugLevel == 0 || debugLevel == 1) {
                System.out.println("HashtableTest: Input " + numLinearElements + " elements, of which " + linearProbe.getDupes() + " duplicates");
                System.out.println("HashtableTest: load factor = " + loadFactor + ", Avg. no. of probes " + linearProbe.averageProbeCount());
            }

            numDoubleElements = 0;
            if (debugLevel == 0 || debugLevel == 1) {
                System.out.println("\nHashtableTest: Using Double Hashing....");
            }
            while (doubleHash.getLoadFactor() < loadFactor) {
                doubleHash.hashInsert(random.nextInt());
                numDoubleElements++;
            }
            if (debugLevel == 0 || debugLevel == 1) {
                System.out.println("HashtableTest: Input " + numDoubleElements + " elements, of which " + doubleHash.getDupes() + " duplicates");
                System.out.println("HashtableTest: load factor = " + loadFactor + ", Avg. no. of probes " + doubleHash.averageProbeCount());
            }
        }

        //If input type is 2 - System Time
        else if (inputType == 2) {
            if (debugLevel == 0 || debugLevel == 1) {
                System.out.println("HashtableTest: Data source type --> system time");
                System.out.println("\nHashtableTest: Using Linear Hashing....");
            }
            numLinearElements = 0;
            numDoubleElements = 0;
            LinearProbing<Long> linearProbe = new LinearProbing<Long>(twinPrime);
            DoubleHashing<Long> doubleHash = new DoubleHashing<Long>(twinPrime);
            while (linearProbe.getLoadFactor() < loadFactor && doubleHash.getLoadFactor() < loadFactor) {
                long currentTime = System.currentTimeMillis();
                linearProbe.hashInsert(currentTime);
                numLinearElements++;
                doubleHash.hashInsert(currentTime);
                numDoubleElements++;
            }
            if (debugLevel == 0 || debugLevel == 1) {
                System.out.println("HashtableTest: Input " + numLinearElements + " elements, of which " + linearProbe.getDupes() + " duplicates");
                System.out.println("HashtableTest: load factor = " + loadFactor + ", Avg. no. of probes " + linearProbe.averageProbeCount());
                System.out.println("\nHashtableTest: Using Double Hashing....");
                System.out.println("HashtableTest: Input " + numDoubleElements + " elements, of which " + doubleHash.getDupes() + " duplicates");
                System.out.println("HashtableTest: load factor = " + loadFactor + ", Avg. no. of probes " + doubleHash.averageProbeCount());
            }

        }

        //If input type is 3 - Word List
        else if (inputType == 3) {
            if (debugLevel == 0 || debugLevel == 1) {
                System.out.println("HashtableTest: Data source type --> word-list");
            }
            try {
                String nextLine;
                numLinearElements = 0;
                numDoubleElements = 0;
                fileScan = new Scanner(new File("word-list"));
                LinearProbing<String> linearProbe = new LinearProbing<String>(twinPrime);
                DoubleHashing<String> doubleHash = new DoubleHashing<String>(twinPrime);
                while (linearProbe.getLoadFactor() < loadFactor && doubleHash.getLoadFactor() < loadFactor) {
                    nextLine = fileScan.nextLine();
                    linearProbe.hashInsert(nextLine);
                    numLinearElements++;
                    doubleHash.hashInsert(nextLine);
                    numDoubleElements++;
                }
                if (debugLevel == 0 || debugLevel == 1) {
                    System.out.println("\nHashtableTest: Using Linear Hashing....");
                    System.out.println("HashtableTest: Input " + numLinearElements + " elements, of which " + linearProbe.getDupes() + " duplicates");
                    System.out.println("HashtableTest: load factor = " + loadFactor + ", Avg. no. of probes " + linearProbe.averageProbeCount());
                    System.out.println("\nHashtableTest: Using Double Hashing....");
                    System.out.println("HashtableTest: Input " + numDoubleElements + " elements, of which " + doubleHash.getDupes() + " duplicates");
                    System.out.println("HashtableTest: load factor = " + loadFactor + ", Avg. no. of probes " + doubleHash.averageProbeCount());
                }
                if (debugLevel == 1) {
                    //linear dump file
                    File linearDump = new File("linear-dump.txt");
                    FileWriter writer = new FileWriter(linearDump);

                    for (int i = 0; i < linearProbe.tableSize; i++) {
                        if (linearProbe.Table[i] != null) {
                            writer.write("table[" + i + "]: " + linearProbe.Table[i].toString() + "\n");
                        }
                    }
                    writer.close();

                    File doubleDump = new File("double-dump.txt");
                    FileWriter writer2 = new FileWriter(doubleDump);
                    for (int i = 0; i < doubleHash.tableSize; i++) {
                        if (doubleHash.Table[i] != null) {
                            writer2.write("table[" + i + "]: " + doubleHash.Table[i].toString() + "\n");
                        }
                    }
                    writer2.close();
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found.");
                System.exit(-1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileScan.close();
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
