// https://codingbat.com/prob/p127384
/*Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do not count.

sum13([1, 2, 2, 1]) → 6
sum13([1, 1]) → 2
sum13([1, 2, 2, 1, 13]) → 6*/

public int sum13(int[] nums) {
    int sum = 0;
  
    for(int i = 0; i<nums.length; i++)
    {
      if(nums[i] != 13)
      {
        sum = sum + nums[i];
      }
      
      //Write code for if 13 shows up twice
      //If nums[i] == 13, it will stop if there isn't a code there
      else if(nums[i] == 13)
      {
        i++;
      }
    }
    return sum;
}