class Solution {
    private int[] confusingPairs = {{0, 0}, {1, 1}, {6, 9}, {8, 8}, {9, 6}};
    private int[] validDigits = {0, 1, 6, 8, 9};

    public int confusingNumberII(int N) {
        return countConfusingNumbers(0, N);
    }
    
    private int countConfusingNumbers(long currentNum, int N) {
        int count = 0;
        if (isConfusingNumber(currentNum)) {
            count++;
        }
        
        for (int digit : validDigits) {
            long nextNum = currentNum * 10 + digit;
            if (nextNum <= N && nextNum != 0) {
                count += countConfusingNumbers(nextNum, N);
            }
        }
        
        return count;
    }
    
    private boolean isConfusingNumber(long num) {
        long originalNum = num;
        long rotatedNum = 0;
        
        while (num > 0) {
            int digit = (int) (num % 10);
            boolean foundPair = false;
            
            for (int[] pair : confusingPairs) {
                if (pair[0] == digit) {
                    rotatedNum = rotatedNum * 10 + pair[1];
                    foundPair = true;
                    break;
                }
            }
            
            if (!foundPair) {
                return false;
            }
            
            num /= 10;
        }
        
        return rotatedNum != originalNum;
    }
}

