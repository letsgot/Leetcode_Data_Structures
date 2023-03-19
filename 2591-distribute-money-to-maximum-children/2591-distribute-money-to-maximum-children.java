class Solution {
    public int distMoney(int money, int children) {
        if(children>money){
            return -1;
        }
        int tm = money - children;
        int q = tm/7;
        int rem = tm%7;
        
        if(q==children&&rem==0){
            return children;
        }
        
        if(q==children-1&&rem==3){
            return children-2;
        }
        
        return Math.min(children-1,q);
        
      
    }
}


//  money -= children;
//     if (money < 0)
//         return -1;
//     if (money / 7 == children && money % 7 == 0)
//         return children;
//     if (money / 7 == children - 1 && money % 7 == 3)
//         return children - 2;
//     return min(children - 1, money / 7);