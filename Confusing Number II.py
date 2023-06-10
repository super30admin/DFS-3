class Solution:
    def confusingNumberII(self, n: int) -> int:
        global count
        count = 0
        def confusing(num):
            res = 0
            temp = num
            while num > 0:
                currdigit = int(num %10)
                res = res * 10 + hmap[currdigit]
                num = num //10
            return res != temp
            return False
        def dfs(num, n):
            # print(num)
            global count
            # Base Case
            if num > n: return
            if confusing(num): 
                # print(num, "is confusing")
                count += 1
            for i in hmap.keys():
                newnum = num * 10 + hmap[i]
                if newnum != 0: dfs(newnum, n)

        hmap = {}
        hmap[0] = 0
        hmap[1] = 1
        hmap[6] = 9
        hmap[8] = 8
        hmap[9] = 6
        dfs(0, n)
        return count
