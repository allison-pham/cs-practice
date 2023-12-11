// https://codingbat.com/prob/p126880
/*Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). Note: str.toLowerCase() returns the lowercase version of a string.

endOther("Hiabc", "abc") → true
endOther("AbC", "HiaBc") → true
endOther("abc", "abXabc") → true*/

public boolean endOther(String a, String b) {
    a = a.toLowerCase();
    b = b.toLowerCase();
    String str = "";
    
    if(a.length() < b.length()) {
      str = a;
      a = b.toLowerCase();
      b = str.toLowerCase();
    }
    
    if(a.substring(a.length() - b.length()).equals(b)) {
      return true;
    }
    return false;
    /*boolean end = false;
    for(int i = 0; i <= a.length()-2; i++) {
      String tempA = a.substring(i, a.length()-1);
      String tempB = b.substring(i, b.length()-1);
      if(tempA.equals(tempB)) {
        return true;
      }
      
      if(tempB.equals(tempB)) {
        return true;
      }
    }
    return false;*/
}  