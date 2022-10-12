
Confusing Number II
class Solution {
    private int[] iterators = new int[]{0, 1, 6, 8, 9};

    public int confusingNumberII(int N) {
        return find(0, N);
    }
    
    private int find(int current, int N) {
        int count = 0;
        if (isConfusing(current)) {
            count++;
        }
        
        for (int iter : iterators) {
            int baseLimit = Integer.MAX_VALUE / 10;
            int digitLimit = Integer.MAX_VALUE % 10;
            // prevent overflow
            if (current > baseLimit || current == baseLimit && iter > digitLimit) {
                continue;
            }
            int next = current * 10 + iter;
            if (next >= 1 && next <= N) {
                count += find(next, N);
            }
        }
        
        return count;
    }

 private boolean isConfusing(int n) {
        int original = n;
        int result = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 6) {
                digit = 9;
            } else if (digit == 9) {
                digit = 6;
            }
            result *= 10;
            result += digit;
            n /= 10;
        }

        return result != original;
    }
}



Matchsticks to Square

public boolean makesquare(int[] nums) {
        if(nums.length < 4){
            return false;
        }
        int sum = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 4 != 0){
            return false;
        }
        int side = sum / 4;
        boolean[] isVis = new boolean[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            if(isVis[i]){
                continue;
            }
            if(!dfs(nums, isVis, 0, i, side)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int[] nums, boolean[] isVis, int cur, int end, int side){
        cur += nums[end];
        if(cur > side){
            return false;
        }
        if(cur == side){
            isVis[end] = true;
            return true;
        }
        else{
            for(int i = end - 1; i >= 0; i--){
                if(isVis[i]){
                    continue;
                }
                if(dfs(nums, isVis, cur, i, side)){
                    isVis[end] = true;
                    return true;
                }
            }
            return false;
        }
    }





