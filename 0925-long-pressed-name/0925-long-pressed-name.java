class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length()>typed.length()){
            return false;
        }
        
        
        int i = 0;
        int j = 0;
        while(j<name.length()&&i<typed.length()){
            char chj = name.charAt(j);
            int qj = 1;
            while(j+1<name.length()&&name.charAt(j)==name.charAt(j+1)){
                j++;
                qj++;
            }
            
            char chi = typed.charAt(i);
            int qi = 1;
            while(i+1<typed.length()&&typed.charAt(i)==typed.charAt(i+1)){
                i++;
                qi++;
            }
            
            if(chi!=chj||qj>qi){
                return false;
            }
            
            // System.out.println(chj + " " + qj + " " + chi + " " + qi);
            
            
            i++;
            j++;
            
        }
        
        
        
        
        if(i<typed.length()||j<name.length()){
            return false;
        }
        
        return true;
    }
}