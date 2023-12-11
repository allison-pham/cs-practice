// https://codingbat.com/prob/p122943
/*Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.

oneTwo("abc") → "bca"
oneTwo("tca") → "cat"
oneTwo("tcagdo") → "catdog"*/

public String oneTwo(String str) {
    String output = "";
    for(int i = 0; i < str.length()-2; i++) {
      if(i % 3 == 0) {
      output+=str.substring(i+1, i+3) + str.charAt(i);
      }
    }
    return output;
}