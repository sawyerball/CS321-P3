public abstract class HashObject {
    private Object key;
    private int frequency;
    private int probe;

    @Override
    public boolean equals(Object object) {

        return true;
    }

    @Override
    public String toString() {

        return null;
    }

    public Object getKey() {

        return key;
    }
}
