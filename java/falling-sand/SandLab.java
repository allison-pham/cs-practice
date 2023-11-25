import java.awt.*;
import java.util.*;
public class SandLab { //Run lab using this class
    //Use grid for Math.random() & nested for loops
    public static void main(String[] args) {
        SandLab lab = new SandLab(120, 80);
        lab.run();
    }
    //add constants for particle types here
    //Using int values to represent particle types
    public static final int EMPTY = 0; //Constants
    public static final int METAL = 1;
    public static final int SAND = 2; //Displaces water
    public static final int WATER = 3; ///rgb(204, 255, 255). Does not displace sand
    public static final int FIRE = 4;
    public static final int OBSIDIAN = 5;

    //do not add any more fields
    private int[][] grid; //Type of particle found at each location
    private SandDisplay display; //Shows particles on the screen

    public SandLab(int numRows, int numCols) {
        String[] names;
        names = new String[5];
        names[EMPTY] = "Empty"; //Type
        names[METAL] = "Metal";
        names[SAND] = "Sand";
        names[WATER] = "Water";
        names[FIRE] = "Fire";
        display = new SandDisplay("Falling Sand", numRows, numCols, names); //New SandLabDisplay
        grid = new int[numRows][numCols];
    }

    //called when the user clicks on a location using the given tool
    private void locationClicked(int row, int col, int tool) { //Whenever user clicks
        grid[row][col] = tool; //Store tool into a position of grid array
    }

    //copies each element of grid into the display
    public void updateDisplay() { //Draws each particle (& empty space) found in grid onto display using setColor
        //API: docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/Color.html
        //Color picker: w3schools.com/colors/colors_picker.asp
        //Send in color value when creating color object
        //Create new variables for different colors
        Color purple = new Color(191, 0, 255);
        for(int i = 0; i<grid.length; i++) { //Nested for loop for 2d array
            for(int k = 0; k<grid[i].length; k++) {
                if(grid[i][k] == EMPTY) { //if(grid is empty) --> setColor to black
                    display.setColor(i, k, Color.BLACK);
                }
                if(grid[i][k] == METAL) { //if(grid is metal) --> setColor to gray
                    display.setColor(i, k, Color.GRAY);
                }
                if(grid[i][k] == SAND) {
                    display.setColor(i, k, Color.YELLOW);
                }
                if(grid[i][k] == WATER) {
                    display.setColor(i, k, Color.BLUE);
                }
                if(grid[i][k] == FIRE) {
                    display.setColor(i, k, Color.RED);
                }
                if(grid[i][k] == OBSIDIAN) {
                    display.setColor(i, k, purple);
                }
            }
        }
    }

