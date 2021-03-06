class Solution {
public:
    bool checkIfSquare(vector<int> nums, int index, vector<int> sides, int target){
        if(index == nums.size()) {
            return sides[0]==sides[1] && sides[1]==sides[2] && sides[2]==sides[3];
        }
        for(int i=0;i<4;i++){
            if(sides[i]+nums[index]>target) continue;
            sides[i]+=nums[index];
            if(checkIfSquare(nums,index+1,sides,target)) return true;
            sides[i]-=nums[index];
        }
        return false;
    }
    bool makesquare(vector<int>& nums) {
        int sum = accumulate(nums.begin(),nums.end(),0);
        if(sum%4!=0 || nums.size()==0) return false;
        vector<int> sides(4,0);
        sort(nums.begin(),nums.end(),[](int a,int b){return a>b;});
        return checkIfSquare(nums,0,sides,sum/4);
    }
};