// 2 Hashsets s: O(N), t: O(lgN) 
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resset = new HashSet<Integer>();
        Set<Integer> num1set = new HashSet<Integer>();
        
        for (Integer i: nums1) {
            num1set.add(i);
        }
        
        for (Integer i: nums2) {
            if (num1set.contains(i)) resset.add(i);
        }
        
        int N = resset.size();
        int[] res = new int[N];
        int index = 0;
        for (Integer i: resset) {
            res[index++] = i;
        }
        return res;
    }
}

// bit method doesn't work for all negtive array
// 1 bitset s: O(N) for result + bitset t: O(N + N) + copy
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        int [] res = new int [Math.min(N1, N2)];
        BitSet bs = new BitSet();
        for (Integer i: nums1) bs.set(i);
        
        int count = 0;
        for (Integer i: nums2) {
            if (bs.get(i)){
                res[count++] = i;
                bs.set(i, false);
            }
        }
        
        return Arrays.copyOfRange(res, 0, count);
    }
}

// 2 bitsets s: O(N) for intersaction + 2 bitsets t: O(N + N) + copy
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        BitSet b1 = new BitSet();
        BitSet b2 = new BitSet();
        
        for (Integer i: nums1) b1.set(i);
        for (Integer i: nums2) b2.set(i);
        
        b2.and(b1);
        
        int[] res = new int[b2.cardinality()];
        int index = 0;
        for (int i = b2.nextSetBit(0); i >= 0; i = b2.nextSetBit(i+1)) {
          res[index++] = i;
        }
        
        return res;
    }
}
