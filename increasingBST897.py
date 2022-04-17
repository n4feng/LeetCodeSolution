# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def increasingBST(self, root: TreeNode) -> TreeNode:
        inOrder = []
        
        def dfsOrder(root):
            if root:
                dfsOrder(root.left)
                inOrder.append(TreeNode(root.val))
                dfsOrder(root.right)
        
        dfsOrder(root)
        res = inOrder[0]
        ptr = res
        for n in range(1,len(inOrder)):
            ptr.right = inOrder[n]
            ptr = ptr.right
        
        return res
            
