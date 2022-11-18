class Solution {
    public boolean queryString(String s, int n) {
        for(int i=n;i>n/2;i--){
            String check = Integer.toBinaryString(i);
            if(!s.contains(check)){
                return false;
            }
        }
        return true;
    }
}
// 0110