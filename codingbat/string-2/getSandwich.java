// https://codingbat.com/prob/p129952
/*A sandwich is two pieces of bread with something in between. Return the string that is between the first and last appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread.

getSandwich("breadjambread") → "jam"
getSandwich("xxbreadjambreadyy") → "jam"
getSandwich("xxbreadyy") → ""*/

public String getSandwich(String str) {
    int left = 0;
    int right = 0;
    boolean left1 = false;
    boolean right1 = false;
    boolean same = false;
    String output = "";
    for(int i = 0; i < str.length()-5; i++) {
      if(str.substring(i, i+5).equals("bread")) {
        left = i;
        left1 = true;
        break;
      }
    }
    
    for(int i = str.length()-5; i >= 0; i--) {
      if(str.substring(i, i+5).equals("bread")) {
        right = i;
        right1 = true;
        break;
      }
    }
    
    if(left == right) {
      same = true;
    }
    if(left1 && right1 && same == false) {
      output = str.substring(left+5, right);
    }
    return output;
}  