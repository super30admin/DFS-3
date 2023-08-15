// Time Complexity : O(np4)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
public:
    using ll = long long;
    
    bool makesquare(vector<int>& matchsticks) {
         
        ll sum = 0;
        for(int num: matchsticks) sum+=num;
        
        if(sum%4!=0) return false;
        
        sort(matchsticks.begin(),matchsticks.end(),greater<int>()); 
        
        return solve(matchsticks,0,0,0,0,0,sum/4);
    }
    bool solve(vector<int>& matchsticks,int idx, ll A,ll B, ll C, ll D, ll side)
    {
        if(idx==matchsticks.size()){
            if(A!=0 && A==B && B==C && C==D && D==side){
                return true;
            }
            return false;
        }
        bool a = false, b = false, c = false, d = false;
        if(A + matchsticks[idx]<=side)
            a = solve(matchsticks,idx+1,A + matchsticks[idx],B,C,D,side);
        if(B + matchsticks[idx]<=side)
            b = solve(matchsticks,idx+1,A,B + matchsticks[idx],C,D,side);
        if(C + matchsticks[idx]<=side)
            c = solve(matchsticks,idx+1,A,B,C + matchsticks[idx],D,side);
        if(D + matchsticks[idx]<=side)
            d =  solve(matchsticks,idx+1,A,B,C,D + matchsticks[idx],side);
        
        
        return a|b|c|d;
    }
};