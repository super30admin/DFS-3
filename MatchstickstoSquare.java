package s30.DFS1.DFS3;

import java.util.Arrays;


//Algo: We can find the side of resultant square if possible. then we have four groups for any integer to go.
//sorting improves the TC, reducing number of iterations.

//TC: 4^N
//SC: N
public class MatchstickstoSquare {


    int[] matchsticks;
    int[] square;
    public boolean makesquare(int[] matchsticks) {

        square = new int[4];
        this.matchsticks = matchsticks;

        Arrays.sort(this.matchsticks);

        reverse();

        int side = getSide();

        if(side == -1) return false;

        return makeSquare(0, side);
    }

    private boolean makeSquare(int index, int side){
        //base

        if(index == matchsticks.length) return true;


        //recurse

        boolean canMakeSquare = false;
        for(int i = 0; i < 4; i++){

            if( matchsticks[index] + square[i] <= side){
                square[i]+= matchsticks[index];
                if(makeSquare(index+1, side)) return true;
                square[i] -= matchsticks[index];
            }


        }

        return false;
    }


    private int getSide(){

        int sum =0;

        for(int match : matchsticks){
            sum+= match;
        }

        int side = sum / 4;

        if(side  * 4 != sum ) return -1;

        return side;
    }

    private void reverse(){

        int start = 0; int  end = matchsticks.length -1;

        while(start < end){
            int temp = matchsticks[start];
            matchsticks[start] = matchsticks[end];
            matchsticks[end] = temp;
            start++;
            --end;
        }
    }
    public static void main(String[] args) {

    }
}
