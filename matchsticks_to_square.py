class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:

        ## T.C = exponential
        ## S.C = O(n)

        sm = sum(matchsticks)
        if sm % 4 != 0:
            return False
        
        mx_len = sm//4
        sides = [0,0,0,0]
        matchsticks.sort(reverse=True)

        def backtrack(matchsticks, idx, mx_len, sides):
            if idx == len(matchsticks):
                if sides[0] == mx_len and sides[1] == mx_len and sides[2] == mx_len:
                    return True
                return False

            ## logic
            for i in range(4):
                if sides[i] + matchsticks[idx] <= mx_len:
                    ## action
                    sides[i] = sides[i] + matchsticks[idx]
                    ## recurse
                    if backtrack(matchsticks, idx + 1, mx_len, sides):
                        return True
                    ##backtrack
                    sides[i] = sides[i] - matchsticks[idx]
            
            return False
        
        return backtrack(matchsticks, 0, mx_len, sides)
