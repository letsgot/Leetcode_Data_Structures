class Solution {
    public void merge(int[] arr2, int m, int[] arr1, int n) {
         int ans[] = new int[n+m];
  int i = 0;
  int j = 0;
  int k = 0;
  while(i<n && j<m){
    if(arr1[i]<arr2[j]){
       ans[k] = arr1[i];
       i++;
    }
    else{
       ans[k] = arr2[j];
       j++;
    }
    k++;
  }
  
  while(i<n){
     ans[k] = arr1[i];
     i++;
     k++;
  }
  
  while(j<m){
     ans[k] = arr2[j];
     j++;
     k++;
  }
  
 int o = 0;
        for(int g:ans){
          arr2[o] = g;
            o++;
        }
        
  
    }
}