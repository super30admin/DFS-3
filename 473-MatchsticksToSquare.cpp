/* 
    Time Complexity                              :  O(4^N)
    Space Complexity                             :  O(N)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

class Solution {
private: 
    vector<int> sides;
    int n;
public:
    bool makesquare(vector<int>& matchsticks) {
        n = matchsticks.size();
        sides.resize(4,0);
        int sum = getSum(matchsticks);
        if(sum%4 != 0) return false;
        int side = sum/4;
        sort(begin(matchsticks),end(matchsticks));
        reverse(begin(matchsticks),end(matchsticks));
        return backtracking(matchsticks, side, 0);
    }
    
    int getSum(vector<int>& matchsticks) {
        int sum = 0;
        for(auto stick : matchsticks) {
            sum += stick;
        }
        return sum;
    }
    
    bool backtracking(vector<int>& matchsticks,int side, int idx) {
        if(idx == n) {
            if(sides[0] == side and sides[1] == side and sides[2] == side) return true;
            return false;
        }
        
        for(int i=0;i<4;i++) {
            if(matchsticks[idx] + sides[i] <= side) {
                sides[i] += matchsticks[idx];
                if(backtracking(matchsticks, side, idx+1)) return true;
                sides[i] -= matchsticks[idx];
            }
        }
        return false;
        
    }
};