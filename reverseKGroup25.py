# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        ptr = res = head
        firstSwap = True
        ahead = ptr
        #check if remain length >= k
        for i in range(k):
            if ahead:
                ahead = ahead.next
            else:
                return res
        #do the actual switch
        toReverse1 = lasttail = ptr
        toReverse2 = ptr.next
        for i in range(k-1):
            tmp = toReverse2.next
            toReverse2.next = toReverse1
            toReverse1 = toReverse2
            toReverse2 = tmp
            if i == k-2:
                if firstSwap:
                    res = toReverse1
                    firstSwap = not firstSwap
        ptr.next = self.reverseKGroup(toReverse2, k)
        return res
