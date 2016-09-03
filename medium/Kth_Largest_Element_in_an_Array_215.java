// Kth Largest Element in an Array
// pq t: O(nlgk)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for (Integer i : nums) {
            if (pq.size() < k) pq.offer(i);
            else {
                if (pq.peek() < i) {
                    pq.poll();
                    pq.offer(i);
                }
            }
        }
        return pq.peek();
    }
}

// quick-select avr O(n)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) return 0;
        return nums[quickSelection(nums, 0, nums.length - 1, nums.length - k + 1)];
    }
    
    public int quickSelection(int[] nums, int lo, int hi, int k) {
        int i = lo;
        int j = hi;
        int pivotal = nums[hi];
        while (i < j) {
            if (nums[i] > pivotal) {
                swap(nums, i, --j);
            }
            else i++;
        }
        swap(nums, i, hi);
        
        int cur = i - lo + 1;
        if (cur == k) return i;
        else if (cur > k) return quickSelection(nums, lo, i - 1, k);
        else return quickSelection(nums, i + 1, hi, k - cur);
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
