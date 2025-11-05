class Solution {
//Time Complexity: O(4^k)
//Space Complexity: O(k)
//We calculate square side length and use back tracking to fill all sticks in all 4 sides
//To further optimize on run time, we sort the sticks in descending order and then perform back tracking
    public List<Integer> nums;
    public int[] sides = new int[4];
    public int sidelength=0;
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int i=0;i<matchsticks.length;i++){
          sum += matchsticks[i];  
        }
        if((sum/4)*4!=sum){
           return false; 
        }
        nums = new ArrayList<>();
        for(int i=0;i<matchsticks.length;i++)
        {
            nums.add(matchsticks[i]);
        }
        nums.sort((a,b)->b-a);
        sidelength = sum/4;
        return dfs(0);
    }
    
    public boolean dfs(int index){
        if(index==nums.size()){
            return sides[0]==sides[1]&&sides[1]==sides[2]&&sides[2]==sides[3];
        }
        for(int i=0;i<sides.length;i++){
            if(sides[i]+nums.get(index)<=sidelength){
               sides[i]+=nums.get(index);
               if(dfs(index+1)){
                   return true;
               }
                sides[i]-=nums.get(index);
            }
        }
        return false;
    }
}