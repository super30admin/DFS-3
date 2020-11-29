

class Solution {
    
    char[][] flipN = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    public int confusingNumberII(int N) {
        String number = Integer.toString(N);
        int TotalValid = calcTotal(number);
        for(int len =1; len<= number.length() ; len++){
            char[] curr = new char[len];
            // call backtracking function and subtract from the totalvalid
            
            TotalValid = TotalValid - backtracking(curr, 0, len-1, number);
        }
        return TotalValid;
    }
// return nonconfusing number
    private int backtracking(char[] curr, int left, int right, String number){
        int retVal = 0;
        //base case
        if(left>right){
            String currString = new String(curr);
            if(currString.length() < number.length() || currString.compareTo(number) <= 0){
                retVal += 1;
            }
            return retVal;
        }
        //recursive case
        for(char[] p : flipN){
            curr[left] = p[0];
            curr[right] = p[1];
            
            // avoid confusing number case
            if((curr[0] == '0' && curr.length > 1) || (left == right && p[0] != p[1])){
                continue;
            }
            retVal += backtracking(curr, left+1, right-1,number);
        }
        return retVal;        
    }
    //Calculate totalValid numbers
    private int calcTotal(String Number){
        if(Number.length() == 0) return 1;
        
        int retVal = 0;
        char first= Number.charAt(0);
        retVal =  calcnumber(first) * (int) Math.pow(5,Number.length()-1);
        
        if(first == '0' || first == '1' || first == '6' || first == '8' || first == '9'  ){
            retVal += calcTotal(Number.substring(1));
        }
        return retVal;
        
    }
    private int calcnumber(char first ){
        int count=0;
        for( char[] charray: flipN ){
            if(first > charray[0]){
              count++;  
            }
            else break;
            
        }
        return count;
    }
}
