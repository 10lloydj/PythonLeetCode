# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        prev = head.next
        head.next = None

        def reverse(current: ListNode, next: Optional[ListNode()]) -> ListNode:
            if next is None:
                return current
            # temp is the new next in the recursion.
            temp = next.next
            next.next = current

            return reverse(next, temp)

        return reverse(head, prev)
