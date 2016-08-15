// hashmap s: O(N) t: O(N)
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> temp = new ArrayList<Integer>();
        
        for (Integer i: nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else map.put(i, 1);
        }
        
        for (Integer i: nums2) {
            if (map.containsKey(i)) {
                int num = map.get(i);
                if (num > 0) {
                    map.put(i, num - 1);
                    temp.add(i);
                }
            }
        }

        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++)
            res[i] = temp.get(i);
        return res;
    }
}

// same method in Java 8
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums1.length; i++) map.compute(nums1[i],(k,v)->v==null?1:v+1);
        for(int j=0; j<nums2.length; j++) map.computeIfPresent(nums2[j],(k,v)->{list.add(k); v--; return v==0?null:v;});
        return list.stream().mapToInt(i->i).toArray();
    }
}


// What if the given array is already sorted? How would you optimize your algorithm?
// 2 pointer s: O(N) N is size of intersection  t: O(m + n) + copy
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        int[] res = new int[Math.min(N1, N2)];
        int i = 0, j = 0, k = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(i < N1 && j < N2) {
            if(nums1[i] > nums2[j]) {
                j++;
            }
            else if(nums1[i] < nums2[j]) {
                i++;
            }
            else {
                res[k++] = nums1[i++];
                j++;
            }
        }
        
        return Arrays.copyOfRange(res, 0, k);
    }
}

// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// binary search large array?? How to deal with duplicates?


// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

// - If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

// - If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), sort them using external sort, read (let's say) 2G of each into memory and then using the 2 pointer technique, then read 2G more from the array that has been exhausted. Repeat this until no more data to read from disk.
// OR MAP-REDUCE TECH
