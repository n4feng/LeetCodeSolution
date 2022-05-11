# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.flattenAndReturnEnd(root)
    def flattenAndReturnEnd(self, root):
        if not root:
            return None
        left_end = self.flattenAndReturnEnd(root.left)
        right_end = self.flattenAndReturnEnd(root.right)
        if root.left:
            left_end.right = root.right
            root.right = root.left
            root.left = None

        while root.right:
            root = root.right
        return root
        
