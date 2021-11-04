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
                Table[j] = new HashObject<T>(key, i) ;
                tablePopulation++;
                return i;
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

    /*
     *
     */
    public abstract int hashFunction(T key, int index);
}