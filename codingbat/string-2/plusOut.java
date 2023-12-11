// https://codingbat.com/prob/p170829
/*Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.

plusOut("12xy34", "xy") → "++xy++"
plusOut("12xy34", "1") → "1+++++"
plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"*/

public String plusOut(String str, String word) {
    int s = str.length();
    int w = word.length();
    String x = "";
    
    for (int i = 0; i < s; i++) {
      if (i <= s - w) {
        String temp = str.substring(i, i+w);
        if (temp.equals(word)) {
          i+=w-1;
          x+=word;
        }
        else {
          x+="+";
        }
      }
      else {
        x+="+";
        
      }
    }
    return x;
}