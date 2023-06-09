class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        
        if(target>=letters[n-1]){
            target = letters[0];
        }
        else {
            target++;
        }
        
        int lo = 0;
        int hi = n-1;
        
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(target==letters[mid]){
                return target;
            }
            else if(target<=letters[mid]){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        
        return letters[hi];
    }
}

//    int n = a.length;
       
//         if (x >= a[n - 1])   x = a[0];
//         else    x++;
        
//         int lo = 0, hi = n - 1;
//         while (lo < hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (a[mid] == x)    return a[mid];
//             if (a[mid] < x)     lo = mid + 1;
//             else    hi = mid;
//         }
//         return a[hi];