public class HashTableTest {


    public static void main(String[] args) {
        int arg1;
        Double arg2;
        int arg3;
        int twinPrime;
        double loadFactor;
        TwinPrimeGenerator twinPrimeGen = new TwinPrimeGenerator();

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
                arg3 = 0;
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
                arg2 = Double.parseDouble(args[1]);
                arg3 = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Input type, load factor, and debug level must be numbers.\n");
                printUsage();
                System.exit(0);
            }
        }

        //Find twin prime within range specified on assignment PDF
        twinPrime = twinPrimeGen.twinPrimeGenerator(95500, 96000);
        System.out.println("HashtableTest: Twin prime table size found in the range [95500..96000]: " + twinPrime);

        //Create both hash tables needed for testing
        LinearProbing<Integer> linearProbe = new LinearProbing<Integer>(twinPrime);
        DoubleHashing<Integer> doubleHash = new DoubleHashing<Integer>(twinPrime);



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
