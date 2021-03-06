//Time - exponential
class Solution{
public:
    int confusingNumbers(int N){
        if(N==0) return 0;
        unordered_map<int,int> umap {{0,0},{1,1},{6,9},{8,8},{9,6}};
        queue<long> q;
        int cnt = 0;
        q.push(0);
        while(!q.empty()){
            long curr = q.front();q.pop();
            if(isValid(curr,umap)) cnt++;
            for(auto n:umap){
                long next = curr*10 + n.first;
                if(next<=N && next!=0){
                    q.push(next);
                }
            }
        }
        
        return cnt;
    }
    
    bool isValid(long num, unordered_map<int,int>& umap){
        long original = num;
        int result = 0;
        while(num>0){
            result = result*10 + umap[(int) num%10];
            num = num/10;
        }
        
        return original!=result;
    }
    
};

int main() {
    std::cout << "Hello World!\n";
    Solution sol;
    cout<<sol.confusingNumbers(10);
}
