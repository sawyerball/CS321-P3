/*
 *
 */
public class HashObject<T> {
    private T key;
    private int frequencyCount;
    private int probeCount;


    /*
     *
     */
    public HashObject(T passedInKey, int passedInFrequency, int passedInProbeCount) {
        key = passedInKey;
        frequencyCount = passedInFrequency;
        probeCount = passedInProbeCount;
    }

    /*
     *
     */
    @Override
    public boolean equals(Object obj) {
        return key.equals(obj);
    }

    /*
     *
     */
    @Override
    public String toString() {

        return null;
    }

    /*
     *
     */
    public T getKey() {
        return key;
    }

}
