class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex==0){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(1);
            return ans;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> helper = new ArrayList<>();
        for(int i=1;i<=rowIndex;i++){
            if(i==1){
                ans.add(1);
                ans.add(1);
                continue;
            }
            
            helper.add(1);
            
            for(int j=1;j<ans.size();j++){
                int sum = ans.get(j-1) + ans.get(j);
                helper.add(sum);
            }
            
            if(i!=1) helper.add(1);
                 
            ans = helper;

            
            helper = new ArrayList<>();
        }
        
        return ans;
    }
}