// https://codingbat.com/prob/p104627
/*Given an array of ints, return true if the number of 1's is greater than the number of 4's

more14([1, 4, 1]) → true
more14([1, 4, 1, 4]) → false
more14([1, 1]) → true*/

public boolean more14(int[] nums) {
    int one = 0; //Counts 1s
    int four = 0; //Counts 4s
    
    for(int i = 0; i<nums.length; i++)
    {
      if(nums[i] == 1)
      {
        one++;
      }
      
      if(nums[i] == 4)
      {
        four++;
      }
    }
    
    if(one > four)
    {
      return true;
    }
    return false;
}  