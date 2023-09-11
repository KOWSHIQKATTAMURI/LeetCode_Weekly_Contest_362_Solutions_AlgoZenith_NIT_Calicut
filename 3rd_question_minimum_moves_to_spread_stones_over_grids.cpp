class Solution {
public:
    int ans;
    void solve(int i, int count, vector<vector<int>>& zero, vector<vector<int>>& extra){
        //if we completely traversed the zero vector, that means we converted all the zero cells to non zero cells.
        //so update the ans with the minimum possible count
        if(i >= zero.size()){
            ans = min(ans, count);
            return;
        }
        for(int k = 0; k < extra.size(); k++){
            //if there are no more stones in that particular cell, then we cannot use anything, so we continue to next cell
            if(extra[k][2] == 0){
                continue;
            }
            //decrement the value as we are using it
            extra[k][2]--;
            solve(i + 1, abs(extra[k][0] - zero[i][0]) + abs(extra[k][1] - zero[i][1]) + count, zero, extra);
            //backtracking by adding the used value
            extra[k][2]++;
        }
    }
    int minimumMoves(vector<vector<int>>& grid){
        vector<vector<int>> zero, extra;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid[i][j] == 0){
                    zero.push_back({i, j});
                }else if(grid[i][j] > 1){
                    //along with the coordinates, we store the number of stones that can be transferred from this cell
                    extra.push_back({i, j, grid[i][j] - 1});
                }
            }
        }
        if(zero.size() == 0){
            return 0;
        }
        ans = INT_MAX;
        solve(0, 0, zero, extra);
        return ans;
    }
};
