// https://codingbat.com/prob/p139150
/*Start with two arrays of strings, A and B, each with its elements in alphabetical order and without duplicates. Return a new array containing the first N elements from the two arrays. The result array should be in alphabetical order and without duplicates. A and B will both have a length which is N or more. The best "linear" solution makes a single pass over A and B, taking advantage of the fact that they are in alphabetical order, copying elements directly to the new array.

mergeTwo(["a", "c", "z"], ["b", "f", "z"], 3) → ["a", "b", "c"]
mergeTwo(["a", "c", "z"], ["c", "f", "z"], 3) → ["a", "c", "f"]
mergeTwo(["f", "g", "z"], ["c", "f", "g"], 3) → ["c", "f", "g"]*/

public String[] mergeTwo(String[] a, String[] b, int n) {
    int log1 = 0;
    int log2 = 0;
    String[] store = new String[n];
    for(int i = 0; i < n; i++) {
      if(a[log1].compareTo(b[log2]) < 0) {
        store[i] = a[log1];
        log1++;
      }
      else if(a[log1].compareTo(b[log2]) > 0) {
        store[i] = b[log2];
        log2++;
      }
      else {
        store[i] = a[log1];
        log1++;
        log2++;
      }
    }
    return store;
  }