/*
if N-> number of digits
// Time Complexity : O(5^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/
#include<iostream>
#include<vector>

using namespace std;

class Solution {
    vector<int> nums{0,1,6,8,9};
    //vector<int> sol{};
    int count{};
    long int gen{};
    long int number{};
    bool con(long int n){
        vector<int> arr{0,1,-1,-1,-1,-1,9,-1,8,6}; // hash map
        long int act_num{n};
        long int rev_num{};
        while(n!=0){
            int idx = n%10;
            if(arr.at(idx)==-1) return false;
            rev_num = rev_num * 10 + arr.at(idx);
            n = n/10;
        }
        if(act_num == rev_num) return false;
        return true;
    }
    void foo(long int gen){

        if(gen!=0 && con(gen)) {
            //sol.push_back(gen);
            count++;
        }

        for(int i{0};i<nums.size();++i){
            gen = gen*10 + nums.at(i);
            if(gen>0 && gen<=number){
                foo(gen);
                gen = (gen-nums.at(i))/10;
            }
        }

    }
    void display(vector<int>& sol){
        for(int sols:sol){
            cout<<sols<<" ";
        }
        cout<<endl;
    }
public:
    int confusingNumberII(int n) {
        //first to compare number
        //vector size
        //to generate number
        this->number = n;
        foo(gen);
        //display(sol);
        return count;

    }
};