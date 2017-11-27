// https://leetcode.com/problems/moving-average-from-data-stream
// 
// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
// 
// For example,
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3
class MovingAverage {

    private Queue<Integer> queue;
    private double sum;
    int size;

    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.sum = 0;
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() >= size) {
            sum -= queue.poll();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
