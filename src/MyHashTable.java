public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;
        private HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{"+key+" "+value+"}";
        }
    }
    private HashNode<K, V>[] chainArray;
    private int M;
    private int size;
    public MyHashTable() {
        this(16);
    }
    public MyHashTable(int M) {
        this.M = M;
        this.size = 0;
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
    }
    private int hash(K key) {
        return Math.abs(key.hashCode() % M);
    }
    public void put (K key, V value) {
        if(key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
    }
    public V get (K key) {return null;}
    public V remove (K key) {return null;}
    public boolean contains (V value) {return true;}
    public K getKey (V value) {return null;}
}
