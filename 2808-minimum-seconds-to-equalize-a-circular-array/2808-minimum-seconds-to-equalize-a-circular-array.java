class Solution {
    public int minimumSeconds(List<Integer> nums) {
         int n = nums.size(), ans = n;
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            indices.computeIfAbsent(nums.get(i), l -> new ArrayList<>()).add(i);    
        }
        for (var l : indices.values()) {
            l.add(l.get(0) + n);
            int longest = 0;
            for (int i = 1; i < l.size(); ++i) {
                longest = Math.max(longest, (l.get(i) - l.get(i - 1)));
            }
            ans = Math.min(ans, longest / 2);
        }
        return ans;
    }
}