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
    public ListNode[] splitListToParts(ListNode head, int k) {
       
        ListNode ans[] = new ListNode[k];
        if(head==null){
            return ans;
        }
        
        Arrays.fill(ans,null);
        
        
        int size = siz(head);
        int eachLength = size / k;
        int xtraLength = size % k;
        
        int index = 0;
        ListNode curr = head;
        while(curr!=null){
            int diff = xtraLength<=0?0:1;
            xtraLength--;
            
            ans[index++] = curr;
            for(int i=0;i<eachLength+diff-1;i++){
                curr = curr.next;
            }
            
            ListNode temp = curr.next;
            curr.next = null;
            curr = temp;
        }
        
        return ans;
        
    }
    
    
    public int siz(ListNode node){
        int co = 0;
        while(node!=null){
            co++;
            node = node.next;
        }
        return co;
    }
}

// class Solution {
//     public ListNode[] splitListToParts(ListNode root, int k) {
//         // prepare the results for each of the buckets upto k size
// 		ListNode[] result = new ListNode[k];
        
// 		// if root is null then return the empty array
//         if (root == null)
//             return result;
        
//         // find the total length of the list
//         int length = 0;
//         ListNode curr = root;
//         while (curr != null){
//             length++;
//             curr = curr.next;
//         }
        
//         //find the length of each bucket in k buckets 
// 		int eachLength = length / k;
//         //not every time we get equal size for all the buckets so sometimes some of the bucket will have extra elements in it
// 		//so we have to find the length of extra buckets by mod operation
//        	int extraLength = length % k;
        
// 		int index = 0;
//         curr = root;
//         //loop for all the elements in the list
//         while (curr != null){
//             //for every bucket we start with the current element
// 			ListNode head = curr;
            
//             //each part difference is either 0 or 1, we use the reminder to identify the difference
//             int difference = extraLength <= 0 ? 0 : 1;
            
//             //move the pointer to the size of eachlength
//             for(int i=0;i< eachLength + difference - 1;i++)
//                 curr = curr.next;
            
//             //set the next to null
//             ListNode temp = curr.next;
//             curr.next = null;
//             curr = temp;
            
//             //add to the result array
//             result[index++] = head;
            
//             //decrement the extra length
//             extraLength--;
//         }       
//         return result;
//     }
// }