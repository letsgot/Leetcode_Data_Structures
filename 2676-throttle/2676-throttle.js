/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var throttle = function(fn, t) {
    let cache = null;
    let lock = null;
    const call = function() {
        if(cache){
            fn(...cache);
            cache = null;
            setTimeout(() => call(), t);
        }else{
            lock = null;
        }
    }
    return function(...args) {
        if(!lock){
            fn(...args);
            lock = 1;
            setTimeout(() => call(), t);
        }else{
            cache = args;
        }
    }
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */