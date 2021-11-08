public class LinearProbing<T> extends HashTable<T>{

    public LinearProbing(int size) {
        super(size);
    }

    /* Defines the abstract method in HashTable.java
        for linear probing.
     */
    @Override
    public int hashFunction(T key, int index) {
        return positiveMod(key.hashCode() + index, tableSize);
    }
}
