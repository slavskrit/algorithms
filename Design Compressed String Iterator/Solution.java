// https://leetcode.com/problems/design-compressed-string-iterator
// 
// Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.
// 
// The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
// 
// next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
// hasNext() - Judge whether there is any letter needs to be uncompressed.
// 
// Note:
// Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.
// 
// Example:
// 
// StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
// 
// iterator.next(); // return 'L'
// iterator.next(); // return 'e'
// iterator.next(); // return 'e'
// iterator.next(); // return 't'
// iterator.next(); // return 'C'
// iterator.next(); // return 'o'
// iterator.next(); // return 'd'
// iterator.hasNext(); // return true
// iterator.next(); // return 'e'
// iterator.hasNext(); // return false
// iterator.next(); // return ' '
class StringIterator {

    char next;
    int cursor;
    int count;
    char[] array;

    public StringIterator(String compressedString) {
        this.next = ' ';
        this.cursor = 0;
        this.count = 0;
        this.array = compressedString.toCharArray();
    }

    public char next() {
        if (count == 0) {
            if (cursor >= array.length) return ' ';
            next = array[cursor++];
            while (cursor < array.length && Character.isDigit(array[cursor])) {
                count = count * 10 + (array[cursor++] - '0');
            }
        }
        count--;
        return next;
    }

    public boolean hasNext() {
        return cursor < this.array.length || count != 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
