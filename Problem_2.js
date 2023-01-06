// Matchsticks to Square (https://leetcode.com/problems/matchsticks-to-square/)

// TC: O(4^N)
// SC: O(N)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// TC: 4^N
// SC: N

let sums, possibleSumSide;
/**
 * @param {number[]} matchsticks
 * @return {boolean}
 */
var makesquare = function (matchsticks) {
    if (matchsticks === null || matchsticks.length === 0)
        return false;

    let perimeter = matchsticks.reduce((partialSum, a) => partialSum + a, 0)
    possibleSumSide = perimeter / 4;

    if (perimeter % 4 !== 0)
        return false

    matchsticks.sort((a, b) => a - b)
    matchsticks = matchsticks.reverse()

    sums = new Array(4);
    sums.fill(0);

    return dfs(matchsticks, 0);
};
var dfs = (matchsticks, idx) => {
    // Base
    if (idx === matchsticks.length) {
        return sums[0] === sums[1] && sums[1] === sums[2] && sums[2] === sums[3];
    }

    // Logic
    let ele = matchsticks[idx];
    for (let i = 0; i < 4; i++) {
        if (sums[i] + ele <= possibleSumSide) {
            sums[i] += ele;
            if (dfs(matchsticks, idx + 1)) {
                return true;
            }
            sums[i] -= ele;
        }
    }
    return false;
}
