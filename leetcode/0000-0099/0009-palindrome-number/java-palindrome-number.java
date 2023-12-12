// https://leetcode.com/problems/palindrome-number/description/
/*Given an integer x, return true if x is a palindrome, and false otherwise.
    Example 1:
    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.

    Example 2:
    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    Example 3:
    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.*/

class Solution {

  public boolean isPalindrome(int x) {
    String original = Integer.toString(x);

    for (int i = 0; i < original.length() / 2; i++) {
      if (original.charAt(i) != original.charAt(original.length() - 1 - i)) {
        return false;
      }
    }

    return true;
  }
}
// for (int i = 0, j = original.length() - 1; i < j; i++, j--) {
/*int i = x;
    int reverse = 0;

    while (i > 0) {
      int last_num = i % 10;
      reverse *= 10 + last_num
      i /= 10;
    }

    return original == reversed;*/
