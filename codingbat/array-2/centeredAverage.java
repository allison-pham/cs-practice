// https://codingbat.com/prob/p136585
/*Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring the largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more.

centeredAverage([1, 2, 3, 4, 100]) → 3
centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
centeredAverage([-10, -4, -2, -4, -2, 0]) → -3*/

public int centeredAverage(int[] nums) {
    int smallest = nums[0];
    int largest = nums[0];
    int total = 0;
    int avg = 0; //Return
    
    for(int i = 0; i<nums.length; i++)
    {
       total = total + nums[i];
       
       //Reassign largest & smallest to a value b/c it needs a value to subtract
       if(nums[i] < smallest)
       {
         smallest = nums[i];
       }
       else if(nums[i] > largest)
       {
         largest = nums[i];
       }
    }
    
    avg = (total - (smallest + largest)) / (nums.length - 2);
    
    //Divide to find the avg
    //Subtract 2 from nums.length b/c disregarding smallest & largest values
    return avg;
}