// Time complexity: Exponential 5^L where L is the number of digits in the input
// Space complexity: O(L)
// Did this code successfully run on Leetcode : No, time limit exceeded

/*
Approach 1: Generate all the numbers and check if they are valid 

Approach 2: Generate the numbers using the map or the digits that can be rotated by iterating over all the keys in the map with the cirrent input 
i.e: 
If curr input is 6, generate 60 + 0, 60 + 1, 60 + 6 which are all the possible numbers that could potentially be valid confising number

*/

class Solution {
public:
    int count;
    int confusingNumberII(int n) {
        if(n < 6)
            return 0;
        count = 0;
        // initialise the confusing numbers 
        unordered_map<int, int> confusingDigits {
            {0 , 0},
            {1 , 1},
            {6 , 9},
            {8 , 8},
            {9 , 6}
        };

        //DFS because we are creating every possible new number from the map
        dfs(n, 0, confusingDigits);
        return count;
    }
private:
    void dfs(int n, long current, unordered_map<int,int> confusingDigits) {
        // base case
        if((int)current > n)
            return;

        // logic

        // Update the count if the new number is valid
        if(isValidConfusingNumber((int)current, confusingDigits)) {
            count++;
        }
        
        // generate all the other numbers and call the function recursively on it
        for(auto digit: confusingDigits) {
            long newNumber = (current * 10) + digit.first;
            if (newNumber != 0) {
                dfs(n, newNumber, confusingDigits);
            }
        }
    }
    
    // Get each number from units place 
    // Flip it 
    // Add it to the number and then *10 to make it to the 10s place 
    bool isValidConfusingNumber(int number, unordered_map<int,int> confusingDigits) {
        int reversed = 0;
        int inputNumber = number;
        while(number>0) {
            int temp = number%10;
            reversed = (reversed*10) + confusingDigits[temp];
            number /= 10;
        }
        return (reversed != inputNumber);
    }
};