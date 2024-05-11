class Solution {
    public boolean isPalindrome(int x) {
        String str = x + "";
        return isPalindromeRecursion(str,0,str.length()-1);
    }
    
    public boolean isPalindromeRecursion(String str,int st,int lt){
        if(st>=lt){
            return true;
        }
        
        char chs = str.charAt(st);
        char chl = str.charAt(lt);
        
        if(chs!=chl){
            return false;
        }
        
        return isPalindromeRecursion(str,st+1,lt-1);
    }
}