/* 
    Time Complexity                              :  O(5^x) Since for every position we have 5 options 
    Space Complexity                             :  It will depend on the max number of values generated 
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

/*
the bfs approach for confusing number took 173 Mb memory and average of 1550 ms time , the dfs approach took an average 950 ms and 6 MB space
*/

class Solution {
private:
    unordered_map<int,int> mp;
    int count = 0;
public:
    int confusingNumberII(int n) {
        mp[0] = 0; mp[1] = 1; mp[6] = 9; mp[8] = 8; mp[9] = 6;
        // dfs(0, n);
        bfs(n);
        return count;
    }
    
    void dfs(long cn, int n) {
        if(cn > n) return;
        
        if(isValid(cn)) {
            count++;
        }
        
        for(auto m : mp) {
            long newNumber = cn * 10 + m.first;
            if(newNumber != 0) {
                dfs(newNumber, n);
            }
        }
    }
    
    void bfs(long givenNumber) {
        queue<long> q;
        q.push(0);
        while(!q.empty()) {
            long currentNumber = q.front();q.pop();
            if(isValid(currentNumber)) count++;

            for(auto m : mp) {
                int currentDigit = m.first;
                long newNumber = currentNumber * 10 + currentDigit;
                if(newNumber != 0 and newNumber <= givenNumber) {
                    q.push(newNumber);
                }
            }
        }
    }
    
    bool isValid(long num) {
        
        long originalNumber = num;
        long rotatedNumber = 0;
        
        while(num > 0) {
            int currentDigit = num%10;
            int rotatedDigit = mp[currentDigit];
            num = num/10;
            rotatedNumber = rotatedNumber * 10 + rotatedDigit;
        }
        
        return rotatedNumber != originalNumber;
    }
    
    
};