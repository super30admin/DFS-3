class Solution:
    def confusingNumberII(self, n: int) -> int:

        ## T.C = O(5^l)
        ## S.C = O(l)

        hm = {0:0, 1:1, 6:9, 8:8, 9:6}
        count = 0

        def isConfusing(curr_num):
            x = curr_num
            reverse = 0
            while curr_num > 0:
                rem = curr_num % 10
                reverse = reverse*10 + hm[rem]
                curr_num = curr_num // 10
            return reverse != x

        def dfs(curr_num):
            nonlocal count

            if curr_num > n:
                return
            if isConfusing(curr_num):
                count += 1
            
            for key in hm.keys():
                new_num = curr_num*10 + key
                if new_num != 0:
                    dfs(new_num)

        dfs(0)
        return count