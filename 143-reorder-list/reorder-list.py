# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        stack = deque()
        if head.next == None:
            return head
        current = head
        while current is not None:
            stack.append(current)
            current = current.next

        while len(stack) > 1:
            current = stack.popleft()
            temp = current.next
            if stack:
                current.next = stack.pop()
                current = current.next
            current.next = temp
        if stack:
            current.next = stack.pop()
            current.next.next = None
        else:
            current.next = None
        return head

