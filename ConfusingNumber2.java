//TC O(n)+O(k)
//SC O(1)

import java.util.*;

class Solution {
    int count=0;
    HashMap<Integer,Integer> a=new HashMap<Integer,Integer>();
    private boolean iscon(int n){
        int temp=n;
        int result=0;
        while(n!=0){
            int last=n%10;
            result=(result*10)+a.get(last);
            n=n/10;
        }
        if(result!=temp){
            return true;
        }
        return false;
    }

    private void dfs(int present,int n)
    {
        if(present>n){
            return;
        }

        if(iscon(present)){
            count++;
        }
        //branching
        for(int i:a.keySet()){

            int num=(present*10+i);
            if(num==0) continue;
            dfs(num,n);
        }
    }

    public int confusingNumberII(int n) {

        a.put(6,9);
        a.put(9,6);
        a.put(0,0);
        a.put(1,1);
        a.put(8,8);
        //map for the numbers
        //function
        dfs(0,n);
        return count;
        //generating the combination using dfs
    }
}