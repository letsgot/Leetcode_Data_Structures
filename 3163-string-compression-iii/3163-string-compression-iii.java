class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int n = word.length();
        for(int i=0;i<n;)
        {
            char c = word.charAt(i);
            int data = 0;
            while(i < n && word.charAt(i) == c && data < 9)
            {
                data++;
                i++;
            }
            ans.append(data).append(c);
        }
        return ans.toString();
    }
}