// Add Digits
public class Solution {
    public int addDigits(int num) {
        /*if num==0, return 0. if num divides 9 evenly, return 9, otherwise return num%9.*/
        return num==0? 0:(num%9==0? 9:num%9);
        /* 0 1 2 3 4 5 6 7 8 9
           1 2 3 4 5 6 7 8 9 1
           2 3 4 5 6 7 8 9 1 2
           3 4 5 6 7 8 9 1 2 3
           ....
        Note the cycle of size 9 that consists 1...9
       */
    }
}
