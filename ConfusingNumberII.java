class ConfusingNumberII {
    //time:O(n) where n=value of input number
    //space:O(n), recursive stack fro dfs
    //var to count num of confusing numbers
    int count;
    //map to store valid single digit number and its confusing number equivalent
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public int confusingNumberII(int n) {
        //initializing map
        map = new HashMap<>();
        
        //adding valid single digit confusing number to map
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        
        //dfs through the number
        dfs(n, 0);
        
        return count;
    }
    
    public void dfs(int n, long curr){
        
        //if curr is valid confusing num, increase count
        if(isValid(curr)) count++;
        
        //looping through all the valid single digit confusing nums
        for(int key: map.keySet()){
            
            //next num to traverse
            long next = curr*10+key;
            
            //if next num is within bounds and is not zero
            if(next<=n && next!=0){
                dfs(n, next);
            }
        }
    }
    
    public boolean isValid(long num){
        
        //storing original val of num
        long original = num;
        //initializing res var
        long result = 0;
        
        
        while(num>0){
            //update result
            result = result * 10 + map.get((int)num%10);
            //update num
            num = num/10;
        }
        //if original number differs from new result then its a avlid confusing num
        return original != result;
    }
}