public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> array = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                array.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                array.add("Fizz");
            }
            else if (i % 5 == 0) {
                array.add("Buzz");
            } else {
                array.add(Integer.toString(i));
            }
        }
        return array;
    }
}
