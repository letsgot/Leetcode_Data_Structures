class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String arr[] = s.split(" ");
        
        StringBuilder sb = new StringBuilder("");
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==""){
                continue;
            }
            String str = arr[i].trim();
            sb.append(str);
            if(i!=0)
            sb.append(" ");
        }
        
        return sb.toString();
    }
}