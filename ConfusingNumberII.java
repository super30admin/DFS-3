//Time Complexity : O(5^k), where k is the no of digits in n
//Space Complexity : O(1)
//Did this code run successfully on leetcode: Yes
//Have you face any issue while writing this code: No
//DFS
class ConfusingNumberII {
    HashMap<Integer, Integer> map;
    int count = 0;
    public int confusingNumberII(int n) {
        this.map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);

        dfs(0l,n);
        return count;
    }

    private void dfs(long currNum, int n) {
        //base case
        if(currNum > n) return;

        //logic
        if(isConfusingNumber(currNum)) count++;
        for(int key : map.keySet()) {
            long newNum = currNum * 10 + key;
            if(newNum != 0)
                dfs(newNum, n);
        }
    }

    private boolean isConfusingNumber(long num) {
        long temp = num;
        long result = 0;

        while(num > 0) {
            int lastDigit = (int)num%10;
            result = result * 10 + map.get(lastDigit);
            num = num/10;
        }
        return result != temp;
    }
}

class ConfusingNumberII {
    HashMap<Integer, Integer> map;
    int count = 0;
    public int confusingNumberII(int n) {
        this.map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
    
        Queue<Long> queue = new LinkedList<>();
        queue.add(0l);
    
        while(!queue.isEmpty()) {
            long currNum = queue.poll();
            if(isConfusingNumber(currNum)) count++;
            for(int key : map.keySet()) {
                long newNum = currNum * 10 + key;
                if(newNum != 0 && newNum <= n) {
                    queue.add(newNum);
                }
            }
        }
    
        return count;
    }
        
    private boolean isConfusingNumber(long num) {
        long temp = num;
        long result = 0;
    
        while(num > 0) {
            int lastDigit = (int)num%10;
            result = result * 10 + map.get(lastDigit);
            num = num/10;
        }
        return result != temp;
    }
}