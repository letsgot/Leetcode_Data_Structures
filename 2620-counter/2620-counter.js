/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    let x = n;
    return function() {
        if(x==n){
            let c = x;
            x++;
            return c;
        }
        else{
            return x++;
        }
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */