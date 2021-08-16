class Makesquare {
    
    //time: O(n!) where n = length of input array
    //space: O(n) for recursive stack
    //did it run successfully on leetcode: yes
    
    public boolean makesquare(int[] matchsticks) {
        //empty case
        if(matchsticks==null || matchsticks.length==0) return false;
        
        //initializing sum
        int sum = 0;
        //calculating sum of input array
        for(int i=0; i<matchsticks.length; i++){
            sum += matchsticks[i];
        }
        //if sum is not divisible by 4 then it is not a square
        if(sum%4 != 0) return false;
        
         
        return backtrack(matchsticks, new int[4], 0, sum/4);
    }
    
    public boolean backtrack(int[] matchsticks, int[] square, int index, int side){
        
        //base
        //if all sides are qual to given side and reached end of input matrix
        if(index>= matchsticks.length && square[0]==side && square[1]==side && square[2]==side && square[3]==side){
                
            return true;
        }
        
        //action
        //for all the four sides of square
        for(int i=0; i<square.length; i++){
            //add current element to current side, if it is greater than given side, current element to next side
            if(square[i]+matchsticks[index]<=side){
                square[i] += matchsticks[index];
                //move to next index in input matrix
                if(backtrack(matchsticks, square, index+1, side)) return true;
                //backtrack
                square[i] -= matchsticks[index];
            }
        }
        return false;
        
    }
}