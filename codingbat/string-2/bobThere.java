// https://codingbat.com/prob/p175762
/*Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.

bobThere("abcbob") → true
bobThere("b9b") → true
bobThere("bac") → false*/

public boolean bobThere(String str) {
    boolean bob=false;
    
    for(int i=0; i<str.length()-2; i++) {
      String left=str.substring(i, i+1);
      String right=str.substring(i+2, i+3);
    
      if(left.equals("b") && right.equals("b")) {
      bob=true;
    }
    }
    
    return bob;
}  