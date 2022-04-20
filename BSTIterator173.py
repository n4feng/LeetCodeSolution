# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    
    def __init__(self, root: Optional[TreeNode]):
        self.ptr = root
        #stack solution so the space complexity reduce to O(h)
        #where h is the height of tree
        self.stack = []
        while self.ptr:
            self.stack.append(self.ptr)
            self.ptr = self.ptr.left

    def next(self) -> int:
        if self.ptr:
            self.ptr = self.ptr.right
            if self.ptr:
                while self.ptr:
                    if self.ptr.left:
                        self.stack.append(self.ptr)
                        self.ptr = self.ptr.left
                    else:
                        return self.ptr.val
            else:
                self.ptr = self.stack.pop()
                return self.ptr.val
        else:
            self.ptr = self.stack.pop()
            return self.ptr.val

    def hasNext(self) -> bool:
        if len(self.stack) != 0 or self.ptr.right:
            return True
        else:
            return False

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
