class Problem1088 {
    HashMap<Integer, Integer> numberMap;
    int count;
    public int confusingNumberII(int n) {
        this.numberMap=new HashMap<>();
        this.count=0;
        numberMap.put(0,0);
        numberMap.put(1,1);
        numberMap.put(6,9);
        numberMap.put(8,8);
        numberMap.put(9,6);
        dfs(0,n);
        return count;
    }
    
    private void dfs(long curr, int n){
        //base case
        if(curr>n)
            return;
        
        //logic
        if(isConfusingNum(curr)){
            count++;
        }
        for(int key: numberMap.keySet()){
            long newNumber=curr*10+key;
            if(newNumber!=0)
                dfs(newNumber,n);
        }
    }
    
    private boolean isConfusingNum(long curr){
        long temp=curr;
        long reverseNumber=0;
        while(curr>0){
            int digit=(int)curr%10;
            reverseNumber=reverseNumber*10+numberMap.get(digit);
            curr=curr/10;
        }
        return temp!=reverseNumber;
    }
}
