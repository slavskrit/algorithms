// https://leetcode.com/problems/design-hashmap/
//
// Design a HashMap without using any built-in hash table libraries.
//
// To be specific, your design should include these functions:
//
// put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
// get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
// remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
//
// Example:
//
// MyHashMap hashMap = new MyHashMap();
// hashMap.put(1, 1);
// hashMap.put(2, 2);
// hashMap.get(1);            // returns 1
// hashMap.get(3);            // returns -1 (not found)
// hashMap.put(2, 1);          // update the existing value
// hashMap.get(2);            // returns 1 
// hashMap.remove(2);          // remove the mapping for 2
// hashMap.get(2);            // returns -1 (not found) 
//
// Note:
//
// All keys and values will be in the range of [0, 1000000].
// The number of operations will be in the range of [1, 10000].
// Please do not use the built-in HashMap library.


class MyHashMap {
    
    private class Node {
        final int key;
        int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int size = 8888;
    private int currentSize;
    private List<Node>[] bucket;

    /** Initialize your data structure here. */
    public MyHashMap() {
        currentSize = 0;
        bucket = new ArrayList[size]; 
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (++currentSize == size) {
            size <<= 1;
            List<Node>[] temp = new ArrayList[size];
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != null) {
                    for (Node t : bucket[i]) {
                        if (temp[t.key % size] == null) {
                            temp[t.key % size] = new ArrayList<>();
                        }
                        temp[t.key % size].add(t);
                    }
                }
            }
            bucket = temp;
        }
        if (bucket[key % size] == null) {
            bucket[key % size] = new ArrayList<>();
        }

        for (Node t : bucket[key % size]) {
            if (t.key == key) {
                t.value = value;
                return;
            }
        }

        bucket[key % size].add(new Node(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        if (bucket[key % size] != null) {
            for (Node n : bucket[key % size]) {
                if (n.key == key) return n.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        if (bucket[key % size] != null) {
            for (Node n : bucket[key % size]) {
                if (n.key == key) {
                    bucket[key % size].remove(n);
                    return;
                }
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
