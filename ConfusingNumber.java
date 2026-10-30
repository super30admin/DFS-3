/**
 * Time Complexity:  O(5^k) where k is the number of digits in n
 * Space Complexity: O(k)
 *
 */
class Solution {
    Map<Integer, Integer> numToVal;
    int count;
    public int confusingNumberII(int n) {
        numToVal = new HashMap<>(Map.of(0,0, 1,1, 6,9, 8,8, 9,6));
        count = 0;
        dfs(0l, n);
        return count;
    }

    void dfs(long num, int n){
        if(num > n) return;

        if(isConfusing((int)num)){
            count++;
        }

        for(int key : numToVal.keySet()){
            long newNum = num * 10 + key;
            if(newNum!=0){
                dfs(newNum, n);
            }

        }
    }

    boolean isConfusing(int num){
        int temp =num;
        int reversedNum = 0;
        while(num > 0){
            int lastDigit = num % 10;
            reversedNum = reversedNum * 10 + numToVal.get(lastDigit);
            num = num/10;
        }

        return reversedNum!=temp;

    }
}