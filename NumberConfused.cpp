//Time: O(n)
//Space:O(1) No extra space
class Solution {
    int count; 
    unordered_map<int,int> hMap;
public:
    int confusingNumberII(int n) {
        hMap[0] = 0;
        hMap[1] = 1;
        hMap[6] = 9;
        hMap[8] = 8;
        hMap[9] = 6;
        dfs(0,n);
        return count;
    }
    void dfs(long curr,int n){
        if(curr > n) return;
        if(isValid(curr)) count++;
        for(auto key : hMap){
            long next = curr*10 + key.first;
            if(next != 0){
                dfs(next,n);
            }
        }
    }
    bool isValid(long curr){
        long result = 0;
        long num = curr;
        while(curr > 0){
            long temp = curr%10;
            result = result*10 + hMap[temp];
            curr = curr/10;
        }
        return result != num;
    }
};
