class Solution:
    def confusingNumberII(self, n: int) -> int:
        #Method 1 - Check if each number within range is confusing -> Brute force

        #Method 2 - DFS by geenrating numbers from 0,1,6,8,9 instead of checking each number in the given range.
        #Since, we know only 0,1,6,8,9 can cause cosufing numebrs -> map them with thier rotates.
        confusing_pairs = {0: 0, 1: 1, 6: 9, 8: 8, 9: 6}
        count=0
        def isconfusingnum(num):
            temp=num
            res=0
            while num>0:
                digit=num%10
                res=res*10+confusing_pairs[digit]
                num=num//10
            return res!=temp #if result is same as current num-> false else True

        def dfs(currnum,n):
            nonlocal count
            #base
            if currnum>n: return #when we go out of range->return

            #logic
            if isconfusingnum(currnum): 
                count+=1
            for k in confusing_pairs.keys(): #use each key (0,1,6,8,9) and generate the new number in the next level of the tree and dfs.
                newnum=currnum*10+k
                if newnum != 0: dfs(newnum, n)        
        dfs(0,n)
        return count
