class Solution {
    
    public class Pair{
        int lvl;
        int val;
        int sum = 0;
        Pair(int lvl,int val,int sum){
            this.lvl = lvl;
            this.val = val;
            this.sum = sum;
        }
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(0,headID,informTime[headID]));
        // boolean [] arr = new boolean[manager.length];
        
        HashMap<Integer,ArrayList<Integer>> loop = new HashMap<>();
        for(int i=0;i<manager.length;i++){
            int val = manager[i];
            if(loop.containsKey(val)){
                loop.get(val).add(i);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                loop.put(val,list);
            }
        }
        
        while(que.size()>0){
            Pair rem = que.remove();
            int lvl = rem.lvl;
            int val = rem.val;
            int sum = rem.sum;
            
            if(map.containsKey(lvl)){
               int s = map.get(lvl);
                map.put(lvl,Math.max(sum,s));
            }
            else{
               map.put(lvl,sum);
            }
            
            // for(int i=0;i<manager.length;i++){
            //     // arr[i] = true;
            //     int m = manager[i];
            //     if(m==val){
            //         que.add(new Pair(lvl+1,i,sum+informTime[i]));
            //     }
            // }
            
            ArrayList<Integer> list = loop.get(val);
            if(list!=null){
                for(int i : list){
                     que.add(new Pair(lvl+1,i,sum+informTime[i]));
                }
            }
        }
        
        int max = 0;
        for(int i : map.keySet()){
           max = Math.max(max,map.get(i));
        }
        
        return max;
    }
}