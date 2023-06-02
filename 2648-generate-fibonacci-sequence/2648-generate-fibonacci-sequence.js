/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    let a = 0;
    let b = 1;
    yield a;
    yield b;
    
    while(true){
        let c = a + b;
        yield c;
        a = b;
        b = c;
    }
    
    return a;
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */