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
    public HashObject(T passedInKey, int passedInProbeCount) {
        key = passedInKey; //hashCode()?
        frequencyCount = 0;
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
    public String toString() { //TODO
        String output = key + " " + frequencyCount + " " + probeCount;
        return output;
    }

    /*
     *
     */
    public T getKey() {
        return key;
    }

    public int getFrequency() {
        return frequencyCount;
    }

    public int getProbes() {
        return probeCount;
    }

    public void increaseFrequency(){
        frequencyCount++;
    }
}
