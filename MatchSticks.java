//Time - O(n^n)
//space - O(n)
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum =0;
        for(int i=0; i< matchsticks.length; i++){
            sum += matchsticks[i];
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks, matchsticks.length);
        if(sum %4 !=0) return false;
        return backtrack(matchsticks, 0, new int[4], sum/4);
    }
    boolean backtrack(int[] matchsticks, int i, int[] sub, int size){

        if(sub[0] ==size && sub[1] ==size && sub[2] ==size && sub[3] ==size) return true;
        //action
        for(int j=0; j<sub.length;j++){
            if(sub[j]+matchsticks[i] <= size){
                sub[j]+=matchsticks[i];
                if(backtrack(matchsticks,i+1 ,sub,size)) return true;;
                sub[j]-=matchsticks[i];
            }
        }
        return false;
    }

     void reverse(int a[], int n)
    {
        int left =0;
        int right = a.length-1;
        while(left<right){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            ++left;
            --right;
        }
  
    }
}