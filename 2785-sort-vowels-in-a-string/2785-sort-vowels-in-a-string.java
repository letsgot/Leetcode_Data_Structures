class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        
        for(char ch : s.toCharArray()){
            if(ch=='A'||ch=='a'||ch=='e'||ch=='E'||ch=='I'||ch=='i'||ch=='O'||ch=='o'||ch=='U'||ch=='u'){
                pq.add(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        for(char ch : s.toCharArray()){
            if(ch=='A'||ch=='a'||ch=='e'||ch=='E'||ch=='I'||ch=='i'||ch=='O'||ch=='o'||ch=='U'||ch=='u'){
               sb.append(pq.remove());
            }
            else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
        
    }
}