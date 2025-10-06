class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites) == 0:
            return True
        
        # initialise an empty adjaceny graph
        adj = [[] for _ in range(numCourses)]

        for u, v in prerequisites:
            adj[v].append(u)
        
        visited = set()
        visiting = set()

        def dfs(u: int):
            visiting.add(u)
            for v in adj[u]:
                if v in visiting:
                    return False
                if v not in visited:
                    if not dfs(v):
                        return False
            
            visited.add(u)
            visiting.remove(u)
            return True

        for u in range(numCourses):
            if u not in visited:
                if not dfs(u):
                    return False
        return True