/**
Suppose there are N elements in the array, the min value is min and the max value is max. Then the maximum gap will be no smaller than ceiling[(max - min ) / (N - 1)].

Let gap = ceiling[(max - min ) / (N - 1)]. We divide all numbers in the array into n-1 buckets, where k-th bucket contains all numbers in [min + (k-1)gap, min + k*gap). We only need to store the largest number and the smallest number in each bucket.

After we put all the numbers into the buckets. We can scan the buckets sequentially and get the max gap.
1. if min==max, we can return 0 directly.
2. the length of bucketMin and bucketMax is n rather than n-1. So min,max can be put in bucket.
 **/

public class Solution {
    public int maximumGap(int[] nums) {
        if(nums==null || nums.length<2) return 0;
        
        // get the max and min value of the array     
        int min=nums[0];
        int max=nums[0];
        for(int n: nums){
            min=Math.min(min, n);
            max=Math.max(max, n);
        }
        if(min==max)
            return 0;
            
        int n=nums.length;
        
        // the minimum possibale gap, ceiling of the integer division
        int gap = (int)Math.ceil((double)(max-min)/(n-1));
        int bucketMin[] = new int[n];
        int bucketMax[] = new int[n];
        Arrays.fill(bucketMin, Integer.MAX_VALUE); // store the min value in that bucket
        Arrays.fill(bucketMax, Integer.MIN_VALUE); // store the max value in that bucket
        
        // put numbers into buckets
        for(int num: nums){
            int i=(num-min)/gap;
            bucketMin[i] = Math.min(bucketMin[i], num);
            bucketMax[i] = Math.max(bucketMax[i], num);
        }
        
        // scan the buckets for the max gap
        for(int i=0;i<bucketMin.length;++i){
            if(bucketMin[i]!=Integer.MAX_VALUE){
                // min value minus the previous value is the current gap
                gap = Math.max(gap, bucketMin[i]-min);
                min = bucketMax[i];
            }
        }
        
        return gap;
    }
}
