public class Item implements Comparable<Item> { //Comparable is the data type
    private int myId;
    private int myInv;
    public Item(int id, int inv) {
        myId = id;
        myInv = inv;
    }

    public int getId() {
        return myId;
    }  

    public int getInv() {
        return myInv;
    }

    public int compareTo(Item otherObject){
        //compares the Item objects based on their Id's, returns a negative # if this Item's id is less that the parameters id
        //returns a positive # if this Item's id is greater than the parameters id and 0 if the id's are equal. 
        if(this.myId < otherObject.myId) {
            return -1;
        }
        else if(this.myId > otherObject.myId) {
            return 1;
        }
        else {       
            return 0;
        }
    }

    public boolean equals(Object otherObject) {
        //cast otherObject to an Item, if 0 is returned the
        //Item objects are equal, otherwise they are not equal. if( (this.compareTo( (Item)otherObject ) ... )
        return this.compareTo((Item) otherObject) == 0;
    }

    public String toString(){
        return myId + "\t" + myInv;
    }
}