#  Sequence Checker Problem

# For this mock interview, you will go through four phases: Prompt, Plan, Code, & Test.
# Prompt: Understand the problem.
# Plan: Outline your approach.
# Code: Implement your solution.
# Test: Verify your solution works.

# Here is the problem that you will be solving:
# Consider two textual sequences represented by strings 's' and 't'.
# Your task is to ascertain whether 's' can be derived from 't' through the omission of some characters, without altering the sequential order of the remaining characters.
# In other words, determine if 's' stands as a subsequence of 't'.
# The term 'subsequence' signifies a sequence that can be derived from another sequence by deleting certain elements without changing the order of the remaining elements.

# Example 1:
# Input: s = "abc", t = "ahbgdc"
# Output: true
# Explanation: By removing 'h', 'b', 'g', and 'd' from "ahbgdc", the string "abc" is obtained, which maintains the relative positioning, hence 's' is a subsequence of 't'.

# Example 2:
# Input: s = "axc", t = "ahbgdc"
# Output: false
# Explanation: There's no way to obtain "axc" from "ahbgdc" while preserving the original order, indicating 's' is not a subsequence of 't'.
# Constraints:
# The length of 's' falls within the range of 0 to 100.
# The length of 't' is at most 10^4.
# Both 's' and 't' contain only lowercase English letters.

# Constraints:
# The length of 's' falls within the range of 0 to 100.
# The length of 't' is at most 10^4.
# Both 's' and 't' contain only lowercase English letters.
def checkSubsequence(s, t):
    # Write your plan below
    # Have pointers - s_pointer, t_pointer
    # Use iteration for t
    # For each char in t -> does it match the current char in s?
    # If yes, move s_pointer to next char in s
    # Move pointer_t to next char in t
    # If pointer_s reaches the end of s
    # If all characters of s appear in t in the same order -> return true (if it reaches the end of s)

    # Write your code below
    s_pointer = 0
    t_pointer = 0

    while t_pointer < len(t) and s_pointer < len(s):
        if s[s_pointer] == t[t_pointer]:
            s_pointer += 1
        t_pointer += 1

    return s_pointer == len(s)
