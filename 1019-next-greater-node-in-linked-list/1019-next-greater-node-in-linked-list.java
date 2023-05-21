/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if(head==null){
            return new int[0];
        }
        
        
        head = reverse(head);
        
        Stack<Integer> st = new Stack<>();
        // st.push(head.val);
        
        ArrayList<Integer> al = new ArrayList<>();
        
        while(head!=null){
            while(st.size()>0&&st.peek()!=null&&head.val>=st.peek()){
                st.pop();
            }
            
            if(st.size()==0){
                al.add(0);
            }
            else{
                 al.add(st.peek());
            }
            
            st.push(head.val);
            head = head.next;
            // i++;
        }
        
        int arr[] = new int[al.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = al.get(arr.length-i-1);
        }
        
        return arr;
        
    }
    
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}