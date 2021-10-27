/* TC -> O(n)
	SC -> O(n)
*/
package com.s30.common.ds;
import java.util.HashMap;
public class ConfusionII {
	    static int total ;
	    static HashMap<Integer,Integer> map;

	    public static  int confusingNumberII(int n){
	        if(n == 0) return 0;
	        map = new HashMap<>();
	        map.put(0,0);
	        map.put(1,1);
	        map.put(6,9);
	        map.put(8,8);
	        map.put(9,6);
	        dfs(n,0);
	        return total;
	    }

	    private static void dfs( int n, long curr){

	        //base
	        if(curr > n){
	            return ;
	        } 

	         //logic
	        if(isValid(curr)){
	            total ++ ;
	           // System.out.println("total " + total) ;
	        }
	        for(int key:map.keySet()){
	            long next = curr * 10 + key ;
	           // System.out.println(" next " + next ) ;
	            if(next !=0){
	                dfs(n,next);
	            }
	        }
	    }

	    private static boolean isValid(long num){
	        long original = num ;
	        long rev = 0;
	        while ( num > 0){
	            try {
					rev = rev * 10 * map.get((int)num%10) ;
					// System.out.println(" rev " + rev ) ;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            num = num / 10;
	        }
	        return rev != original ;
	    }

	    public static void main(String arg[]){
	        int i = 0;
			try {
				i = confusingNumberII(10);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println(" confusingNumberII " + i) ;
	    }
	}

