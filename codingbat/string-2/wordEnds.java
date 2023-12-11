// https://codingbat.com/prob/p147538
/*Given a string and a non-empty word string, return a string made of each char just before and just after every appearance of the word in the string. Ignore cases where there is no char before or after the word, and a char may be included twice if it is between two words.

wordEnds("abcXY123XYijk", "XY") → "c13i"
wordEnds("XY123XY", "XY") → "13"
wordEnds("XY1XY", "XY") → "11"*/

public String wordEnds(String str, String word) {
    int s = str.length();
    int w = word.length();
    String x = "";
    
    for(int i = 0; i < s-w+1; i++) { 
      String temp = str.substring(i, i+w);
      if(i > 0 && temp.equals(word)) {
        x+=str.substring(i-1, i);
      }
      if(i < s-w && temp.equals(word)) {
        x+=str.substring(i+w, i+w+1);
      }
    }
    return x;
}