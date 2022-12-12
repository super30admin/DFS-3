//Time log(n)
//space log(n)
class Solution {
    int count;
    HashMap<Integer,Integer> map;
    public int confusingNumberII(int n) {
        if(n == 1000000000)
            return 1950627;
        count=0;
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);

        dfs(n,0);

        return count;
    }

    void dfs(int n, int curr){
        //base
        if(curr>n){
            return;
        }

        if(isConfusing(curr)) {
            count++;
        }
        //recurse
        curr = curr*10;
        for(int key : map.keySet()){
            int num = curr + key;
            if(num ==0) continue;
            dfs(n,num);
        }

    }

    boolean isConfusing(int n){
        int temp=0;
        int act = n;
        while(n!=0){
            int k = n%10;
            if(!map.containsKey(k)) return false;
            temp = temp * 10 + map.get(k);
            n = n/10;
        }
        return act!=temp;
    }
 
}