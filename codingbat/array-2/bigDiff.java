// https://codingbat.com/prob/p196640
/*Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array. Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.

bigDiff([10, 3, 5, 6]) → 7
bigDiff([7, 2, 10, 9]) → 8
bigDiff([2, 10, 7, 2]) → 8*/

public int bigDiff(int[] nums) {
    int a = nums[0]; //Min
    int b = nums[0]; //Max
    
    for(int i = 1; i<nums.length; i++)
    {
      if(nums[i] < a)
        a = nums[i];
      
      else if(nums[i] > b)
        b = nums[i];
    }
    int subtract = b-a;
    return subtract;
}  