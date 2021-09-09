class Solution:
    def confusingNumberII(self, N: int) -> int:
        mappings = {0:0, 1:1, 6:9, 8:8, 9:6}
        res = 0
        def dfs(value, rotatedValue, power):
            nonlocal res
            if value > N: return
            if value != rotatedValue: 
                res += 1
            for v in [0, 1, 6, 8, 9]:
                dfs(value*10+v, rotatedValue+power*mappings[v], 10*power)

        dfs(1, 1, 10)
        dfs(6, 9, 10)
        dfs(8, 8, 10)
        dfs(9, 6, 10)
        return res

TC : O(k)
SC : O(1)