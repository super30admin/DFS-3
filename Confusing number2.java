//time complexity-O(5^n)
//Space complexity-O(number of valid numbers)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    HashMap<Integer,Integer> map= new HashMap<>();//we will only consider numbers generated from valid digits
    int count;
    public int confusingNumberII(int N) {
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        backtrack(0,N);
        return count;
    }
    
    public void backtrack(long curr, int N){
        if(isValid(curr))
            count++;
        
        for(int n: map.keySet()){
            long next=curr*10+n;//adding each digit one at a time from hashmap
            
            if(next<=N && next!=0){
                backtrack(next,N);
            }
            
        }
    }
    public boolean isValid(long curr){
        long original = curr;
        long ans=0;
        while(curr>0){
            ans=ans*10+(map.get((int)curr%10));//180 degree rotation
            curr/=10;
        }
        return ans!=original;
    }
}