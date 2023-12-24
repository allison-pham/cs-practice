// https://leetcode.com/problems/longest-common-prefix/description/
/*14. Longest Common Prefix
  Write a function to find the longest common prefix string amongst an array of strings.
  If there is no common prefix, return an empty string "".

  Example 1:
  Input: strs = ["flower","flow","flight"]
  Output: "fl"

  Example 2:
  Input: strs = ["dog","racecar","car"]
  Output: ""
  Explanation: There is no common prefix among the input strings.*/

class Solution {

  public String longestCommonPrefix(String[] strs) {
    // String prefix = ""; // In common

    if (strs == null || strs.length == 0) {
      return "";
    }

    for (int i = 0; i < strs[0].length(); i++) {
      char currentChar = strs[0].charAt(i);

      for (int k = 1; k < strs.length; k++) {
        if (i == strs[k].length() || strs[k].charAt(i) != currentChar) {
          return strs[0].substring(0, i);
        }
        // prefix += strs[i].charAt(i);
        // prefix += currentChar;
      }
    }

    return strs[0];
  }
}
