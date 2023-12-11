// https://codingbat.com/prob/p134250
/*We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.

xyBalance("aaxbby") → true
xyBalance("aaxbb") → false
xyBalance("yaaxbb") → false*/

public boolean xyBalance(String str) {
    //return true if y is after x chars
    boolean check = true;
    int temp = 0;
    
    while(temp < str.length()) {
      if(str.charAt(temp)=='x') {
        for(int i = temp; i < str.length(); i++) {
          if(str.charAt(i) == 'y') {
            check = true;
            break;
          }
          else {
            check =false;
          }
        }
      }
      temp++;
    }
    return check;
    
      /*int ctr = 1;
      char temp1 = str.charAt(i);
      char temp2 = str.charAt(i+ctr);
      if(temp1 == 'x' && temp2 == 'y') {
        return true;
      }
      ctr++;
    }
    return false;*/
    
    /*boolean temp = false;
    for(int i = 0; i < str.length()-1; i++) {
      if(str.charAt(i) == 'y') {
        temp = true;
      }
      if(str.charAt(i) == 'x' && str.charAt(i) != 'y') {
        temp = false;
      }
    }
    return temp;*/
}