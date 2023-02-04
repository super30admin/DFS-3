// Time complexity: exponential
// Space complexity: O(n)
// Did this code successfully run on Leetcode : No, time limit exceeded

/*
Idea is to distribute the matchsticks along the 4 sides to get the side length 

Need to explore the entire search space since greedy is not going to work - we can pick the smallest or the largest but we might use up some number that is needed for some other side 

To explore all the possibilities, add each index of the matchsticks to each side and call the recurse function on it - this will spawn more branches and will explore all the possibilities 

We need to backtrack because that might not be used in that side too, so in the backtrack part, subtract the length we added 
*/

class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        if(matchsticks.size() < 4)
            return false;
        int sum = 0;
        for(int len: matchsticks) {
            sum += len;
        }
        if(sum%4 != 0)
            return false;
        
        sort(matchsticks.begin(), matchsticks.end(), greater<int>());

        // length of each side of the square
        int len = sum/4;
        cout<<len;
        return backtrack(matchsticks, len, 0, vector<int>(4,0));
    }
private:
    bool backtrack(vector<int>& matchsticks, int side, int index, vector<int> square) {
        // base
        // all the matchsticks are used up, and the sides are all equal
        if(index == matchsticks.size()) {
            if(square[0] == square[1] && square[1] == square[2] && square[2] == square[3])
                return true;
            else
                return false;
        }

        // logic

        //Add the current index to each side of the square - and call recurse on it 
        // If the fucntion returns true - then return true 

        // Esle, that means that wasn't the answer - so subtract the number and continue the recurse fucntion 
        for(int i = 0; i<4; i++) {
            if(square[i] + matchsticks[index] <= side) {
                square[i] += matchsticks[index];
                if(backtrack(matchsticks, side, index+1, square))
                    return true;
                // backtrack
                square[i] -= matchsticks[index];
            }
        }
        return false;
    }
};