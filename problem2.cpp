/*
// Time Complexity : Exponential
// Space Complexity : O(N) size of the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
    int max_size;
    int arr_size;
    vector<int> res{};
    bool flag{false};
    void display(const vector<int>& v1){
        for(const int& v:v1){
            cout<<v<<"\t";
        }
        cout<<endl;
    }
    void dfs(int idx,vector<int>& matchsticks){
        if(flag) return;
        if(idx == matchsticks.size()){
            //display(res);
            for(int i{};i<arr_size-1;++i){
                if(res.at(i)!=res.at(i+1)){
                    return;
                }
            }
            flag = true;
            return;
        }
        for(int i{};i<arr_size;++i){
            //action
            if(res.at(i)+matchsticks.at(idx)<=max_size){
                res.at(i) = res.at(i) + matchsticks.at(idx);
                //recurse
                dfs(idx+1,matchsticks);
                //backtrack
                res.at(i)= res.at(i) - matchsticks.at(idx);
            }
            
        }
    }
public:
    bool makesquare(vector<int>& matchsticks) {
        sort(matchsticks.begin(),matchsticks.end());
        reverse(matchsticks.begin(),matchsticks.end());
        arr_size = 4;
        res.resize(arr_size,0);
        int sum{};
        for(int i{};i<matchsticks.size();++i){
            sum+=matchsticks.at(i);
        }
        if(sum%4!=0) return false;
        max_size = sum/4;
        int idx{};
        dfs(0,matchsticks);
        return flag;
    }
};