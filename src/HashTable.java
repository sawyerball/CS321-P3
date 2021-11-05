public abstract class HashTable<T> {
    HashObject<T>[] Table;
    int tableSize;
    int tablePopulation = 0;

    /*
     *
     */
    public HashTable(int size) {
        tableSize = size;
        Table = new HashObject[tableSize];
    }

    /*
     *
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
            }
            else {
                i++;
            }
        }

        System.err.println("HashTableUnderflow");
        return -1;
    }


    /*
     *
     */
    public double getLoadFactor() {
        return ((double)tablePopulation/tableSize);
    }

    /*
     *
     */
    protected int positiveMod(int dividend, int divisor) {
        int value = dividend % divisor;
        if (value < 0) {
            value += divisor;
        }
        return value;
    }

    public int getDupes() {
        int totalDupes = 0;

        for (int i = 0; i < Table.length; i++) {
            if (Table[i] != null) {
                totalDupes += Table[i].getFrequency();
            }
        }

        return totalDupes;
    }

    public double averageProbeCount() {
        int totalProbes = 0;

        for (int i = 0; i < Table.length; i++) {
            if (Table[i] != null) {
                totalProbes += Table[i].getProbes();
            }
        }

        return (Table.length/(double)totalProbes);
    }

    /*
     *
     */
    public abstract int hashFunction(T key, int index);
}