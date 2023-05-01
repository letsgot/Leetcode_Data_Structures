class Solution {
    public double average(int[] salary) {
        double total = 0.0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int sal : salary){
            min = Math.min(sal,min);
            max = Math.max(max,sal);
            total += sal;
        }
        
        // System.out.println(total + " " + max + " " +min);
        
        total -= max*1.0;
        total -= min*1.0;
        
        // System.out.println(total + " " + max + " " +min);
        
        return total*1.00000/(salary.length-2);
    }
}