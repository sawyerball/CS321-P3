public abstract class HashTable<T> {
    HashObject<T>[] Table;
    int tableSize;

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
    public int HashSearch(T key) {
        int i = 0;
        int j = 0; //what is j?
        while (Table[j] != null || i != tableSize ) {
//            j = HashFunction(key, i);
            if (Table[j] == key) {
                return j;
            }
            else {
                i++;
            }
        }

        return 0; //return nil?
    }

    /*
     *
     */
    public void HashInsert(T key) {
        int i = 0;
        int j = 0;
        while (i != tableSize) {
//            j = HashFunction(key, i);
//            if (Table[j] == null || DELETED) {
//                Table[j] = key;
//                return j;
//            }
//            else {
//                i++;
//            }
        }
        //deal with "hash table underflow" error
    }

    /*
     *
     */
    public void HashDelete(int key) {
        int i = 0;
        int j = 0;
        while (Table[i] != null || i != tableSize) {
//            j = HashFunction(key, i);
//            if (Table[j] == key) {
//                Table[j] = DELETED;
//                return j;
//            }
//            else {
//                i++;
//            }
        }
        //deal with "k is not in the table" error
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



