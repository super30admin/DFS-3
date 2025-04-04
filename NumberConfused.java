class Solution {
    HashMap<Integer, Integer> map; 
    int count;

    //Time Complexity:O(5^n)
    //Space Complexity:O(1)
    public int confusingNumberII(int n) {
        
        map = new HashMap<>();
        map.put (0,0);
        map.put (1,1);
        map.put (6,9);
        map.put (8,8);
        map.put (9,6);

        dfs (0,n);
        return count;
    }

    private void dfs (long curr, int n){
        // base case
        if (curr > n)
        return;

        if (isConfusing (curr)){
            count++;
        }
        //logic : we'll try to create more numbers out of the curr one
        for (int key : map.keySet()){
            long newNumber = curr;
            newNumber = (newNumber * 10) + key;
            if (newNumber != 0)
            dfs (newNumber, n);
        }
    }

    private boolean isConfusing (long curr){
        long rev= 0;
        long temp = curr;
        while (temp > 0){
            int rem = (int)temp % 10;
            rev = (rev * 10) +(int) map.get (rem);
            temp = temp/10;
        }
            return curr != rev;
    }
}
