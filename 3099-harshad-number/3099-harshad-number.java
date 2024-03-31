class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int val = x;
        while(x>0){
            sum += x % 10;
            x = x / 10;
        }
        return (val % sum) == 0 ? sum : -1;
    }
}