class Solution {
   int[] dsu;
public int minScore(int n, int[][] roads) {
    dsu = new int[n+1];
    int[] ans = new int[n+1];
    for(int i = 0; i <= n; i++) dsu[i] = i;
    Arrays.fill(ans, Integer.MAX_VALUE);
    for(int[] r : roads){
        int a = find(r[0]), b = find(r[1]);
        dsu[a] = dsu[b];
        ans[a] = ans[b] = Math.min(r[2],Math.min(ans[a],ans[b]));
    }
    return ans[find(1)];
}
int find(int i){
    return dsu[i]==i ? i : (dsu[i] = find(dsu[i]));
}
}