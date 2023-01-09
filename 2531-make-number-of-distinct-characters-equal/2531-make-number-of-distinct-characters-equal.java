class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
		// store frequency of characters
        for (int i = 0; i < word1.length(); i++) map1[word1.charAt(i)-'a']++;
        for (int i = 0; i < word2.length(); i++) map2[word2.charAt(i)-'a']++;
		
		int count1 = 0, count2 = 0;
		// count no of distinct characters in each string
        for (int i = 0; i < 26; i++) {
            if (map1[i] > 0) count1++;
            if (map2[i] > 0) count2++;
        }
        
		// as explained in step 3
        if (count1 == count2 && word1.length() == word2.length()) return true;
        
        for (int i = 0; i < 26; i++) {
        	for (int j = 0; j < 26; j++) {
                if (map1[i] == 0 || map2[j] == 0 || i == j) continue;
                
                int tempCount1 = count1, tempCount2 = count2;
                
				// changing char count for map1
                if (map1[j] == 0) tempCount1++;
                if (map1[i] == 1) tempCount1--;
                
				// changing char count for map2
                if (map2[i] == 0) tempCount2++;
                if (map2[j] == 1) tempCount2--;
                
				// if count of unique chars are same, return true
                if (tempCount1 == tempCount2) return true;
            }
        }
        
        return false;
    }
}