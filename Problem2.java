// 473 MatchSticks to Square
// time - exponentail
// Space - O(n)
class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int sum = 0;
        
        for(int i = 0; i < matchsticks.length; i++){
            
            sum += matchsticks[i];
        }
        
        if(sum % 4 != 0){
            return false;
        }
        
        matchsticks = IntStream.of(matchsticks).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
        
        // Arrays.sort(objArray, (a, b) -> (b - a));
        
        int side = sum / 4;
        int[] sides = new int[4];
        int index = 0;
        
        return helper(side, matchsticks, sides, index);
    }
    
    public boolean helper(int side, int[] matchsticks, int[] sides, int index){
        
        if(sides[0] == side && sides[1] == side && sides[2] == side && sides[3] == side){
            return true;
        }
        
        if(index == matchsticks.length){
            return false;
        }
        
        for(int i = 0; i < sides.length; i++){
            
            if(matchsticks[index] + sides[i] <= side){
                
                sides[i] = sides[i] + matchsticks[index];
                
                if(helper(side, matchsticks, sides, index + 1)){
                    return true;
                }
                
                sides[i] = sides[i] - matchsticks[index];
            }
        }
        
        return false;
    }
}