// https://codingbat.com/prob/p180759
/*Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".

zipZap("zipXzap") → "zpXzp"
zipZap("zopzop") → "zpzp"
zipZap("zzzopzop") → "zzzpzp"*/

public String zipZap(String str) {
    int temp = str.length();
    String s = "";
    
    for (int i = 0; i < temp; i++) {
      s+=str.substring(i, i+1);
      if (i > 0 && i < temp - 1) {
        if (str.charAt(i-1) == 'z' && str.charAt(i+1) == 'p')
          s = s.substring(0, s.length()-1);
      }
    }
    return s;
}