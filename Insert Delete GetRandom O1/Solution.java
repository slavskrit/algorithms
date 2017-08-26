// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed
//
// Design a data structure that supports all following operations in average O(1) time.
// Note: Duplicate elements are allowed.
//
//
// insert(val): Inserts an item val to the collection.
// remove(val): Removes an item val from the collection if present.
// getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
//
//
// Example:
//
// // Init an empty collection.
// RandomizedCollection collection = new RandomizedCollection();
//
// // Inserts 1 to the collection. Returns true as the collection did not contain 1.
// collection.insert(1);
//
// // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
// collection.insert(1);
//
// // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
// collection.insert(2);
//
// // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
// collection.getRandom();
//
// // Removes 1 from the collection, returns true. Collection now contains [1,2].
// collection.remove(1);
//
// // getRandom should return 1 and 2 both equally likely.
// collection.getRandom();
//
//
import java.util.Random;

public class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
     public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer t = map.get(val);
        if (t == null) {
            return false;
        } else {
            int r = list.get(list.size() - 1);
            list.set(t, r);
            map.put(r, t);
            map.remove(val);
            list.remove(list.size() - 1);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
