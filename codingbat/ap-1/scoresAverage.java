// https://codingbat.com/prob/p123837
/*Given an array of scores, compute the int average of the first half and the second half, and return whichever is larger. We'll say that the second half begins at index length/2. The array length will be at least 2. To practice decomposition, write a separate helper method
int average(int[] scores, int start, int end) { which computes the average of the elements between indexes start..end. Call your helper method twice to implement scoresAverage(). Write your helper method after your scoresAverage() method in the JavaBat text area. Normally you would compute averages with doubles, but here we use ints so the expected results are exact.

scoresAverage([2, 2, 4, 4]) → 4
scoresAverage([4, 4, 4, 2, 2, 2]) → 4
scoresAverage([3, 4, 5, 1, 2, 3]) → 4*/

public int scoresAverage(int[] scores) {
    int one = average(scores, 0, scores.length/2);
    int two = average(scores, scores.length/2, scores.length);
    int ending = 0;
    if(one > two) {
      ending = one;
    }
    else {
      ending = two;
    }
    return ending;
    /*int start, end = 0;
    
    for(int i = 0; i < scores.length; i++) {
      if(i = 0) {
        start = i;
      }
      if(i = scores.length-1) {
        end = 0;
      }
    }
    average(scores, start, end);
    if(half1 > half2) {
      return half1;
    }
    else {
      return half2;
    }*/
  }
  
  private int average(int[] scores, int start, int end) {
    int total = 0;
    int calc = 0;
    for(int i = start; i < end; i++) {
      total+=scores[i];
    }
    calc = total/(end-start);
    return calc;
    
    /*int half1, half2, index, avg1, avg2 = 0;
    for(int i = 0; i < scores.length; i++) {
      index++;
    }
    
    for(int i = 0; i < index / 2; i++) {
      half1+=scores[i];o
    }
    avg1 = half1 / (index / 2);
    
    for(int i = index / 2; i < scores.length; i++) {
      half2+=scores[i];
    }
    avg2 = half2 / (index / 2);*/
}