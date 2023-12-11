// https://codingbat.com/prob/p136594
/*Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.

xyzThere("abcxyz") → true
xyzThere("abc.xyz") → false
xyzThere("xyz.abc") → true*/

public boolean xyzThere(String str) {
    if(str.length() >= 3 && str.substring(0, 3).equals("xyz")) {
        return true;
    }
    
    for(int i = 1; i <= str.length() - 3; i++) {
      if(str.charAt(i-1) != '.' && str.substring(i, i+3).equals("xyz")) {
        return true;
      }
    }
    return false;
      
    /*boolean xyz=false;
    for(int i=1; i<str.length()-2; i++) {
      String word=str.substring(i, i+1);
      
      if(word.equals(".xyz")) {
        xyz=false;
      }
      else {
        xyz=true;
      }
    }
    return xyz;*/
    
    // if(str.charAt(i) == '.' && str.charAt(i+1) == 'x' && str.charAt(i+2) == 'y' && str.charAt(i+3) == 'z') {
    // if(str.charAt(i) == 'x' && str.charAt(i+1) == 'y' && str.charAt(i+2) == 'z') {
        // return true;
      // }
    // }
    // return false;
}  