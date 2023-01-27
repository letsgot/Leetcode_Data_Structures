class Solution {
    public class Node{
        boolean eow;
        Node[]children;
        Node(){
            children = new Node[26];
        }
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Node root = new Node();
        
        for(String word : words){
            if(word.length()<=0){
                continue;
            }
            Node t = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(t.children[ch-'a']==null){
                    t.children[ch-'a'] = new Node();
                }
                t = t.children[ch-'a'];
            }
            t.eow = true;
        }
        
        List<String> list = new ArrayList<>();
        for(String word : words){
            boolean hans = helper(root,word,0,0);
            // System.out.println(word + "  " + hans);
            if(hans){
                list.add(word);
            }
        }
        
        return list;
    }
    
    public boolean helper(Node root,String str,int idx,int count){
        
        Node t = root;
        
        for(int i=idx;i<str.length();i++){
            char ch = str.charAt(i);
            if(t.children[ch-'a']==null){
                return false;
            }
            t = t.children[ch-'a'];
            if(t.eow==true&&helper(root,str,i+1,count+1)){
                    return true;
            }
        }
        
        return t.eow&&count>=1;
        
    }
}