import java.io.*;
import java.util.*;
public class Store {
    private Item[] myStore;
    private Item obj;
    public Store(String fileName) {
        // loads the data file into 'myStore' array. Creates new Item objects for each line in the file and puts them into myStore
        myStore = new Item[50];

        Scanner reader = null; //When making the Scanner, need to initialize to null
        try {
            reader = new Scanner(new File(fileName));
        }
        catch(Exception e) {
            System.out.println("File not found.");
        }

        for(int i = 0; i < myStore.length; i++) {
            int temp = reader.nextInt();
            int temp1 = reader.nextInt();
            
            myStore[i] = new Item(temp, temp1);
        }
    }

    public void displayStore() {
        // displays the data, must use the toString method from the Item class,called automatically when an Item object is printed
        for(int i = 0; i < myStore.length; i++) {
            System.out.println(myStore[i]);
        }
    }

    public void doSort() { // public method that calls 'insertionSort' 
        insertionSort(); // code as shown
    }

    private void insertionSort() { // private method, MUST use compareTo, CANNOT use getID() here. 
        //Item.compareTo(obj);
        for(int i = 1; i < myStore.length; i++) {
            Item temp = myStore[i];
            int k = i;
            while(k-1 >= 0 && temp.compareTo(myStore[k-1]) == -1) { //myStore[k-1] > temp
                // myStore[k-1].compareTo(temp) == 1
                // temp.compareTo(myStore[k-1]) == -1
                myStore[k] = myStore[k-1];
                k--;
            }
            myStore[k] = temp;
        }
    }
}