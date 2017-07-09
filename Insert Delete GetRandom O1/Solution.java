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
