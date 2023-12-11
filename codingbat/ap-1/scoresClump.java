// scoresClump
/*Given an array of scores sorted in increasing order, return true if the array contains 3 adjacent scores that differ from each other by at most 2, such as with {3, 4, 5} or {3, 5, 5}.

scoresClump([3, 4, 5]) → true
scoresClump([3, 4, 6]) → false
scoresClump([1, 3, 5, 5]) → true*/

public boolean scoresClump(int[] scores) {
    /*int smallest = 0;
    int largest = 0;*/
    for(int i = 1; i < scores.length-1; i++) {
      int score1 = scores[i-1];
      int score2 = scores[i+1];
      if(score2 - score1 <= 2) {
        return true;
      }
      /*if(scores[i] < scores[i+1]) {
        smallest = scores[i];
      }
      else {
        smallest = scores[i+1];
       
      }
      
      if(scores[i] > scores[i+1]) {
        largest = scores[i+1];
      }
      else {
        largest = scores[i];
      }
  
      int solve = largest - smallest;
      if(solve <= 2) {
        return true;
      }*/
    }
    return false;
}  