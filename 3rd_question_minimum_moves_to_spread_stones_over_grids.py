class Solution:
    def __init__(self):
        self.ans = float('inf')

    def solve(self, i, count, zero, extra):
        #if we completely traversed the zero vector, that means we converted all the zero cells to non zero cells.
        #so update the ans with the minimum possible count
        if i >= len(zero):
            self.ans = min(self.ans, count)
            return
        for k in range(len(extra)):
            #if there are no more stones in that particular cell, then we cannot use anything, so we continue to next cell
            if extra[k][2] == 0:
                continue
            #decrement the value as we are using it
            extra[k][2] -= 1
            self.solve(i + 1, abs(extra[k][0] - zero[i][0]) + abs(extra[k][1] - zero[i][1]) + count, zero, extra)
            #backtracking by adding the used value
            extra[k][2] += 1

    def minimumMoves(self, grid):
        zero, extra = [], []
        for i in range(3):
            for j in range(3):
                if grid[i][j] == 0:
                    zero.append([i, j])
                elif grid[i][j] > 1:
                    #along with the coordinates, we store the number of stones that can be transferred from this cell
                    extra.append([i, j, grid[i][j] - 1])
        if len(zero) == 0:
            return 0
        self.ans = float('inf')
        self.solve(0, 0, zero, extra)
        return self.ans
