class Solution:
    hashMap = dict()
    count = 0
    confusing_nums = []
    def confusionNumber(self, n):
        self.hashMap = dict()
        self.count = 0
        self.confusing_nums = []
        self.hashMap[0] = 0
        self.hashMap[1] = 1
        self.hashMap[6] = 9
        self.hashMap[8] = 8
        self.hashMap[9] = 6
        #DFS to find the confusing number
        self.dfs(n, 0)
        print(self.count, sorted(self.confusing_nums))
        return self.count

    def dfs(self, N, curr):
        if curr > N:
            return

        if self.isValid(curr):
            self.confusing_nums.append(curr)
            self.count += 1

        for key in self.hashMap.keys():
            nexxt = curr * 10 + key
            if nexxt != 0:
                self.dfs(N, nexxt)
        return self.count

    def isValid(self, num):
        result = 0
        initial = num
        while num > 0:
            result = result * 10  + self.hashMap.get((num % 10))
            num = num // 10
        return initial != result

n = [20, 100, 1000]

if __name__ == "__main__":
    obj = Solution()
    for i in n:
        obj.confusionNumber(i)

# DFS
# Time Complexity :O(1)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


