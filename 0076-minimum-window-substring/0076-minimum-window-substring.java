class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }

        HashMap<Character,Integer> tmap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tmap.put(ch,tmap.getOrDefault(ch,0) + 1);
        } 

        int mmc = t.length();
        int i = 0;
        int j = -1;

        String ans = "";
        HashMap<Character,Integer> smap = new HashMap<>();

        while(true){
            // accquire 
            while(mmc>0 && i<s.length()){
               char ch = s.charAt(i);

               smap.put(ch,smap.getOrDefault(ch,0)+1);
               
               if(smap.getOrDefault(ch,0) <= tmap.getOrDefault(ch,0)){
                  mmc--;
               }
               
               i++;
            }

            
            // release 
            while(mmc==0 && j<i){
               String pans = s.substring(j+1,i);

               if(ans.length()==0){
                  ans = pans;
               }
               else if(pans.length()<ans.length()){
                  ans = pans;
               }

               j++;

               char ch = s.charAt(j);

               smap.put(ch,smap.getOrDefault(ch,0)-1);

               if(smap.getOrDefault(ch,0)<tmap.getOrDefault(ch,0)){
                mmc++;
               }


            }

            if(i==s.length()){
                break;
            }
        }


        return ans;

    }
}