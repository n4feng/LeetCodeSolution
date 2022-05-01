# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def findRootInOrderIndex(rootVal):
            rootIndexInOrder = 0
            for i in inorder:
                if i == rootVal:
                    break
                rootIndexInOrder+=1
            return rootIndexInOrder
        def array_to_tree(rootPreorder, rootInorder, leftInorder, rightInorder):
            root = TreeNode(preorder[rootPreorder])
            if leftInorder == rootInorder:
                root.left = None
            elif leftInorder == rootInorder-1:
                root.left = TreeNode(inorder[leftInorder])
            else:                
                root.left = array_to_tree(rootPreorder+1, findRootInOrderIndex(preorder[rootPreorder+1]), leftInorder, rootInorder-1)
            
                
            if rightInorder == rootInorder:
                root.right = None
            elif rightInorder == rootInorder+1:
                root.right = TreeNode(inorder[rightInorder])
            else:
                rightRootPreorderIndex = rootPreorder+rootInorder-leftInorder+1
                root.right = array_to_tree(rightRootPreorderIndex, findRootInOrderIndex(preorder[rightRootPreorderIndex]), rootInorder+1, rightInorder)
            return root
            

        return array_to_tree(0, findRootInOrderIndex(preorder[0]), 0, len(inorder)-1)
