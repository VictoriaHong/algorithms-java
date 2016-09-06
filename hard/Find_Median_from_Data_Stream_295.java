// Find Median from Data Stream
public class MedianFinder {
    PriorityQueue<Long> small = new PriorityQueue<>(); // fake max heap
    PriorityQueue<Long> large = new PriorityQueue<>(); // min heap
    // Adds a number into the data structure.
    public void addNum(int num) {
        large.offer((long)num);
        small.offer(-large.poll());
        if (large.size() < small.size()) {
            large.offer(-small.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek() - small.peek())/2.0;
    }
}
