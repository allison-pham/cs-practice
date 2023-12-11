// https://codingbat.com/prob/p124620
/*Given an array of strings, return the count of the number of strings with the given length.

wordsCount(["a", "bb", "b", "ccc"], 1) → 2
wordsCount(["a", "bb", "b", "ccc"], 3) → 1
wordsCount(["a", "bb", "b", "ccc"], 4) → 0*/

public int wordsCount(String[] words, int len) {
    int ctr = 0;
    for(int i = 0; i < words.length; i++) {
      if(words[i].length() == len) {
        ctr++;
      }
    }
    return ctr;
}  