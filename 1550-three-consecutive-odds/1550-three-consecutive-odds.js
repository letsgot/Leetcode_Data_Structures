/**
 * @param {number[]} arr
 * @return {boolean}
 */
var threeConsecutiveOdds = function(arr) {
    let c = 0;
    for(let i=0;i<arr.length;i++){
       if(arr[i]%2!=0){
           c++;
       }
        else{
            c = 0;
        }
        if(c==3){
            return true;
        }
    }
    return false;
};