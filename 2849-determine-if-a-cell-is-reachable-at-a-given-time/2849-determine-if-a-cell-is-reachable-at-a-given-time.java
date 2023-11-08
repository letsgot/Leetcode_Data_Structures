class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        
        // return helper(sx,sy,fx,fy,t);
         if(sx==fx&&sy==fy&&t==0){
            return true;
        }
        if(sx==fx&&sy==fy){
            if(t==1){
                return false;
            }
            else{
                return true;
            }
        }
        else if(t==0&&(sx!=fx||sy!=fy)){
            return false;
        }
        
        
        int x = Math.abs(sx-fx);
        int y = Math.abs(fy-sy);
        
        int total = Math.abs(x-y);
        
        int min = Math.min(x,y);
        
        int max = Math.max(x,y);
        
        int count = min + (max-min);
        
        if(t<count){
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean helper(int sx,int sy,int fx,int fy,int t){
        if(sx==fx&&sy==fy&&t==0){
            return true;
        }
        else if(t==0&&(sx!=fx||sy!=fy)){
            return false;
        }
        
        
        boolean c1 = helper(sx+1,sy,fx,fy,t-1);
        boolean c2 =helper(sx-1,sy,fx,fy,t-1);
        boolean c3 =helper(sx-1,sy+1,fx,fy,t-1);
        boolean c4 =helper(sx-1,sy-1,fx,fy,t-1);
        boolean c5 =helper(sx+1,sy+1,fx,fy,t-1);
       boolean c6 = helper(sx+1,sy-1,fx,fy,t-1);
        boolean c7 =helper(sx,sy-1,fx,fy,t-1);
        boolean c8 =helper(sx,sy+1,fx,fy,t-1);
        
        if(c1||c2||c3||c4||c5||c6||c7||c8){
            return true;
        }
        
        return false;
    }
}