#o(n),0(n)

# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.moves=0
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.dfs(root)
        return self.moves
    def dfs(self,root):
        #base
        if not root:
            return 0
        #logic
        print(root.val)
        extra=root.val-1
        extra+=self.dfs(root.left)
        print("x",extra)
        extra+=self.dfs(root.right)
        print("y",extra)
        self.moves+=abs(extra)
        print(self.moves,extra)
        return extra
        
        
        