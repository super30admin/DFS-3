import java.util.HashMap;

//Time Complexity: O(n); where n is input range to find confusing numbers.
//Space Complexity: O(1)
public class ConfusingNumber_II { 
	/**Approach: DFS + HashMap**/
	HashMap<Integer, Integer> map;
    int count;
    public int confusingNumberII(int n) {
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);        
        dfs(n, 0);
        return count;
    }
    private void dfs(int n, long curr){
        //base
        if(curr > n) return;
        if(isConfusing(curr)) count++;        
        //logic
        for(Integer key : map.keySet()){
            long newNum = curr * 10 + key;
            if(newNum != 0){
                dfs(n, newNum);
            }
        }
    }
    private boolean isConfusing(long num){ // O(1) because it would be max of 9 digits
        long res = 0;
        long initial = num;
        while(num > 0){
            int digit = (int) num % 10;
            res = res * 10 + map.get(digit);
            num = num / 10;
        }        
        return (res != initial);
    }
	
	/** Driver code to test above **/
	public static void main (String[] args) {	
		ConfusingNumber_II ob  = new ConfusingNumber_II();	
		int n = 20; 
		
		System.out.println("Total number of confusing numbers in inclusive range [1, "+n+"] are: "+ ob.confusingNumberII(n));         
	}	
}
