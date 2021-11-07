public class DoubleHashing<T> extends HashTable<T>{

    public DoubleHashing(int size) {
        super(size);
    }

    /*
     *
     */
    @Override
    public int hashFunction(T key, int index) {
        int h1 = positiveMod(key.hashCode(), tableSize);
        int h2 = 1 + positiveMod(key.hashCode(), tableSize - 2);
        return (h1 + index +h2) % tableSize;
    }
}
