class Solution {

    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> primes = new HashSet<>();
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            for (int p : primes) {
                if (i % p == 0) {
                    set.add(p);
                }
            }
        }
        return set.size();
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
