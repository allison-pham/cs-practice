// https://codingbat.com/prob/p191878
/*Given an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both.

either24([1, 2, 2]) → true
either24([4, 4, 1]) → true
either24([4, 4, 1, 2, 2]) → false*/

public boolean either24(int[] nums) {
    boolean two = false;
    boolean four = false;
    boolean both = false;
    
    for(int i = 0; i<nums.length-1; i++)
    {
       if(nums[i] == 2 && nums[i+1] == 2)
      {
        two = true;
        both = true;
      }
      
      if(nums[i] == 4 && nums[i+1] == 4)
      {
        four = true;
        both = true;
      }
      
    }
    
    if(two == true && four == true)
    {
      both = false;
    }
    
    return both;
}