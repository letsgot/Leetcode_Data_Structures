class Solution {
    HashMap<String,String> par ;
    HashMap<String,Double> mult;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        par = new HashMap<>();
        mult = new HashMap<>();
        
        for(List<String> eqn : equations){
            addToMap(eqn.get(0));
            addToMap(eqn.get(1));
        }
        
        int i = 0;
        for(List<String> eqn : equations){
            String lead0 = find(eqn.get(0));
            String lead1 = find(eqn.get(1));
            
            Double m0 = mult.get(eqn.get(0));
            Double m1 = mult.get(eqn.get(1));
            
            mult.put(lead0,m1*values[i]/m0);
            par.put(lead0,lead1);
            
            i++;
        }
        
        double[]res = new double[queries.size()];
        i = 0;
        for(List<String> eqn : queries){
            if(par.containsKey(eqn.get(0))==false||par.containsKey(eqn.get(1))==false){
              res[i] = -1;
              i++;
                continue;
            }
            
            String l0 = find(eqn.get(0));
            String l1 = find(eqn.get(1));
            
            if(l0.equals(l1) == false){
                res[i] = -1;
                i++;
                continue;
            } 
            
            Double m0 = mult.get(eqn.get(0));
            Double m1 = mult.get(eqn.get(1));
            res[i] = m0 / m1;
            
        
            i++;
        }
        return res;
    }
    
    public String find(String x){
        if(par.get(x).equals(x)){
            return x;
        }
        else{
            String cp = par.get(x);
            String np = find(cp);
            
            par.put(x,np);
            mult.put(x,mult.get(cp)*mult.get(x));
            return np;
        }
    }
    
    public void addToMap(String x){
        if(par.containsKey(x)==false){
            par.put(x,x);
            mult.put(x,1.0);
        }
    }
}