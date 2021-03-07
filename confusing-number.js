//Time, Space - O(exp), O(1)

/**
 * @param {number} N
 * @return {number}
 */

let map;
let count = 0;
var confusingNumberII = function(N) {
    map = {
        0: 0,
        1: 1,
        6: 9,
        8: 8,
        9: 6
    }
    
    dfs(N, 0);
    
    return count;
};

var dfs = function(N, current) {
    
    if(isValid(current)) {
        count++;
    }
    
    for(let num of Object.keys(map)) {
        let next = parseInt(current * 10 + parseInt(num));
        if(next <= N && (next !== 0)) {
            dfs(N, next);
        }
    }
    
}

var isValid = function(num) {
    let original = parseInt(num);
    let result = 0;
    while(num > 0) {
        result = result * 10 + map[num % 10];
        num = Math.floor(num / 10);
    }
    
    return result !== original;
    
}
