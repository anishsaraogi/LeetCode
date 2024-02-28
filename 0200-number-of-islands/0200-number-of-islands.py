class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()
        ans = 0
        
        def dfs(r, c):
            if ((r,c) in visited or
            r not in range(len(grid)) or
            c not in range(len(grid[0])) or
            grid[r][c] == "0"):
                return
            visited.add((r,c))
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
            
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == "1" and (r,c) not in visited:
                    ans += 1
                    dfs(r, c)
        return ans
                    