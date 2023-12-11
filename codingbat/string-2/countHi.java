// https://codingbat.com/prob/p147448
/*Return the number of times that the string "hi" appears anywhere in the given string.

countHi("abc hi ho") → 1
countHi("ABChi hi") → 2
countHi("hihi") → 2s*/

public int countHi(String str) {
    int ctr = 0;
    
    for(int i = 0; i < str.length()-1; i++) {
      if(str.charAt(i) == 'h' && str.charAt(i+1) == 'i') {
        ctr++;
      }
    }
    
    return ctr;
}  