class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()
        rows, cols = len(grid), len(grid[0])
        ans = 0
        
        def dfs(r, c):
            if ((r,c) in visited or
            r not in range(rows) or
            c not in range(cols) or
            grid[r][c] == "0"):
                return
            visited.add((r,c))
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
            
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1" and (r,c) not in visited:
                    ans += 1
                    dfs(r, c)
        return ans
                    