class Solution {
    public int[] findArray(int[] pref) {
        for(int i=pref.length-1;i>=1;i--){
            pref[i] = pref[i] ^ pref[i-1];
        }
        return pref;
    }
}