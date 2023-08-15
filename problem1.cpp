// Time Complexity : O(n^log(n) * log(n))
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// idea is to only use the numbers that are possible to get valid numbers after using.
// we try all options and use digit dp technique

class Solution {
public:
    unordered_map<char,char>map;
    int confusingNumberII(int n) {
        string s = to_string(n);
        int count = 0;
        
        map.insert({'0','0'});
        map.insert({'1','1'});
        map.insert({'6','9'});
        map.insert({'8','8'});
        map.insert({'9','6'});
        
        int p = s.size();
        for(int i = 1;i<=p;i++)
        {
            string temp1;
            count+= solve(s,0,i,temp1,p==i);
        }
        
        return count;
        
    }
    int solve(string &s,int idx, int sz,string &temp1,bool tight)
    {
        if(idx == sz){
            if(isValid(temp1)){
                //cout<< " temp1 "<< temp1<< endl;
                return 1;
            } 
            return 0;
        } 
        
        char hi = tight? s[idx]: '9';
        
        int count = 0;
        for(auto &p: map)
        {
            if(p.first<=hi){
                temp1.push_back((char)p.first);
                count+= solve(s,idx+1,sz,temp1,tight&(p.first==hi));
                temp1.pop_back();
            }
        }
        
        return count;
        
    }
    bool isValid(string &s)
    {
        if(s[0] == '0' && s.size()>1) return false;
        string p = s;
        reverse(p.begin(),p.end());
        
        for(int i = 0;i<p.size();i++)
        {
            if(map.find(p[i])!=map.end())
            {
                p[i] = map[p[i]];
            }
        }
        
        if(s==p) return false;
        return true;
    }

};