// Add Binary
public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) return "";
        char[] ca;
        char[] cb;
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        ca = a.toCharArray();
        cb = b.toCharArray();
        
        int ia = ca.length - 1;
        int ib = cb.length - 1;
        int cura = 0;
        int curb = 0;
        int carry = 0;
        int sum = 0;
        String res = "";
        while (ia >= 0) {
            cura = ca[ia--] - '0';
            if (ib >= 0) curb = cb[ib--] - '0';
            else curb = 0;
            sum = cura + curb + carry;
            
            if (sum > 2) {
                res = "1" + res;
                carry = 1;
            }
            else if (sum == 2) {
                res = "0" + res;
                carry = 1;
            }
            else if (sum == 1) {
                res = "1" + res;
                carry = 0;
            }
            else {
                res = "0" + res;
            }
        }
        return carry == 1? "1" + res : res;
    }
}
