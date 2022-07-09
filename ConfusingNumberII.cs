using System;
using System.Collections.Generic;
using System.Text;

namespace DFS_And_BFS
{
    public class ConfusingNumberII
    {
        /*
         * T.C:  5 raise to power L where L is number of digits in n
         *
         */
        int count;
        Dictionary<int, int> map;
        public int ConfusingNumer(int n)
        {
            if (n == 0) return 0;

            map = new Dictionary<int, int>();
            map.Add(0, 0);
            map.Add(1, 1);
            map.Add(6, 9);
            map.Add(8, 8);
            map.Add(9, 6);

            dfs(n, 0);
            
            return count;
        }

        public void dfs(int n, int curr)
        {
            //base
            if(curr > n)
            {
                return;
            }

            //logic
            if(isValidConfisingNumber(curr))
            {
                count++;
            }
            foreach(int key in map.Keys)
            {
                int newCurr = curr * 10 + key;

                if(newCurr != 0)
                {
                    dfs(n, newCurr);
                }
            }
        }

        private bool isValidConfisingNumber(int num)
        {
            int OrgNum = num;
            int reverseNum = 0;

            while(num > 0)
            {
                reverseNum = reverseNum * 10 + map[num % 10];
                num = num / 10;
            }

            return OrgNum == reverseNum;
        }

    }
}
