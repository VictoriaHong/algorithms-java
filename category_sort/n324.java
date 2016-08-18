// quick select t: O(n) virtual index s: O(1)
public class Solution {
    public void wiggleSort(int[] nums) {
        int median=findKthLargest(nums,(nums.length+1)/2 - 1);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                exchange(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                exchange(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }
    
    public int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    public int findKthLargest(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else return nums[j];
        }
        return nums[k];
    }
    
    public int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo;
        int j = hi + 1;
        
        while (true) {
            while (nums[++i] < v) {
                if (i == hi) break;
            }
            while (nums[--j] > v) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exchange(nums, i, j);
        }
        exchange(nums, lo, j);
        return j;
    }
    
    public void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/**
Reference:
https://www.wikiwand.com/en/Quickselect#
https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java
https://discuss.leetcode.com/topic/32861/3-lines-python-with-explanation-proof
https://discuss.leetcode.com/topic/32929/o-n-o-1-after-median-virtual-indexing
**/
