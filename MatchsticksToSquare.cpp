// Time Complexity - O(4^n)
// Space Complexity - O(1)
// It runs on Leetcode!

class Solution {
    public:
    bool backtrack(vector<int>& matchsticks, int index, vector<int>& mySquare, int& side){
        // base
        if(mySquare[0] == side && mySquare[1] == side && mySquare[2] == side)
            return true;
        
        if(index >= matchsticks.size())
            return false;
        
        // logic
        for(int i = 0; i < 4; i++){
            if(mySquare[i] + matchsticks[index] <= side){
                mySquare[i] += matchsticks[index];
                
                if(backtrack(matchsticks, index+1, mySquare, side))
                    return true;
                
                mySquare[i] -= matchsticks[index];
            }
        }
        return false;
    }
public:
    bool makesquare(vector<int>& matchsticks) {
        int sum = 0;
        for(int match : matchsticks)
            sum += match;
        
        if(sum%4)
            return false;
        
        int probableSide = sum/4;
        
        vector<int> mySquare(4);
        // Starting your recursion from the last element on the sorted matchsticks vector greatly reduces number of nodes in the recursion tree, thus saving you from TLE.
        sort(matchsticks.begin(), matchsticks.end());
        reverse(matchsticks.begin(), matchsticks.end());
        return backtrack(matchsticks, 0, mySquare, probableSide);
    }
};