/**
 * Creates an array of HashObjects from the HashObject.java
 * class. Uses generic <T> so that HashTable may be used
 * with any data type.
 * @param <T> Generic type to be used to create the HashTable
 * @author Sawyer Ball
 */
public abstract class HashTable<T> {
    HashObject<T>[] Table;
    int tableSize;
    int tablePopulation = 0;

    /**
     * Constructor that creates and initializes the HashTable
     * and its size.
     * @param size The desired size of the HashTable
     */
    public HashTable(int size) {
        tableSize = size;
        Table = new HashObject[tableSize];
    }

    /**
     * Inserts object into HashTable using the desire
     * HashFunction to find the correct index for it.
     * Increases the frequency if object has already
     * been added in that location.
     * @param key Object being added to HashTable.
     * @return Index of where key was added.
     */
    public int hashInsert(T key) {
        int i = 0;
        int j;
        while (i != tableSize) {
            j = hashFunction(key, i);
            if (Table[j] == null) {
                Table[j] = new HashObject<T>(key, i + 1) ;
                tablePopulation++;
                return i;
            }
            else if(Table[j].equals(key)){
                Table[j].increaseFrequency();
                return i;
            }
            else {
                i++;
            }
        }

        System.err.println("HashTableUnderflow");
        return -1;
    }

    /**
     * Calculates and returns what the current load
     * factor of the HashTable is.
     * @return A double that represents the current
     * load factor of the HashTable.
     */
    public double getLoadFactor() {
        return ((double)tablePopulation/tableSize);
    }

    /**
     * Performs a modulo division and then verifies that the
     * value is greater than 0. If not, it adds divisor to
     * the value. This method was provided in the assignment
     * instructions PDF.
     * @param dividend Int one that is being divided.
     * @param divisor Int two that is dividing int one.
     * @return Int representing the answer of the function
     * performed.
     */
    protected int positiveMod(int dividend, int divisor) {
        int value = dividend % divisor;
        if (value < 0) {
            value += divisor;
        }
        return value;
    }

    /**
     * Goes through the HashTable and adds up the
     * number of duplicates.
     * @return Int representing the total number of
     * duplicate entries in the HashTable.
     */
    public long getDupes() {
        long totalDupes = 0;

        for (int i = 0; i < Table.length; i++) {
            if (Table[i] != null) {
                totalDupes += Table[i].getFrequency();
            }
        }

        return totalDupes;
    }

    /**
     * Goes through the table to count the total
     * number of probes. It then divides this number
     * by the population of the table to find the
     * average probe count.
     * @return Double representing the average probe count.
     */
    public double averageProbeCount() {
        int totalProbes = 0;

        for (int i = 0; i < Table.length; i++) {
            if (Table[i] != null) {
                totalProbes += Table[i].getProbes();
            }
        }
        return ((double)totalProbes/tablePopulation);
    }

    /**
     * Abstract hash function method that is finished in
     * LinearProbing.java and DoubleHashing.java.
     * @param key Object that is being added to HashTable.
     * @param index Int used to find index in hashFunction.
     * @return Location where object should be inserted.
     */
    public abstract int hashFunction(T key, int index);
}