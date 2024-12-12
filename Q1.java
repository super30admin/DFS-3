
Time Complexity (TC): O(log n)
Space Complexity (SC): O(log n)
class Solution {
    int[] start = new int[] {0, 1, 6, 8, 9};

    public int confusingNumberII(int n) {
        return count(n, 1) + count(n, 6) + count(n, 8) + count(n, 9);
    }

    int count(int n, long current) {
        
        if(current > n) return 0;
        var flipped = flip(current);
        int count = 0;
        // we can count the value if they are not the same. so we dont  count numbers like 1, 8, 88 etc..
        if(flipped != current) count++;
        for(var s: start) {
// we just take the current number and append the next digit in the least significant location. ex 10 becomes 100, 101, 106, 108 and 109
            var next = current * 10 + s;
            count += count(n, next);
        }
        return count;
    }

    long flip(long num) {
    // we use this method to flip a number. so 1998 becomes 8661
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
        // just helps us flip a single digit
        if(digit == 9) return 6;
        if(digit == 6) return 9;
        return digit;
    }
}
