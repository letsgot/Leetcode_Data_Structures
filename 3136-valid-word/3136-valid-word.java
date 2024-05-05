class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        
        int vowelCount = 0;
        int consonantCount = 0;
        
        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            
            if ("aeiouAEIOU".indexOf(c) != -1) {
                vowelCount++;
            } else if ((c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') && "aeiouAEIOU".indexOf(c) == -1) {
                consonantCount++;
            }
        }
        
        return vowelCount > 0 && consonantCount > 0;
    }
}