// Confusing Number ii
// Time Complexity: O(log n * k), where k is the number of unique digits in the map.
// Space Complexity: O(k), where k is the number of unique digits in the map.
// Did this code pass all test cases? Yes, it passed all test cases.

// Approach: 
// 1. We will use a depth-first search (DFS) approach to generate all possible numbers from 0 to n.
// 2. We will maintain a map to store the confusing digit mappings.
// 3. For each generated number, we will check if it is a confusing number by reversing it using the map.
// 4. If the reversed number is different from the original number, we will increment the count.
// 5. We will ensure that we do not generate numbers with leading zeros.
// 6. Finally, we will return the count of confusing numbers found.

#include <unordered_map>
using namespace std;
class Solution {
    int count = 0; 
public:
    int confusingNumberII(int n) {
        
        if(n == 0){
            return 0;
        }
        unordered_map<int, int> map;
        map[0] = 0;
        map[1] = 1;
        map[6] = 9;
        map[9] = 6;
        map[8] = 8;
        dfs(n, 0, map);
        return count;
    }
private: 
    void dfs(int n, long curr, unordered_map<int, int>& map){
        //base case
        if(curr > n){return;}
        //logic
        if(isConfusing(curr, map)){
                count++;
            }
        for(auto& keys : map){
            int key = keys.first;
            long newNum = curr * 10 + key;
            if(newNum == 0){continue;}
            dfs(n, newNum, map);
            
        }
    }
    
    bool isConfusing(long newNum, unordered_map<int, int>& map){
        long result = 0;
        long temp = newNum;
        while(newNum > 0){
            long digit = newNum % 10;
            result = result * 10 + map[digit];
            newNum = newNum / 10;
        }
        return result != temp;
    }
};