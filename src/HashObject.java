/**
 * Class that defines and creates a HashObject. This
 * object contains a key, frequency count, and a probe
 * count. This object will be used in creating a
 * Hash Table in HashTable.java.
 * @param <T> Generic used so that the key of the object
 *           can be of any data type.
 * @author Sawyer Ball
 */
public class HashObject<T> {
    private T key;
    private int frequencyCount;
    private int probeCount;


    /**
     * Constructor to create the hash object with the
     * passed in key and probe count.
     * @param passedInKey Key that is assigned to the
     *                    constructed hash object.
     * @param passedInProbeCount Probe count that is
     *                           assigned to the
     *                           constructed hash object.
     */
    public HashObject(T passedInKey, int passedInProbeCount) {
        key = passedInKey; //hashCode()?
        frequencyCount = 0;
        probeCount = passedInProbeCount;
    }

    /**
     * Checks if the passed in object equals the key of
     * the hash object.
     * @param obj Object to compare to hash object.
     * @return True if object equals hash object key.
     *         False if object does not equal hash object key.
     */
    @Override
    public boolean equals(Object obj) {
        return key.equals(obj);
    }

    /**
     * Creates a string to be able to view the hash object's
     * key, frequency count, and probe count.
     * @return String representing the hash object.
     */
    @Override
    public String toString() {
        String output = key + " " + frequencyCount + " " + probeCount;
        return output;
    }

    /**
     * Gets the key of the hash object.
     * @return Key of hash object.
     */
    public T getKey() {
        return key;
    }

    /**
     * Finds the number of times the hash object is
     * in the hash table.
     * @return Frequency of hash object.
     */
    public int getFrequency() {
        return frequencyCount;
    }

    /**
     * Finds the number of times the hash object was
     * probed.
     * @return Int representing the probe count.
     */
    public int getProbes() {
        return probeCount;
    }

    /**
     * Increases frequency of the hash object by one.
     */
    public void increaseFrequency(){
        frequencyCount++;
    }
}
