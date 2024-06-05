class Solution {
    public List<String> commonChars(String[] words) {
        int [] arr = new int[26];
        
        for(int i=0;i<words.length;i++){
            String word = words[i];
            
            if(i==0){
                for(char ch : word.toCharArray()){
                    arr[ch-'a']++;
                }
            }
            else{
                int narr[] = new int [26];
                for(char ch : word.toCharArray()){
                    narr[ch-'a']++;
                }
                
                for(int j=0;j<26;j++){
                    if(narr[j]>0 && arr[j] >0){
                        arr[j] = Math.min(narr[j],arr[j]);
                    }
                    else{
                        arr[j] = 0;
                    }
                    
                }
            }
        }
        
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                for(int j=0;j<arr[i];j++){
                     char ch = (char)('a' + i);
                list.add(ch+"");
                }
               
            }    
        }
        
        return list;
    }
}