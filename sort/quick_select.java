// find kth smallest element in the array
public int quickS(int k, int[] nums, int start, int end) {
    int lo = start;
    int hi = end;
    int pivotal = nums[end];
    while (lo < hi) {
        if (nums[lo] > pivotal) {
            swap(nums, lo, --hi);
        }
        else lo++;
    }
    swap(nums, lo, end);
    int cur = lo - start + 1;
    if (cur == k) return nums[lo];
    else if (cur > k) return quickS(k, nums, start, lo - 1);
    else return quickS(k - cur, nums, lo + 1, end);
}
    
public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
