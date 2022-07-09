using System;
using System.Collections.Generic;
using System.Text;

namespace DFS_And_BFS
{
    public class MatchsticksSquare
    {
        /*
         * T.C: O(4 power of N) where n is no of sticks in match stick array
         * S.C: O(n) 
         */
        public bool Makesquare(int[] matchsticks)
        {
            if (matchsticks == null || matchsticks.Length == 0) return false;

            int sum = 0;
            foreach (int num in matchsticks)
            {
                sum += num;
            }

            if (sum % 4 != 0)
            {
                return false;
            }

            int side = sum / 4;

            Array.Sort(matchsticks);
            Array.Reverse(matchsticks);

            return backtracking(matchsticks, side, new int[4], 0);
        }

        private bool backtracking(int[] matchsticks, int side, int[] arr, int index)
        {
            //base
            if (index == matchsticks.Length)
            {
                if (arr[0] == side && arr[1] == side && arr[2] == side && arr[3] == side)
                {
                    return true;
                }
                return false;
            }

            //logic
            for (int i = 0; i < 4; i++)
            {
                if (matchsticks[index] + arr[i] <= side)
                {
                    arr[i] = arr[i] + matchsticks[index];

                    if (backtracking(matchsticks, side, arr, index + 1))
                    {
                        return true;
                    }

                    arr[i] = arr[i] - matchsticks[index];
                }
            }

            return false;
        }
    }
}
