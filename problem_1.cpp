1088. Confusing Number II

Time complexity:
0(log n)

Space complexity:
O(1)


class Solution {
public:

    // converts decimal number to base 5 number
    string decimal_to_base5(int n)
    {
        string ans="";
        while(n)
        {
            ans+=n%5 +'0';
            n/=5;
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }

    // This converts base 5 number(digits: 0,1,2,3,4) to digits(0,1,6,8,9) respectively
    int base5_to_mybase(string s)
    {
        string ans="";

        for(int i=0;i<s.length();i++)
        {
            char ch= s[i];

            switch(ch)
            {
                case '0':
                ans.push_back('0');
                break;
                case '1':
                ans.push_back('1');
                break;
                case '2':
                ans.push_back('6');
                break;
                case '3':
                ans.push_back('8');
                break;
                case '4':
                ans.push_back('9');
                break;
            }
        }
        
        return stoi(ans);
    }


    // This function checks if number n is confusing number or not
    bool is_confusing(int n)
    {
        string s= to_string(n);
        string s2=s;
        reverse(s2.begin(),s2.end());
        string ans;

        for(int i=0;i<s2.length();i++)
        {
            char ch=s2[i];
            switch(ch)
            {
                case '0':
                ans.push_back('0');
                break;
                case '1':
                ans.push_back('1');
                break;
                case '6':
                ans.push_back('9');
                break;
                case '8':
                ans.push_back('8');
                break;
                case '9':
                ans.push_back('6');
                break;
            }
        }
        int n2= stoi(ans);
        return n!=n2;
    }

    
    int confusingNumberII(int n) {
        
        int i=1;
        int count=0;
        while(true)
        {
            int j= base5_to_mybase( decimal_to_base5(i) );
            if(j>n) break;
            if(is_confusing(j)) count++;
            i++;
        }
        return count;
        
    }
};
