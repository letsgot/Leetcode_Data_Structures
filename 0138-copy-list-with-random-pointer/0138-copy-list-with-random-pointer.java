/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        
        
        // making new list a->a`->b->b`->c->c` and soon
        Node prev = head;
        Node curr = head.next;
        while(prev!=null){
            Node next = null;
            if(curr!=null){
                next = curr.next;
            }
            
            Node nn = new Node(prev.val);
            prev.next = nn;
            nn.next = curr;
            
            prev = curr;
            curr = next;
        }
        
        
        // making random of connection 
        Node temp = head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        
        // extract the result ans list from list
        Node res = head.next;
        temp = head;
        while(temp.next!=null){
            Node next = temp.next;
            temp.next = temp.next.next;
            temp = next;
        }
        
        return res;
    }
}