package Tuple;

public class Tuple<K, V> {
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    private K key;
    private V value;

    public Tuple(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
