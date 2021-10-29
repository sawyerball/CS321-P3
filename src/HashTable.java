public abstract class HashTable<T> {
    HashObject<T>[] Table;
    int tableSize = 10;
//    int tablePopulation;

    /*
     *
     */
    public HashTable() {
        Table = new HashObject[tableSize];
    }

    /*
     *
     */
    public int HashSearch(T key) {
        int i = 0;
        while (Table[i] != null || i != tableSize ) {

        }

        return 0;
    }

    /*
     *
     */
    public void HashInsert() {

    }

    /*
     *
     */
    public void HashDelete() {

    }

    /*
     *
     */
    public T HashFunction() {

        return null;
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
}



