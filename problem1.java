//time complexity: 5^L where L=no.of digits in n
//sapce complexity: L
//ran on leetcode: Yes
//do a traversal. start from 0,1,6,8 and 9. These are the numbers whose digit combinations could potentially give a ugly number. Also when processig current number, reverse it and apply the 180 degree transition to make sure the number is actually confusing. 
class Solution {
    int[] start = new int[] {0, 1, 6, 8, 9};

    public int confusingNumberII(int n) {
        return count(n, 1) + count(n, 6) + count(n, 8) + count(n, 9);
    }

    int count(int n, long current) {
        
        if(current > n) return 0;
        var flipped = flip(current);
        int count = 0;
        if(flipped != current) count++;
        for(var s: start) {

            var next = current * 10 + s;
            count += count(n, next);
        }
        return count;
    }

    long flip(long num) {
   
        long result = 0;
        while(num > 0) {
            var digit =(int) num % 10;
            num/=10;
            result*=10;
            result+=flippedDigit(digit);
        }
        return result;
    }

    int flippedDigit(int digit) {
       
        if(digit == 9) return 6;
        if(digit == 6) return 9;
        return digit;
    }
}
