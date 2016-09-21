// Excel Sheet Column Title
public class Solution {
    public String convertToTitle(int n) {
        String title = "";
        while(n > 0){
            int remainder = (n-1) % 26;
            title = (char)('A' + remainder) + title;
            n = (n - 1) / 26;
        }
        return title;
    }
}
