import java.util.*;

class a1 {

    static final long MOD = 1000000007;

    public int countAnagrams(String s) {

        String[] words = s.split(" ");

        long ans = 1;

        for (String word : words) {

            ans = (ans * perm(word)) % MOD;

        }

        return (int) ans;
    }

    long perm(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count character frequency
        for (char c : s.toCharArray()) {

            map.put(c, map.getOrDefault(c, 0) + 1);

        }

        // Numerator: length!
        long num = fact(s.length());

        // Denominator: frequency factorials
        long den = 1;

        for (int count : map.values()) {

            den = (den * fact(count)) % MOD;

        }

        // Calculate permutations
        return (num * power(den, MOD - 2)) % MOD;
    }

    // Factorial
    long fact(int n) {

        long res = 1;

        for (int i = 1; i <= n; i++) {

            res = (res * i) % MOD;

        }

        return res;
    }

    // Modular inverse using binary exponentiation
    long power(long a, long b) {

        long res = 1;

        while (b > 0) {

            if (b % 2 == 1) {
                res = (res * a) % MOD;
            }

            a = (a * a) % MOD;

            b = b / 2;
        }

        return res;
    }
}