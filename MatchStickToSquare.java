// Time Complexity : O(4^N) where n in the length of matchsticks array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Sort the array in reverse order, this is an optimization, as this would result in less computation.
// We know that square will have all sides equal. We can create 4 buckets and add sticks to them by adding sums
// When all the matchsticks are used and all the 4 buckets values are same then we know its possible
// We apply this logic to create our backtrack fnc and return true if the case is satisfied
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if(sum % 4 != 0)
            return false;
        int eachside = sum/4;
        int[] sides = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return backtrack(matchsticks, 0, sides, eachside);
    }
    public boolean backtrack(int[] arr, int index, int[] sides, int slen){
        //base
        if(index == arr.length){
            return sides[0]==sides[1] && sides[1]==sides[2] && sides[2]==sides[3];
        }
        //recurse
        boolean possible = false;
        for(int i = 0; i < 4; i++){
            sides[i] += arr[index];
            if(sides[i] <= slen )
                if(backtrack(arr, index+1, sides, slen))
                    return true;
            sides[i] -= arr[index];
        }
        return false;
    }
    public void reverse(int arr[]){
        int s = 0;
        int e = arr.length - 1;
        while(s < e){
            int temp = arr[e];
            arr[e] = arr[s];
            arr[s] = temp;
            s++;
            e--;
        }
    }
}