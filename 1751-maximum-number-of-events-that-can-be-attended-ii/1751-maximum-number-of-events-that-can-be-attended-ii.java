class Solution {
 public int maxValue(int[][] events, int k) {
	Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

	// <count + "_" + end, sum>
	Map<String, Integer> cache = new HashMap<>();

	return dfs(events, 0, 0, k, 0, cache);
}

private int dfs(int[][] events, int cur, int count, int k, int end, Map<String, Integer> cache) {
	if (count == k || cur == events.length) {
		return 0;
	}

	String key = count + "_" + end;
	Integer val = cache.get(key);
	if (val != null) {
		return val;
	}

	// skip
	int max = dfs(events, cur + 1, count, k, end, cache);
	if (events[cur][0] > end) {
		// take current
		max = Math.max(max, dfs(events, cur + 1, count + 1, k, events[cur][1], cache) + events[cur][2]);
	}

	cache.put(key, max);
	return max;
}
}