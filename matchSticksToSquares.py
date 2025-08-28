class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        #lets try recursive first and then memo it
        #all sides will be sum(array) // 4
        sums = sum(matchsticks)
        matchsticks.sort(reverse=True)
        if sums % 4 != 0:
            return False

        target = sums//4

        buckets = [0 for i in range(4)]
        n = len(matchsticks)
        def helper(index):
            if index == n:
                for i in range(4):
                    if buckets[i] != target:
                        return False
                return True

            for i in range(4):
                if matchsticks[index] + buckets[i] > target:
                    continue

                buckets[i] += matchsticks[index]
                if helper(index + 1):
                    return True
                buckets[i] -= matchsticks[index]
            return False
        return helper(0)

            
        