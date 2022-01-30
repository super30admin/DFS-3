// 1088 - Confusing Number 2
// Time - Exponentail
// Space - O(n)
class Solution {
    int count;
    
    public int confusingNumberII(int n) {
        count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 0);
        map.put(1, 1);
        map.put(9, 6);
        map.put(8, 8);
        map.put(6, 9);
        
        helper(n, map, 0);
        
        return count;
    }
    
    private void helper(int n , HashMap<Integer, Integer> map, long curr){
        
        if(curr > n){
            return;
        }
        
        if(isValid(map, curr)){
            count++;
        }
        
        
        for(int key : map.keySet()){
            
            long newNum = curr * 10 + key;
            
            if(newNum != 0)
            {
                helper(n, map, newNum);
            }   
        }
    }
    
    private boolean isValid(HashMap<Integer, Integer> map, long curr){
        
        long temp = curr;
        
        long newNum = 0;
        
        while(temp > 0){
            
            long digit = temp % 10;
            int rotatedDigit = map.get((int)digit);
            newNum = newNum * 10 + rotatedDigit;
            temp = temp / 10;
        }
        
        return (newNum != curr);
    }
}