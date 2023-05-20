public class MyHashTable<K, V> {
    /**
     * This private class represents a node in a linked list that stores a key-value pair.
     * Each node has a key of type K, a value of type V, and a reference to the next node in the list.
     */
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
        this(25);
    }
    /**
     * Constructs a new hash table with the specified capacity.
     * @param M the capacity of the hash table
     */
    public MyHashTable(int M) {
        this.M = M;
        this.size = 0;
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
    }
    /**
     * Returns the number of key-value mappings in this hash table.
     * @return the number of key-value mappings in this hash table
     */
    public int getSize() {
        return size;
    }
    /**
     * This method calculates the hash code of a key using the built-in hashCode() method of the key object.
     * If the key is null, the hash code is zero.
     */
    private int hash(K key) {
        int hash = key.hashCode();
        hash = hash * 31;
        return Math.abs(hash % M);
    }
    /**
     * Associates the specified value with the specified key in this hash table.
     * If the hash table previously contained a mapping for the key, the old value is replaced.
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @throws IllegalArgumentException if the specified key is null
     */
    public void put (K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }
    /**
     * Returns the value to which the specified key is mapped, or null if this hash table contains no mapping for the key.
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this hash table contains no mapping for the key
     */
    public V get (K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    /**
     * Removes the mapping for the specified key from this hash table if present.
     * @param key the key whose mapping is to be removed from the hash table
     * @return the value to which the key was previously mapped, or null if the key is not present in the hash table
     */
    public V remove (K key) {int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }
    /**
     * This method calculates the hash code of a key using the built-in hashCode() method of the key object.
     * If the key is null, the hash code is zero.
     */
    public boolean contains (V value) {for (int i = 0; i < M; i++) {
        HashNode<K, V> node = chainArray[i];
        while (node != null) {
            if (node.value.equals(value)) {
                return true;
            }
            node = node.next;
        }
    }
        return false;
    }
    /**
     * Returns the key associated with the given value.
     * @param value the value to search for in the table
     * @return the key associated with the value, or null if the value is not in the table
     */
    public K getKey (V value) {for (int i = 0; i < M; i++) {
        HashNode<K, V> node = chainArray[i];
        while (node != null) {
            if (node.value.equals(value)) {
                return node.key;
            }
            node = node.next;
        }
    }
        return null;
    }
    /**
     * Returns the number of elements in the bucket at the given index.
     * @param index the index of the bucket to get the size of
     * @return the number of elements in the bucket
     * @throws IllegalArgumentException if the index is out of bounds
     */
    public int getBucketSize(int index) {
        if (index < 0 || index >= M) {
            throw new IllegalArgumentException("Invalid bucket index");
        }
        int count = 0;
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
    /**
     * Clears all elements from the table.
     */
    public void clear() {
        for (int i = 0; i < M; i++) {
            chainArray[i] = null;
        }
        size = 0;
    }
    public V newHash(int index, int key) {
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }
}
