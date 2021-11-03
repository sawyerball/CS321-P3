public class HashTableTest {


    public static void main(String[] args) {

        TwinPrimeGenerator twinPrimeGen = new TwinPrimeGenerator();

        System.out.println("HashtableTest: Twin prime table size found in the range [95500..96000]: "
                + twinPrimeGen.twinPrimeGenerator(95500, 96000));

    }
}
