/**
 * Extends HashTable.java. Finishes abstract methods
 * so that HashTable.java may be used with a linear
 * function.
 * @param <T> Generic that determines what data type to use.
 * @author Sawyer Ball
 */
public class LinearProbing<T> extends HashTable<T>{

    public LinearProbing(int size) {
        super(size);
    }

    /**
     * Defines the abstract method in HashTable.java for
     * linear probing.
     * @param key Object that is being added to HashTable.
     * @param index Int used to find index in hashFunction.
     * @return Location for object.
     */
    @Override
    public int hashFunction(T key, int index) {
        return positiveMod(key.hashCode() + index, tableSize);
    }
}
