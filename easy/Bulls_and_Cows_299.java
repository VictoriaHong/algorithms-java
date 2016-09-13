// Bulls and Cows
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int size = secret.length();
        int[] hMap = new int[10];
        for(int i = 0; i < size; i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            } else {
                hMap[s]++;
            }
        }
        for(i = 0; i < size; i++) {
            int g = guess.charAt(i) - '0';
            int s = secret.charAt(i) - '0';
            if(g != s && hMap[g] > 0) {
                cows++;
                hMap[g]--;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}
