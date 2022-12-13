class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int arr[][] = new int[matrix.length][matrix[0].length];
       for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
               if(i==0){
                   arr[i][j] = matrix[i][j];
                   continue;
               }
               
              int min = Integer.MAX_VALUE;
               if(j-1>=0&&i-1>=0){
                   min = Math.min(min,arr[i-1][j-1]);
               }
               
               if(i-1>=0){
                   min = Math.min(min,arr[i-1][j]);
               }
               
               if(j+1<matrix[0].length&&i-1>=0){
                   min = Math.min(min,arr[i-1][j+1]);
               }
               
               // System.out.println(min);
               arr[i][j] = min + matrix[i][j];
           }
       }
        
         int min = Integer.MAX_VALUE;
        
           for(int j=0;j<matrix[0].length;j++){
              min = Math.min(min,arr[matrix.length-1][j]);
           }
        return min;
    }
}