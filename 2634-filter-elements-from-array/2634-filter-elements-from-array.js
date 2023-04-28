/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let ans = [];
    for(let i=0;i<arr.length;i++){
        let check = fn(arr[i],i);
        if(check){
            ans.push(arr[i]);
        }
    }
    return ans;
};