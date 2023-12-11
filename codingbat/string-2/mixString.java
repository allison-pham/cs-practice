// https://codingbat.com/prob/p125185
/*Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char of a, the second char of b, and so on. Any leftover chars go at the end of the result.

mixString("abc", "xyz") → "axbycz"
mixString("Hi", "There") → "HTihere"
mixString("xxxx", "There") → "xTxhxexre"*/

public String mixString(String a, String b) {
    String combined = "";
    int x = 0;
    while(x < a.length() || x < b.length()) {
      if(x < a.length()) {
        combined+=a.substring(x, x + 1);
      }
      if(x < b.length()) {
        combined+=b.substring(x, x + 1);
      }
      x++;
    }
    return combined;
    
    /*int ctr1 = 0;
    int ctr2 = 0;
    for(int i = 0; i < a.length(); i++) {
      // combined+=a.substring(i) + b.substring(i);
      if(i % 2 == 0) {
        combined+=a.substring(ctr1);
        ctr1++;
      }
      if(i % 2 == 1) {
        combined+=b.substring(ctr2);
        ctr2++;
      }
    }
    return combined;*/
}  