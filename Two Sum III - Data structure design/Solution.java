// https://leetcode.com/problems/two-sum-iii-data-structure-design/
// 
// Design and implement a TwoSum class. It should support the following operations: add and find.
// 
// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.
// 
// For example,
// add(1); add(3); add(5);
// find(4) -> true
// find(7) -> false
class TwoSum {

    private Map<Integer, Integer> map;

    public TwoSum() {
        this.map = new TreeMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int j = value - i;
            if ((i == j && entry.getValue() > 1) || (i != j && map.containsKey(j))) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
