// https://codingbat.com/prob/p159772
/*Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.

xyzMiddle("AAxyzBB") → true
xyzMiddle("AxyzBB") → true
xyzMiddle("AxyzBBB") → false*/

public boolean xyzMiddle(String str) {
    //indexOf returns -1 if val not  found
    if (str.indexOf("xyz") < 0) {
      return false;
    }
    int temp = str.length();
    int temp2 = temp / 2;
  
    if(temp % 2 != 0) { //Get outer parts
      if(!(str.substring((temp2 - 1), temp2 + 2).equals("xyz"))) {
        return false;
      }
    }
    
    else {
      if(str.charAt(temp2) != 'y' && str.charAt(temp2 - 1) != 'y') {
        return false;
      }
    }
    return true;
}  