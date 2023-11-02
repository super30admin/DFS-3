//Problem 1: Confusing Number II
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Create a list of possible numbers that make sense after 180 deg rotation.
class Solution {
    //O(5^10) 
    HashMap<Integer, Integer> map;
    int count;
    public int confusingNumberII(int n) {
        this.map= new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(9,6);
        map.put(8,8);
        dfs(0l,n);
        return count;
    }

    private void dfs(long curNum, int n){
        //base
        if(curNum>n) return;

        //logic
        if(isConfusing(curNum))
            count++;C
        for(int key: map.keySet()){
            long newnum=curNum*10+key;
            if(newnum!=0)
                dfs(newnum, n);
        }
    }

    private boolean isConfusing(long num){
        long temp=num;
        long res=0l;
        while(num>0){
            int digit=(int)num%10;
            res=res*10+map.get(digit);
            num/=10;
        }
        return temp!=res;
    }
}

//Problem 2: Matchsticks to Square
// Time Complexity : O(4^n)
// Space Complexity : O(max(side))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// check for all possible maximum sides to minimum sides sets that we can form and select the max.
// if we sort it at the first and then add matchsticks to set, we will have less combinations, TC reduces drastically.
class Solution {
    //O(nlogn + 4^n) //O(n)
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        int max=0;
        for(int matchstck: matchsticks){
            max=Math.max(max, matchstck);
            sum+=matchstck;
        }
        if(sum%4!=0) return false;
        int side=sum/4;
        if(max>side) return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, 0, new int[4], side);
        
    }
    private void reverse(int[] ar){
        int left=0, right=ar.length-1;

        while(left<right){
            int temp=ar[left];
            ar[left]=ar[right];
            ar[right]=temp;
            left++;
            right--;
        }
    }
    private boolean backtrack(int[] matchsticks,int idx, int[] square, int side){
        //base
        if(idx==matchsticks.length){
            if(square[0]==side && square[1]==side && square[2]==side){
                return true;
            }
            return false;
        }

        //logic
        int curmatch=matchsticks[idx];
            for(int j=0;j<4;j++){
                //action
                if(square[j]+curmatch <= side){
                    square[j]+=curmatch;
                    //recurse;
                    if(backtrack(matchsticks, idx+1, square, side))
                        return true;
                    
                    //backtrack
                    square[j]-=curmatch;
                }
            }
        return false;
    }
}