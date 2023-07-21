//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        Node curr = node;
        
        int count = 1;
        
        Node start = node;
        
        Node ans = null;
        
        Node dummy = new Node(1);
        Node temp = dummy;
        
        while(curr!=null){
            if(count%k==0){
                Node next = curr.next;
                Node newL = reverse(start,curr);
                temp.next = newL;
                temp = start;
                // start.next = newL;
                start = next;
                curr = next;
                count++;
                continue;
            }
            
            curr = curr.next;
            count++;
        }
        
        Node nn = reverseSecond(start);
        temp.next = nn;
        
        return dummy.next;
    }
    
     public static Node reverseSecond(Node head) {
        if(head==null||head.next==null){
            return head;
        }
        
        Node curr = head;
        Node prev = null;
        
        while(curr!=null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
    
    
    public static Node reverse(Node head,Node end){
        Node prev = null;
        
        while(prev!=end){
            Node next = head.next;
            head.next = prev;
            prev = head;
            
            head = next;
        }
        
        return prev;
    }
}

