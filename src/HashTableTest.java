public class HashTableTest {


    public static void main(String[] args) {
        int arg1;
        Double arg2;
        int arg3;
        if (args.length < 2 || args.length > 3) {
            System.out.println("Usage: java HashtableTest <input type> <load factor> [<debug level>]\n"
                    + "\tinput type = 1 for random numbers, 2 for system time, 3 for word list\n"
                    + "\tdebug = 0 ==> print summary of experiment\n"
                    + "\tdebug = 1 ==> save the two hash tables to a file at the end\n"
                    + "\tdebug = 2 ==> print debugging output for each insert\n");
            System.exit(0);
        }

        try {
            arg1 = Integer.parseInt(args[0]);
            arg2 = Double.parseDouble(args[1]);
            arg3 = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e) {
            System.out.println("Input type, load factor, and debug level must be numbers.\n");
            System.out.println("Usage: java HashtableTest <input type> <load factor> [<debug level>]\n"
                    + "\tinput type = 1 for random numbers, 2 for system time, 3 for word list\n"
                    + "\tdebug = 0 ==> print summary of experiment\n"
                    + "\tdebug = 1 ==> save the two hash tables to a file at the end\n"
                    + "\tdebug = 2 ==> print debugging output for each insert\n");
            System.exit(0);
        }

        TwinPrimeGenerator twinPrimeGen = new TwinPrimeGenerator();

        System.out.println("HashtableTest: Twin prime table size found in the range [95500..96000]: "
                + twinPrimeGen.twinPrimeGenerator(95500, 96000));

    }
}
