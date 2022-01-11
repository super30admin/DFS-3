//Timecomplexity:- O(5^n).
//spacecomplexity:-0(10).

import java.util.*;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        solution ans=new solution();
        System.out.println(ans.confusingnumber(20));
    }

    public static class solution{
        int count=0;
        public int confusingnumber(int N){
           HashMap<Integer,Integer> cache=new HashMap<>();
            cache.put(0,0);
            cache.put(1,1);
            cache.put(6,9); // for getting possible 180 degrees rotated numbers initially storing which integers have valid integers in
                            // rotating. as keys and values will be their rotated digits.
            cache.put(8,8);
            cache.put(9,6);

            int x=0;
            Long current= Long.valueOf(x);
            dfs(cache,current,N);
            return count;
            
            
        }
        private void dfs(HashMap<Integer,Integer> cache, Long current,int N){
            if(isconfusing(current,cache)){
                count++; // function to check whether it is confusing or not.
            }
            
            for(int x:cache.KeySet()){
                int y=cache.get(x);
                Long next=next*10+y;
                if(next==0){//eleminating zero branch as reccursively it gives whole tree again and again.
                    return;
                }
                else if(next<=N){
                    dfs(cache,next,N); //calling every formed number reccursively to check if it is confused or not.
                }
                
            }
        }
        private  boolean isconfusing(Long current,HashMap<Integer,Integer> cache){
            int ans1= 0;
            Long ans=Long.valueOf(ans1);
            Long next=current;
            while(current>0){
                ans=ans*10+cache.get( (int) (long) current%10);// after getting formed number reversing from hashmap so that we get confused number.
                current=current/10;
            }
            return next==ans;
        }
    }
}