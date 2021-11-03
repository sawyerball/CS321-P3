public class DoubleHashing<T> extends HashTable<T>{

    public DoubleHashing(int size) {
        super(size);
    }

    /*
     *
     */
    @Override
    public int hashFunction(T key, int index) {
        return 0; //(1 + positiveMod(key.hashCode(), tableSize - 2)) * index) + positiveMod(key.hashCode() + index, tableSize);
    }
}
