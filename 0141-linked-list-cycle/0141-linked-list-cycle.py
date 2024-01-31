# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        hl = []
        hl.append(head)
        while head:
            if head.next not in hl:
                head = head.next
                hl.append(head)
            else:
                return True
        return False