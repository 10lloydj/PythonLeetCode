# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:

        if root is None:
            return None

        def switch(node: Optional[TreeNode]):
            if node is None:
                return
            temp = node.left
            node.left = node.right
            node.right = temp
            switch(node.left)
            switch(node.right)

        switch(root)
        return root