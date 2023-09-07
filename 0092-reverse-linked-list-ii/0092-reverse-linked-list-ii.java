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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        ListNode curr = head;
        
        boolean check = false;
        int i = 0;
        while(curr!=null){
            i++;
            if(i==left){
                check = true;
            }
            
            if(check){
                ans.add(curr.val);
            }
            
            if(i==right){
                check = false;
                break;
            }
            
            curr = curr.next;
        }
        
      
        curr = head;
        int idx = ans.size()-1;
        check = false;
        i = 0;
        while(curr!=null){
            i++;
            // int val = curr.val;
            if(i==left){
                check = true;
            }
            
            if(check){
                // System.out.println(curr.val + "  " + ans.get(idx));
                curr.val = ans.get(idx);
                idx--;
            }
            
            if(i==right){
                check = false;
                break;
            }
            
            curr = curr.next;
        }
        
        return head;
    }
}