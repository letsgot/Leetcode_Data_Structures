class WordDictionary {
    
    public class Node{
        boolean eow;
        Node [] children;
        Node(){
            children = new Node[26];
        }
    }
 
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    
    public boolean search(String word) {
        return helper(word,0,root);
    }
    
    public boolean helper(String word,int idx,Node node){
        if(idx==word.length()&&node.eow){
            return true;
        }
        else if(idx==word.length()){
            return false;
        }
        
        char ch = word.charAt(idx);
        if(ch=='.'){
            for(int i=0;i<26;i++){
                if(node.children[i]!=null){
                    boolean hans = helper(word,idx+1,node.children[i]);
                    if(hans){
                        return true;
                    }
                }
            }
        }
        else{
            if(node.children[ch-'a']==null){
                return false;
            }
            boolean hans = helper(word,idx+1,node.children[ch-'a']);
            if(hans){
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */