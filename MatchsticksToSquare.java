class Solution {

    //Time Complexity: 0(4^n) where n is the no of elements in matchsticks array
    //Space Complexity: 0(n) recursive stack

    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4){
            return false;
        }

        int sum = 0;    //first I calculate the total sum of elements in matchsticks array

        for(int i: matchsticks){
            sum = sum + i;
        }

        if(sum % 4 != 0){   //if the modulo give me 0, means I might be able to form a square, If not, there is no way I can form a square so I return false
            return false;
        }

        int size = sum / 4; //then I get the size of the side, which I can get by dividing it by 4
        Arrays.sort(matchsticks);   //I sort the array because while doing normal backtracking I get TLE because the exhaustive search goes for a long time for large inputs
        reverse(matchsticks);   //also I reverse the array as if I do that, I can fill in the side of the square with the biggest no.'s 1st and if I cannot fill some of my elements in my square array, then there is no way I can make a square. Hence reversing the array and starting with bigger elemets saves on my time a lot.
        return backtrack(matchsticks, size, 0, new int[4]); //I call the backtrack method to check if a square can be formed or not / I pass, the reversed matchsticks array, the size of 1 side of the square, the beginning index in my matchsticks array and the square array that I am forming to check if it can be formed or not

    }

    public void reverse(int [] matchsticks){    //this my my function to reverse the array
        int low = 0;
        int high = matchsticks.length - 1;
        while(low <= high){
            swap(matchsticks, low, high);
            low++;
            high--;
        }
    }

    public void swap(int[] matchsticks, int a, int b){  //I call the swap method to swap 2 no's
        int temp = matchsticks[a];
        matchsticks[a] = matchsticks[b];
        matchsticks[b] = temp;
    }

    public boolean backtrack(int [] matchsticks, int size, int index, int [] square){
        //base
        if(index == matchsticks.length){    //if my index in my matchstick array reaches it's length, means I have exhausted all options to form a sqquare of side = size
            if(square[0] == size && square[1] == size && square[2] == size){    //If all the elements in my square array are equal to the size, means I am able to form a square
                return true;    //so I return true
            }
            return false;   //if any of the element is not equal, I return false
        }
        //logic
        for(int i = 0; i < 4; i++){ //I iterate over indexes in my square array to form different combinations to no's to form each side of the aquare = size
            if(matchsticks[index] + square[i] <= size){ //if the addition of current no. in the square at index i plus the element at matchsticks array is equal to size
                //action
                square[i] = square[i] + matchsticks[index] ;    //then I add that to my square array
                //recurse
                if(backtrack(matchsticks, size, index + 1, square)){    //then I call my backtrack method to get the no. for my next index in square array
                    return true;    //also I return true
                }
                //backtrack
                square[i] = square[i] - matchsticks[index]; //if the combination is not giving me size, then I backtrack my my last step
            }
        }
        return false;   //if I am not able to get all no in square array as size, then I return false
    }
}