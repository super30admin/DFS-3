// Approach 1 - Brute Force
// Time Complexity - O(n*k), where k is the average number of digits between 1 and 'n'.
// Space Complexity - O(1)
// Gives a TLE
class Solution {
    bool isConfusing(int num, set<int>& mySet){
        int newNum = 0;
        int temp;
        int n = num;
        while(num){
            int currDigit = num%10;
            if(mySet.count(currDigit))
                return false;
            
            if(currDigit == 9)
                temp = 6;
            else if(currDigit == 6)
                temp = 9;
            else
                temp = currDigit;
            
            newNum = newNum*10 + temp;
            
            num /= 10;
        }
        
        return (newNum == n) ? false : true;
    }
public:
    int confusingNumberII(int n) {
        set<int> mySet;
        mySet.insert(2);
        mySet.insert(3);
        mySet.insert(4);
        mySet.insert(5);
        mySet.insert(7);
        
        int count = 0;
        
        for(int i = 1; i <= n; i++){
            if(isConfusing(i, mySet))
                count++;
        }
        
        return count;
    }
};


// Approach 2 - DFS
// Time Complexity - O(5^k), k is the number of digits in 'n'.
// Space Complexity - O(1).
// Runs on Leetcode!
class Solution {
    bool isConfusing(long num, set<int>& mySet){
        long newNum = 0;
        long temp;
        long n = num;
        while(num){
            int currDigit = num%10;
            if(mySet.count(currDigit))
                return false;
            
            if(currDigit == 9)
                temp = 6;
            else if(currDigit == 6)
                temp = 9;
            else
                temp = currDigit;
            
            newNum = newNum*10 + temp;
            
            num /= 10;
        }
        
        return (newNum == n) ? false : true;
    }
    
    void dfs(long currNum, int n, int& count, set<int>& mySet, set<int>& mySet2){
        // base
        if(currNum > n)
            return;
        if(isConfusing(currNum, mySet))
            count++;
        
        // logic
        for(auto& itr : mySet2){
            long newNum = currNum*10 + itr;
            if(newNum)
                dfs(newNum, n, count, mySet, mySet2);
        }
    }
public:
    int confusingNumberII(int n) {
        set<int> mySet;
        mySet.insert(2);
        mySet.insert(3);
        mySet.insert(4);
        mySet.insert(5);
        mySet.insert(7);
        
        set<int> mySet2;
        mySet2.insert(0);
        mySet2.insert(1);
        mySet2.insert(6);
        mySet2.insert(8);
        mySet2.insert(9);
        
        int count = 0;
        dfs(0, n, count, mySet, mySet2);
        
        return count;
    }
};