// Problem1: Number Confused(https://leetcode.com/problems/confusing-number-ii/)

// TC: O(kN) k is the average length of numbers
// SC: O(N)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

let valid, validMap, set;
/**
 * @param {number} n
 * @return {number}
 */
var confusingNumberII = function (n) {
    if (n === null || n === 0)
        return 0;
    valid = [0, 1, 9, 8, 6];
    validMap = new Map();
    validMap.set(0, 0)
    validMap.set(1, 1)
    validMap.set(9, 6)
    validMap.set(6, 9)
    validMap.set(8, 8)
    set = new Set();
    dfs(n, 0);
    return set.size;
};
var dfs = (n, num) => {
    // base
    // logic
    for (let i = 0; i < valid.length; i++) {
        let digit = valid[i];
        // Action
        num = num * 10 + digit
        // Recurse
        if (!set.has(num) && num >= 1 && num <= n && isConfusing(num)) {
            dfs(n, num)
        }
        // Backtrack
        num = Math.floor(num / 10);
    }
}
var isConfusing = (num) => {
    let original = num;
    let reverse = 0;
    while (original > 0) {
        let digit = original % 10;
        if (!validMap.has(digit)) {
            return false;
        }
        reverse = reverse * 10 + validMap.get(digit);
        original = Math.floor(original / 10)
    }
    if (num !== reverse) {
        set.add(num);
    }
    return true;
}