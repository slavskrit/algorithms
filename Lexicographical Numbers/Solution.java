// https://leetcode.com/problems/lexicographical-numbers
// 
// Given an integer n, return 1 - n in lexicographical order.
// 
// For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
// 
// Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>();
    int ten = 10;
    int value = 1;
    int cursor = 0;
    while (cursor++ < n) {
        result.add(value);
        if (value * ten <= n) {
            value *= ten;
        } else {
            if (value >= n) {
                value /= ten;
            }
            value++;
            while (value % ten == 0) {
                value /= ten;
            }
        }
    }
    return result;
}
