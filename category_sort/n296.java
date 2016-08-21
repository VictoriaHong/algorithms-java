// s: O(m + n) t: O(mn)
public int minTotalDistance(int[][] grid) {
	int n = grid.length;
	if (n == 0) return 0;
	int m = grid[0].length;
	if (m == 0) return 0;
    int[] col = new int[n];
    int[] row = new int[m];
    for (int i = 0; i < n; i++) {
    	for (int j = 0; j < m; j++) {
    		row[j] += grid[i][j];
    		col[i] += grid[i][j];
    	}        	
    }
    return minTotalDistance(row) + minTotalDistance(col);
    
}

private int minTotalDistance(int[] nums) {
	int sum = 0;
	int count = 0;
	for (int i = 0; i < nums.length; i++) {
		sum += (i + 1) * nums[i];
		count += nums[i];
	}
	int leftCount = 0;
	int rightCount = count;
	int min = sum;
	for (int i = 0; i < nums.length; i++) {
		sum = sum - rightCount + leftCount;
		if (sum < min) min = sum;
		leftCount += nums[i];
		rightCount -= nums[i];
	}
	return min;
}

// https://discuss.leetcode.com/topic/47184/java-2ms-o-mn-solution-based-on-1-dimension-problem
