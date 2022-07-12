// Time Complexity :O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : NA, premium question
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1) We can calculate all valid numbers from hashmap 
// 2) Check if it is valid confusing number and if its less than n
// 3) add to result


Dictionary<int, int> dict;
int count;
public int confusingNumbers(int n)
{
    if (n == 0)
        return 0;

    dict.Add(0, 0);
    dict.Add(1, 1);
    dict.Add(6, 9);
    dict.Add(8, 8);
    dict.Add(9, 6);

    dfsConfusingNumber(n, 0);

    return count;

}

private void dfsConfusingNumber(int n, long currNumber)
{
    //base
    //if curr number is greater than n, we dont those need numbers
    if (currNumber > n)
        return;

    //logic
    //check if curr number is valid confusing number
    if (isValidConfusingNumbers(currNumber))
        count++;

    //get new number to check to call dfs
    foreach (var key in dict.Keys)
    {
        long newNumber = currNumber * 10 + key;
        if(newNumber != 0)
            dfsConfusingNumber(n, newNumber);
    }
}

private bool isValidConfusingNumbers(long currNumber)
{
    long original = currNumber;
    long reverseNumber = 0;
    //we reverse the original number
    while(currNumber > 0)
    {
        reverseNumber = reverseNumber * 10 + dict[(int)currNumber % 10)];
        currNumber = currNumber / 10;
    }

    return currNumber != original;
}
