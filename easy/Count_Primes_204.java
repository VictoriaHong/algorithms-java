// Count Primes
public class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime(i)) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) count++;
        }
        return count;
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

// https://leetcode.com/problems/count-primes/
