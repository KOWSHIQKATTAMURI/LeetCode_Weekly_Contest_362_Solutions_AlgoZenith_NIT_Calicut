class Solution {
public:
    int numberOfPoints(vector<vector<int>>& nums){
        //as the maximum value of the end point is 100, freq vector of size 102 is taken so that 101th element can be accessed
        vector<int> freq(102, 0);
        for(int i = 0; i < nums.size(); i++){
            //incrementing starting point
            freq[nums[i][0]]++;
            //decrementing (ending point + 1)
            freq[nums[i][1] + 1]--;
        }
        int answer = 0;
        for(int i = 1; i < 102; i++){
            //doing the prefix sum
            freq[i] += freq[i - 1];
            //if the particular element freq is greater than 0, then that means it is covered by some or the other car.
            if(freq[i] > 0){
                answer++;
            }
        }
        return answer;
    }
};
