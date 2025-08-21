"""
TimeComplexity:O(logn)
SpaceCompelxity:O(1)
This can be done with normal bfs dfs , bfs, dfs + BST property
its important in both iterative and recursive methods
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        """Iterative preorder root left and right"""
        st=[]
        ans=0
        while(len(st) or root):
            
            while(root):
                
                st.append(root)
                root=root.left
            val=st.pop()
            
            if low<=val.val<=high:
                ans+=val.val
            if val.right:
                root=val.right
                
        return ans



class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        def dfs(node):
            if not node:
                return 0
            
            current_val = 0
            if low <= node.val <= high:
                current_val = node.val
            
            left_sum = dfs(node.left)
            right_sum = dfs(node.right)
            
            return current_val + left_sum + right_sum
        
        return dfs(root)
