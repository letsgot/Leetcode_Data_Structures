//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(left(arr,x,0,n-1));
        list.add(right(arr,x,0,n-1));
        
        return list;
    }
    
    public int right(int [] arr,int tar,int lo,int hi){
        if(lo>hi){
            return -1;
        }
        
        int mid = lo + (hi-lo)/2;
        
        if(arr[mid]==tar){
            if(mid==arr.length-1||arr[mid+1]!=tar){
                return mid; 
            }
            else{
                 return right(arr,tar,mid+1,hi);
            }
        }
        else if(arr[mid]<tar){
            return right(arr,tar,mid+1,hi);
        }
        else{
            return right(arr,tar,lo,mid-1);
        }
    }
    
    
    public int left(int [] arr,int tar,int lo,int hi){
        if(lo>hi){
            return -1;
        }
        int mid = lo + (hi-lo)/2;
        
        if(arr[mid]==tar){
            if(mid==0||arr[mid-1]!=tar){
                return mid; 
            }
            else{
                 return left(arr,tar,lo,mid-1);
            }
        }
        else if(arr[mid]<tar){
            return left(arr,tar,mid+1,hi);
        }
        else{
            return left(arr,tar,lo,mid-1);
        }
    }
    
    
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends