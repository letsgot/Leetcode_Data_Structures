class Solution {
    Integer mod = 1000000007;
    public int countHousePlacements(int n) {
        int sum = houseOnOneSide(n);
        sum = (int)(((long)sum*(long)sum)% (1000000000 +7));
        return sum;
    }
    
    public int houseOnOneSide(int n){
        if(n==0){
            return 0;
        }
        int oz = 1;
        int oo = 1;
        
        for(int i=2;i<=n;i++){
            int nz = (oz + oo) % mod;
            int no = oz;
            
            oz = nz;
            oo = no;
        }
        
        return (oz + oo) % mod;
    }
}