// https://leetcode.com/problems/valid-parentheses/
/*20. Valid Parentheses
  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    
  An input string is valid if:
    1. Open brackets must be closed by the same type of brackets.
    2. Open brackets must be closed in the correct order.
    3. Every close bracket has a corresponding open bracket of the same type.

  Example 1:
    Input: s = "()"
    Output: true

  Example 2:
    Input: s = "()[]{}"
    Output: true

  Example 3:
    Input: s = "(]"
    Output: false

  Constraints:
    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.*/

class Solution {

  public boolean isValid(String s) {
    if (s.length() % 2 != 0) {
      return false;
    }
    for (int i = 0; i < s.length() - 1; i++) {
      char start = s.charAt(i);
      char end = s.charAt(s.length() - 1 - i);

      if (
        (start == '(' && end != ')') ||
        (start == '{' && end != '}') ||
        (start == '[' && end != ']')
      ) {
        return false;
      }
    }
    return true;
  }
}
/*class Solution {

  public boolean isValid(String s) {
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == '(' && s.charAt(i.length() - 1) == ')') {
        return true;
      } else if (s.charAt(i) == '{' && s.charAt(i.length() - 1) == '}') {
        return true;
      } else if (s.charAt(i) == '[' && s.charAt(i.length() - 1) == ']') {
        return true;
      }
    }
    return false;
  }
}*/
