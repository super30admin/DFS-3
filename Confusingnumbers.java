//TC : 5^L where L is the length of digits in n
//SC : L
class Solution {
    HashMap<Integer,Integer> hm;
    int result;
    public int confusingNumberII(int n) {
        if(n<=1) return 0;
        result = 0;
        hm = new HashMap();
        hm.put(0,0);
        hm.put(1,1);
        hm.put(6,9);
        hm.put(8,8);
        hm.put(9,6);
        dfs(n,0);
        return result;
    }

    private void dfs(int n, long num){
        //base
        if(num > n) return;
        //logic
        if(isValidConfusingNum(num))
            result++;

        for(int key : hm.keySet()){
            long newNumber = (num*10) + key;
            if(newNumber!=0)
                dfs(n,newNumber);
        }
    }

    private boolean isValidConfusingNum(long num){

        long copy = num;
        long reverseNum = 0;
        while(num>0){
            reverseNum = reverseNum*10 + hm.get((int)num%10);
            num = num/10;
        }
        return copy!=reverseNum;

    }
}