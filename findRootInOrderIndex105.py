# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        return self.arrayToTree(0, self.findValIndex(preorder[0], inorder), 0, len(inorder)-1, preorder, inorder)
        
    def arrayToTree(self, rootPreIndex, rootInIndex, leftInIndex, rightInIndex, preorder, inorder):
        root = TreeNode(preorder[rootPreIndex])
        leftSubSize = 0
        if rootInIndex > leftInIndex:
            leftSubSize = rootInIndex - leftInIndex
            root.left = self.arrayToTree(rootPreIndex+1, self.findValIndex(preorder[rootPreIndex+1], inorder), leftInIndex, rootInIndex-1, preorder, inorder)
        if rootInIndex < rightInIndex:
            root.right = self.arrayToTree(rootPreIndex+leftSubSize+1, self.findValIndex(preorder[rootPreIndex+leftSubSize+1], inorder), rootInIndex+1, rightInIndex, preorder, inorder)
        return root
        
    def findValIndex(self, val, order):
        for i in range(len(order)):
            if val == order[i]:
                return i
        return -1
                
        
