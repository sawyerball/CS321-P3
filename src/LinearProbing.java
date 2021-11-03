public class LinearProbing<T> extends HashTable<T>{

    public LinearProbing(int size) {
        super(size);

        /*
         *
         */
    }

    /*
     *
     */
    @Override
    public int hashFunction(T key, int index) {
        return positiveMod(key.hashCode() + index, tableSize);
    }
}
