# DFS-3

## Problem1: Number Confused(https://leetcode.com/problems/confusing-number-ii/)

//Time Complexity = O(5 \* num of digits)
//Space Complexity = O(num of digits)

class Solution {
int result;
HashMap<Integer, Integer> map;
public int confusingNumberII(int n) {
if(n < 1) {
return 0;
}

        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);

        dfs(n, 0);
        return result;
    }

    private void dfs(int n, long current) {

        if(current > n) {
            return;
        }

        if(isConfusing(current)) {
            result++;
        }
        for(Integer i : map.keySet()) {
            long next = current * 10 + i;
            if(next != 0) {
                dfs(n,next);
            }
        }
    }
    private boolean isConfusing(long num) {
        long reverse = 0;
        long number = num;

        while(num > 0) {
            reverse = reverse * 10 + map.get((int)num % 10);
            num = num / 10;
        }
        return reverse != number;
    }

}

## Problem2: Matchsticks to Square (https://leetcode.com/problems/matchsticks-to-square/)

//Time Complexity = O(4^N)
//Space Complexity = O(N)

class Solution {
public boolean makesquare(int[] matchsticks) {
if(matchsticks == null || matchsticks.length == 0) {
return false;
}
int sum = 0;
for(Integer i : matchsticks) {
sum += i;
}
if(sum % 4 != 0) {
return false;
}
int side = sum / 4;

        return backtrack(matchsticks,0, new int[4], side);
    }

    private boolean backtrack(int[] matchsticks, int index, int[] square,int side) {

        if(square[0] == side && square[1] == side && square[2] == side && square[3] == side) {
            return true;
        }


        for(int i = 0; i < 4; i++) {
            int current = matchsticks[index];
            if(current + square[i] <= side) {
                square[i] = square[i] + current;
                if(backtrack(matchsticks,index + 1, square, side)) {
                    return true;
                }
                square[i] = square[i] - current;
            }
        }
        return false;
    }

}
