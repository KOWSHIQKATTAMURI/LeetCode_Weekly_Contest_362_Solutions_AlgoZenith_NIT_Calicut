import java.util.*;

public class Solution {
    int ans;
    void solve(int i, int count, List<List<Integer>> zero, List<List<Integer>> extra){
        //if we completely traversed the zero vector, that means we converted all the zero cells to non zero cells.
        //so update the ans with the minimum possible count
        if(i >= zero.size()){
            ans = Math.min(ans, count);
            return;
        }
        for(int k = 0; k < extra.size(); k++){
            //if there are no more stones in that particular cell, then we cannot use anything, so we continue to next cell
            if(extra.get(k).get(2) == 0){
                continue;
            }
            //decrement the value as we are using it
            extra.get(k).set(2, extra.get(k).get(2) - 1);
            solve(i + 1, Math.abs(extra.get(k).get(0) - zero.get(i).get(0)) + Math.abs(extra.get(k).get(1) - zero.get(i).get(1)) + count, zero, extra);
            //backtracking by adding the used value
            extra.get(k).set(2, extra.get(k).get(2) + 1);
        }
    }
    int minimumMoves(List<List<Integer>> grid){
        List<List<Integer>> zero = new ArrayList<>(), extra = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(grid.get(i).get(j) == 0){
                    zero.add(Arrays.asList(i, j));
                }else if(grid.get(i).get(j) > 1){
                    //along with the coordinates, we store the number of stones that can be transferred from this cell
                    extra.add(Arrays.asList(i, j, grid.get(i).get(j) - 1));
                }
            }
        }
        if(zero.size() == 0){
            return 0;
        }
        ans = Integer.MAX_VALUE;
        solve(0, 0, zero, extra);
        return ans;
    }
}
