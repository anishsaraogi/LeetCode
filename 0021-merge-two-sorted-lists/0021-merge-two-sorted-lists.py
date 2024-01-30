# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1 and not list2: return None
        if not list1: return list2
        if not list2: return list1
        curr1 = list1
        curr2 = list2
        if curr1.val < curr2.val:
            newlist = curr1
            curr1 = curr1.next
        else:
            newlist = curr2
            curr2 = curr2.next
        head = newlist
        while curr1 or curr2:
            if curr1 and curr2:
                if curr1.val < curr2.val:
                    newlist.next = curr1
                    curr1 = curr1.next
                    newlist = newlist.next
                else:
                    newlist.next = curr2
                    curr2 = curr2.next
                    newlist = newlist.next
            else:
                if not curr1:
                    while curr2:
                        newlist.next = curr2
                        curr2 = curr2.next
                        newlist = newlist.next
                else:
                    while curr1:
                        newlist.next = curr1
                        curr1 = curr1.next
                        newlist = newlist.next
        return head