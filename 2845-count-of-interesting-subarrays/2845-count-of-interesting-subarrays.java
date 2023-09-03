class Solution {
    public long countInterestingSubarrays(List<Integer> A, int mod, int k) {
     
         long res = 0;
        int acc = 0;
        HashMap<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        for (int a : A) {
            acc = (acc + (a % mod == k ? 1 : 0)) % mod;
            res += map.getOrDefault((acc - k + mod) % mod, 0);
            map.put(acc, map.getOrDefault(acc, 0) + 1);
        }
        return res;

    }
}
