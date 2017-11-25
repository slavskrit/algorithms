// https://leetcode.com/problems/flatten-2d-vector
// 
// Implement an iterator to flatten a 2d vector.
// 
// For example,
// Given 2d vector =
// 
// [
//   [1,2],
//   [3],
//   [4,5,6]
// ]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
// 
// Follow up:
// As an added challenge, try to code it using only iterators in C++ or iterators in Java.
public class Vector2D implements Iterator<Integer> {

    private Iterator<List<Integer>> bigIterator;
    private Iterator<Integer> smallIterator;

    public Vector2D(List<List<Integer>> vec2d) {
        this.bigIterator = vec2d.iterator();
        if (!bigIterator.hasNext()) return;
        this.smallIterator = bigIterator.next().iterator();
        findIterator();
    }

    @Override
    public Integer next() {
        int toReturn = smallIterator.next();
        findIterator();
        return toReturn;
    }

    private void findIterator() {
        while (!smallIterator.hasNext() && bigIterator.hasNext() ) {
            smallIterator = bigIterator.next().iterator();
        }
    }

    @Override
    public boolean hasNext() {
        return smallIterator != null && smallIterator.hasNext();
    }

}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
