// https://codingbat.com/prob/p165312
/*Given a string, return a string where for every char in the original, there are two chars.

doubleChar("The") → "TThhee"
doubleChar("AAbb") → "AAAAbbbb"
doubleChar("Hi-There") → "HHii--TThheerree"*/

public String doubleChar(String str) {
    String letter = "";
    
    for(int i = 0; i < str.length(); i++) {
      char temp = str.charAt(i);
      letter=letter+temp+temp;
    }
    
    return letter;
  }
  
    /*public String doubleChar(String str) {
    char letter='a';
    
    for(int i=0; i<str.length(); i++) {
      letter=str.charAt(i);
      
      if(letter>='a' || letter<='z') {
        System.out.print(letter+letter);
      }
    }
    return letter;
}*/