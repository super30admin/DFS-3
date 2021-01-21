"""
Time Complexity : O(5^digits in n) for DFS
Space Complexity : O(1) for DFS and 0(confusing numbers) for BFS as using a queue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

I have done both BFS and DFS solution here. For them, as only certain numbers qualify for making a confusing number,we would only 
start with them. For DFS, we would recursively make a number and check if it is valid or not. For DFS, we would keep putting
numbers inside the queue and make confusing numbers from them.
"""


class Solution:
    def confusingNumberII(self, N: int) -> int:
        digits = [0, 1, 6, 8, 9]
        q = collections.deque([1, 6, 8, 9])
        res = 0
        while q and q[0] <= N:
            curr = q.popleft()
            if self.isValid(curr):
                res += 1
            for d in digits:
                q.append(curr*10 + d)
        return res

    def isValid(self, n: int) -> bool:

        hashmap = {'0': '0', '1': '1', '6': '9', '9': '6', '8': '8'}
        S = str(n)
        for i in range(len(S)):
            if S[i] != hashmap[S[-i-1]]:
                return True
        return False


# class Solution:
#     def confusingNumberII(self, N: int) -> int:
#         self.hashmap={0:0,1:1,6:9,8:8,9:6}
#         self.count=0
#         self.dfs(N,0)
#         return self.count

#     def dfs(self,N,curr):

#         if self.isValid(curr):
#             self.count+=1
#         for key in self.hashmap.keys():
#             nextVal=curr*10+key
#             if nextVal<=N and nextVal!=0:
#                 self.dfs(N,nextVal)

#     def isValid(self,number):
#         result=0
#         source=number
#         while number>0:
#             rem=number%10
#             result = result*10 + self.hashmap[rem]
#             number//=10
#         return source!=result
