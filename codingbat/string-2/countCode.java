// https://codingbat.com/prob/p123614
/*Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.

countCode("aaacodebbb") → 1
countCode("codexxcode") → 2
countCode("cozexxcope") → 2*/

public int countCode(String str) {
    int ctr=0;
    
    for(int i=0; i<str.length()-3; i++) {
      String left=str.substring(i, i+2);
      String right=str.substring(i+3, i+4);
      
      if(left.equals("co") && right.equals("e")) {
        ctr++;
      }
    }
    return ctr;
}