    //called repeatedly.
    //causes one random particle to maybe do something.
    public void step() {
        int randomRow = (int)(Math.random() * grid.length); //grid.length - 0 + 1 doesn't work b/c then it won't be a valid index
        int randomCol = (int)(Math.random() * grid[0].length); //Needs grid[0] b/c it needs to get the cols, not the rows
        int randomDirection = (int)(Math.random() * (3-0+1)); //max-min+1
        //Exercise 5: Sand ✔
        if(randomRow+1 < grid.length) { //or <= grid.length-1
            if(grid[randomRow][randomCol] == SAND && grid[randomRow+1][randomCol] == EMPTY) {
                grid[randomRow+1][randomCol] = SAND; //SAND will be at grid[randomRow+1][randomCol]
                grid[randomRow][randomCol] = EMPTY;
            }
        }

        //Exercise 6: Water ✔
        // if(randomRow+1 < grid.length && randomCol-1 >= 0 && randomCol+1 < grid[0].length) {
        if(grid[randomRow][randomCol] == WATER) {
            //Q: Why does the out of bounds condition need to be first instead of last?
            //Fix the water gets stuck on border issue ✔
            if(randomRow+1 < grid.length && randomDirection == 1 && grid[randomRow+1][randomCol] == EMPTY) {
                grid[randomRow+1][randomCol] = WATER; //Down
                grid[randomRow][randomCol] = EMPTY;
            }
            if(randomCol-1 >= 0 && randomDirection == 2 && grid[randomRow][randomCol-1] == EMPTY) {
                grid[randomRow][randomCol-1] = WATER; //Left
                grid[randomRow][randomCol] = EMPTY;
            }
            if(randomCol+1 < grid[0].length && randomDirection == 3 && grid[randomRow][randomCol+1] == EMPTY) {
                grid[randomRow][randomCol+1] = WATER; //Right
                grid[randomRow][randomCol] = EMPTY;
            }
            // if(grid[randomRow][randomCol-1] == WATER) { //Left slide of water
            // randomCol = 2;
            // grid[randomRow][randomCol-1] = WATER;
            //}

            //if(grid[randomRow][randomCol-1] == WATER) { //Water goes to the right
            // grid[randomRow][randomCol-1] = EMPTY;
            // grid[randomRow][randomCol] = WATER;
            // }

            // if(randomCol+1 == grid[0].length) { //if(col is at border)
            // grid[randomRow][randomCol+1] = EMPTY;
            // grid[randomRow][randomCol] = WATER;
            // }
        }

        //Exercise 7: Dropping sand into water ✔
        if(grid[randomRow][randomCol] == SAND) {
            //Allow for sand to move into a space containing water particle (trade places)
            //Do not destroy the water
            //To displace the water with sand: SHIFT water over
            if(randomRow+1 < grid.length && grid[randomRow+1][randomCol] == WATER) {
                grid[randomRow][randomCol] = WATER; //Move over the water
                grid[randomRow+1][randomCol] = SAND; //Down
                //Make sure sand only replaces one spot and not entirety of water
            }

            /*
            if(randomCol-1 >= 0 && grid[randomRow][randomCol-1] == WATER) {
                grid[randomRow][randomCol] = WATER;
                grid[randomRow][randomCol-1] = SAND; //Left
            }

            if(randomCol+1 < grid[0].length && grid[randomRow][randomCol+1] == WATER) {
                grid[randomRow][randomCol] = WATER;
                grid[randomRow][randomCol+1] = SAND; //Right
            }
            */
        }
        
        //Exercise 8 (behavior 1): Fire
        if(grid[randomRow][randomCol] == FIRE) {
            if(randomRow+1 < grid.length && randomDirection == 1 && grid[randomRow+1][randomCol] == EMPTY) {
                grid[randomRow+1][randomCol] = FIRE; //Down
                grid[randomRow][randomCol] = EMPTY;
            }
            if(randomCol-1 >= 0 && randomDirection == 2 && grid[randomRow][randomCol-1] == EMPTY) {
                grid[randomRow][randomCol-1] = FIRE; //Left
                grid[randomRow][randomCol] = EMPTY;
            }
            if(randomCol+1 < grid[0].length && randomDirection == 3 && grid[randomRow][randomCol+1] == EMPTY) {
                grid[randomRow][randomCol+1] = FIRE; //Right
                grid[randomRow][randomCol] = EMPTY;
            }
        }

        //Exercise 8 (behavior 2): Obsidian
        if(grid[randomRow][randomCol] == FIRE) {
            if(randomRow+1 < grid.length && grid[randomRow+1][randomCol] == WATER) {
                grid[randomRow+1][randomCol] = OBSIDIAN; //Down
                grid[randomRow][randomCol] = OBSIDIAN;
            }
            if(randomCol-1 >= 0 && grid[randomRow][randomCol-1] == WATER) {
                grid[randomRow][randomCol-1] = OBSIDIAN; //Left
                grid[randomRow][randomCol] = OBSIDIAN;
            }
            if(randomCol+1 < grid[0].length && grid[randomRow][randomCol+1] == WATER) {
                grid[randomRow][randomCol+1] = OBSIDIAN; //Right
                grid[randomRow][randomCol] = OBSIDIAN;
            }
        }

        if(grid[randomRow][randomCol] == WATER) {
            if(randomRow+1 < grid.length && grid[randomRow+1][randomCol] == FIRE) {
                grid[randomRow+1][randomCol] = OBSIDIAN; //Down
                grid[randomRow][randomCol] = OBSIDIAN;
            }
            if(randomCol-1 >= 0 && grid[randomRow][randomCol-1] == FIRE) {
                grid[randomRow][randomCol-1] = OBSIDIAN; //Left
                grid[randomRow][randomCol] = OBSIDIAN;
            }
            if(randomCol+1 < grid[0].length && grid[randomRow][randomCol+1] == FIRE) {
                grid[randomRow][randomCol+1] = OBSIDIAN; //Right
                grid[randomRow][randomCol] = OBSIDIAN;
            }
        }
    }

    public void run() { //do not modify
        while (true) {
            for (int i = 0; i < display.getSpeed(); i++)
                step();
            updateDisplay();
            display.repaint();
            display.pause(1);  //wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null)  //test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }
}