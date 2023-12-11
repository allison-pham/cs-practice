// https://codingbat.com/prob/p111624
/*Return true if the string "cat" and "dog" appear the same number of times in the given string.

catDog("catdog") → true
catDog("catcat") → false
catDog("1cat1cadodog") → true*/

public boolean catDog(String str) {
    boolean same = false;
    // boolean cat = false;
    // boolean dog = false;
    int ctr1 = 0;
    int ctr2 = 0;
    for(int i = 0; i < str.length()-2; i++) {
      if(str.charAt(i) == 'c' && str.charAt(i+1) == 'a' && str.charAt(i+2) == 't') {
        // cat = true;
        ctr1++;
      }
      if(str.charAt(i) == 'd' && str.charAt(i+1) == 'o' && str.charAt(i+2) == 'g') {
        // dog = true;
        ctr2++;
     }
    }
    // if(cat == true && dog == true && ctr1 == ctr2) {
    if(ctr1 == ctr2) {
       same = true;
     }
    return same;
}  
