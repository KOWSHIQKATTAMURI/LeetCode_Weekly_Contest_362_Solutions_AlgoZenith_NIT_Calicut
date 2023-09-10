class Solution:
    def numberOfPoints(self, nums):
        # as the maximum value of the end point is 100, freq list of size 102 is taken so that 101th element can be accessed
        freq = [0]*102
        for i in range(len(nums)):
            # incrementing starting point
            freq[nums[i][0]] += 1
            # decrementing (ending point + 1)
            freq[nums[i][1] + 1] -= 1
        answer = 0
        for i in range(1, 102):
            # doing the prefix sum
            freq[i] += freq[i - 1]
            # if the particular element freq is greater than 0, then that means it is covered by some or the other car.
            if freq[i] > 0:
                answer += 1
        return answer
