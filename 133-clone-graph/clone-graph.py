"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return None
        visited = {}

        def depthFirstTrav(current: 'Node') -> 'Node':
            if current in visited:
                return visited[current]

            cloned_node = Node(current.val)
            visited[current] = cloned_node

            for n in current.neighbors:
                clone_n = depthFirstTrav(n)
                cloned_node.neighbors.append(clone_n)
            
            return cloned_node
        
        return depthFirstTrav(node)