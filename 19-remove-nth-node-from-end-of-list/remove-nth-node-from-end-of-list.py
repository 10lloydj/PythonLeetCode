# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        # iterate through the linked list and store each node in a stack

        # till you reach the end
        
        # once you've found the end pop off the nodes n times but store either side of the removed node to link it
        stack = []
        current = head
        while current is not None:
            stack.append(current)
            current = current.next

        if len(stack) == n:
            return head.next

        if n == 1:
            if len(stack) > 1:
                stack.pop()
                last = stack.pop()
                last.next = None
            return head

        for i in range(0, n - 2):
            stack.pop()

        right = stack.pop()

        stack.pop()

        left = stack.pop()

        left.next = right

        return head