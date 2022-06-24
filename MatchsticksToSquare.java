import java.util.Arrays;
import java.util.Collections;

//Time Complexity: O(4^n); where n is length of input array.
//Space Complexity: O(n)
public class MatchsticksToSquare {
	/**Approach: Backtracking**/	
	int[] square;
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks ==  null || matchsticks.length < 4) return false;
        int sum = 0;
        int max = 0;
        for(int stick : matchsticks){ //O(n)
            max = Math.max(max, stick);
            sum += stick;
        }        
        int side = sum / 4;
        //Can't form square if sum is not divisible by 4 or side is less than max length of a stick in array
        if(sum % 4 != 0 || side < max) return false;        
        square = new int[4];
        matchsticks = Arrays.stream(matchsticks).boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
        return backtrack(matchsticks, side, 0); //O(4^n)    
    }
    private boolean backtrack(int[] matchsticks, int side, int idx){
        //base
    	if(idx == matchsticks.length && 
    			square[0] == side && square[1] == side && square[2] == side && square[3] == side) {
            return true;
        }   
        //logic
        //[0,0,0,0]
        for(int i=0; i<4; i++){
            if(square[i] + matchsticks[idx] <= side){
                square[i] += matchsticks[idx]; //action
                if (backtrack(matchsticks, side, idx+1)) return true; //recurse
                square[i] -= matchsticks[idx]; //backtrack
            }
        }        
        return false;
    }
	
	/** Driver code to test above **/
	public static void main (String[] args) {			
		MatchsticksToSquare ob  = new MatchsticksToSquare();
		int[] matchsticks = {3,3,3,3,4};//{1,1,2,2,2};
								
		System.out.println("Square can be formed using matchsticks : "+ob.makesquare(matchsticks)); 
	}	
}
