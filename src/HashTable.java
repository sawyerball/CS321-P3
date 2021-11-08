public abstract class HashTable<T> {
    HashObject<T>[] Table;
    int tableSize;
    int tablePopulation = 0;

    /* Constructs a new hash table of the
        input table size.
     */
    public HashTable(int size) {
        tableSize = size;
        Table = new HashObject[tableSize];
    }

    /* Inserts the hash object into the
        table.
     */
    public int hashInsert(T key) {
        int i = 0;
        int j = 0;
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


    /* Returns the current load factor of the
        table.
     */
    public double getLoadFactor() {
        return ((double)tablePopulation/tableSize);
    }

    /* Positive mod function provided in the
        assignment PDF.
     */
    protected int positiveMod(int dividend, int divisor) {
        int value = dividend % divisor;
        if (value < 0) {
            value += divisor;
        }
        return value;
    }

    /* Returns the number of duplicate entries
        in the table.
     */
    public int getDupes() {
        int totalDupes = 0;

        for (int i = 0; i < Table.length; i++) {
            if (Table[i] != null) {
                totalDupes += Table[i].getFrequency();
            }
        }

        return totalDupes;
    }

    /* Finds and returns the average probe
        count in the table.
     */
    public double averageProbeCount() {
        int totalProbes = 0;

        for (int i = 0; i < Table.length; i++) {
            if (Table[i] != null) {
                totalProbes += Table[i].getProbes();
            }
        }

        return (Table.length/(double)totalProbes);
    }


    /* Abstract hash function method to be used
        in LinearProbing.java and DoubleHashing.java.
     */
    public abstract int hashFunction(T key, int index);
}