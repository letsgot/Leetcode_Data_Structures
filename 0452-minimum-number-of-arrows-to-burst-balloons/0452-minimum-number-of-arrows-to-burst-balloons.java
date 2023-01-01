class Solution {
    public int findMinArrowShots(int[][] points) {
      Arrays.sort(points,(a,b)->{
            if(a[0]==b[0]){
                if(a[1]==b[1]){
                    return 0;
                }
                else if(a[1]<b[1]){
                    return -1;
                }
                else{
                    return 1;
                }
            }
            else{
               if(a[0]==b[0]){
                    return 0;
                }
                else if(a[0]<b[0]){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });
        
        Stack<int[]> st = new Stack<>();
        
        st.push(points[0]);
        
        for(int i=1;i<points.length;i++){
            int[]point2 = points[i];
            int[]point1 = st.peek();
            
            if(point1[1]>=point2[0]){
                point1[1] = Math.min(point1[1],point2[1]);
            }
            else{
                st.push(point2);
            }
        }
        
        return st.size();
    }
}