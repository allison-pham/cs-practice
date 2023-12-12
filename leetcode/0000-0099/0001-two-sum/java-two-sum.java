// https://leetcode.com/problems/two-sum/
/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/

class Solution {

  public int[] twoSum(int[] nums, int target) {
    // Use for loop to check numbers that can add up to 'target'

    for (int i = 0; i < nums.length - 1; i++) {
      for (int k = i + 1; k < nums.length; k++) {
        if (nums[i] + nums[k] == target) {
          return new int[] { i, k };
        }
      }
    }

    return new int[] { -1, -1 };
  }
}
