// Matchsticks to Square
// Time Complexity: O(n * 4^n), where n is the number of matchsticks.
// Space Complexity: O(n), where n is the number of matchsticks.
// Did this code pass all test cases? Yes, it passed all test cases.

// Approach:
// 1. We will first calculate the total length of all matchsticks.
// 2. If the total length is not divisible by 4, we cannot form a square, so we return false.
// 3. We will sort the matchsticks in descending order to optimize the search.
// 4. We will use a depth-first search (DFS) approach to try to form the four sides of the square.
// 5. We will maintain an array to keep track of the current lengths of the four sides.
// 6. For each matchstick, we will try to place it on one of the four sides and check if we can form a square.
// 7. If we reach the end of the matchsticks and all sides are equal to the target length, we return true.
// 8. If we cannot form a square, we backtrack and try the next possibility.

#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        int sum = 0; 
        for(int num: matchsticks){
            sum += num;
        }
        if(sum % 4 != 0){
            return false;
        }
        sort(matchsticks.rbegin(), matchsticks.rend());
        vector<int> sums(4);
        return dfs(matchsticks, sums, 0, sum/4);
    }
private: 
    bool dfs(vector<int>& matchsticks, vector<int>& sums, int index, int target) {
        if(index == matchsticks.size()){
            if(sums[0] == target && sums[1] == target && sums[2] == target){
                return true;
            }
            return false;
        }
        for(int i = 0; i < 4; i++){
            if(sums[i] + matchsticks[index] > target){continue;}
            sums[i] += matchsticks[index];
            if(dfs(matchsticks, sums, index + 1, target)){
                return true;
            }
            sums[i] -= matchsticks[index];
        }
        return false;
    }
};