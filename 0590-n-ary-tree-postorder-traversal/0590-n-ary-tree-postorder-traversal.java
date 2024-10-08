/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> list;
    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        helper(root);
        return list;
    }
    
    public void helper(Node root){
        if(root==null){
            return;
        }
        
        for(int i=0;i<root.children.size();i++){
           helper(root.children.get(i));  
        }
        
        list.add(root.val);
    }
}