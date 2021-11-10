public class DoubleHashing<T> extends HashTable<T>{

    public DoubleHashing(int size) {
        super(size);
    }

    /* Defines the abstract method in HashTable.java
        for double hashing.
     */
    @Override
    public int hashFunction(T key, int index) {
        int h1 = positiveMod(key.hashCode(), Table.length);
        int h2 = 1 + positiveMod(key.hashCode(), Table.length - 2);
        return positiveMod(h1 + index * h2, Table.length);
    }
}
