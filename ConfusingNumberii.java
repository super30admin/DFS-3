// "static void main" must be defined in a public class.
public class Main {

    //Time Complexity: 0(5^l) where l is the no. of digits in n
    //Space Complexity: 0(l)

    static HashMap<Integer, Integer> map;   //map to store the confusing no's and their 180 degree rotation
    static int count;   //count to store total no. of confusing no's in range n

    public static int uglyNumberii(int n){
        map = new HashMap<>();
        map.put(0, 0);  //putting all the confusing no's from 0 to 9 and their 180 degree rotation
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        helper(n, 0);   //dfs method to calculate count. I pass the range and the current no that I calculate and check if it si confusing or not
        return count;
    }

    public static void helper(int n, long currNumber){
        //base
        if(currNumber > n){ //if current number becomes greater than count, then I have reached out of bounds and I return
            return;
        }
        //logic
        if(isValidConfusing(currNumber)){   //a function to check if the no. if confusing or not
            count++;    //I do count++ if the no if confusing
        }
        for(int key : map.keySet()){    //I only check for the confusing no.'s if the digit contains the one of the 5 no's in it
            long num = currNumber * 10 + key;   //I calculate the new no. by multiplying my currno. by 10 and adding the key, I will give me a new no in the range that has a confusing no. in it.
            if(num != 0){   //If my new no is 0, I will not call my dfs again because it will keep on giving me 0. If not, I call my dfs and check the no is confusing or not and proceed further
                helper(n, num);
            }
        }
    }

    public static boolean isValidConfusing(long num){
        long orig = num;    //I store the original no. as I will have to compare it at the end with my new no.
        long reverse = 0;   //I calculate the reverse because when I rotate a 2 digit or more digit no and a confusing no. I get a new no.

        while(num > 0){ //I run a loop until my num is greater than 0
            reverse = reverse * 10 + map.get((int)num % 10);    //I calculate the reverse by multiplying reverse by 10 and getting the rotation of the confusing no. from the map and making it as 1st digit in my new reverse no.
            num = num / 10; //I divide my num by 10 to get another digit
        }

        return reverse != orig; //at the end , if my reverse no. is not equal to my original no., I return true
    }

    public static void main(String[] args) {
        System.out.println(uglyNumberii(200));
    }
}