// Tc:O(5^k)

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = sc.nextInt();
        Solution sol = new Solution();
        int result = sol.confusingNumberII(N);
        System.out.println("Number of confusing numbers: " + result);
    }
}

class Solution {
    HashMap<Integer,Integer> map;
    int count;
    public int confusingNumberII(int N) {
        this.map= new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        dfs(0,N);
        return count;
    }
    
    private void dfs(int curr,int N){
        if(curr>=N) return;
        
        if(isConfusing(curr)) count++;
        
        for(int digit:map.keySet()){
            int newNum=curr*10+digit;
            if(newNum!=0){
                dfs(newNum,N);
            }
        }
    } 
    
    private boolean isConfusing(int curr){
        int temp=curr;
        int result=0;
        while(temp>0){
            int digit = temp%10;
            result=result*10+map.get(digit);
            temp=temp/10;
        }
        
        return curr!=result;
    }
    
}