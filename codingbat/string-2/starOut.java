// https://codingbat.com/prob/p139564
/*Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".

starOut("ab*cd") → "ad"
starOut("ab**cd") → "ad"
starOut("sm*eilly") → "silly"*/

public String starOut(String str) {
    String output = "";
    
    for (int i = 0; i < str.length(); i++) {
      // if(i >= 1) {
      if (i == 0 && str.charAt(i) != '*')
        output+=str.charAt(i);
    
      if (i > 0 && str.charAt(i) != '*' && str.charAt(i-1) != '*')
        output+=str.charAt(i);
        
      if (i > 0 && str.charAt(i) == '*' && str.charAt(i-1) != '*')
        output = output.substring(0, output.length()-1);
    }
    // }
    return output;
  
    
    /*String output = "";
    
    for(int i = 1; i < str.length(); i++) {
      if(i >= 0) {
        if(str.charAt(i) != '*') {
          output+=str.charAt(i);
          if(str.charAt(i-1) != '*') {
            output+=str.charAt(i);
          }
        }
        
        if(str.charAt(i) == '*') {
          output = output.substring(0, str.length()-1);
        }
      }
    }
    return output;*/
}