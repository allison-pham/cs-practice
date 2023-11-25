//Fix drawBoard() method
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer; 
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle; 
import com.badlogic.gdx.math.Circle; 
import com.badlogic.gdx.Input.Keys; 
import com.badlogic.gdx.math.Vector2; 
import com.badlogic.gdx.math.MathUtils; 
import com.badlogic.gdx.math.Intersector; 
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.Texture; 
import com.badlogic.gdx.InputProcessor; 
import com.badlogic.gdx.*; 
import com.badlogic.gdx.utils.Array;  
import java.util.*; 

public class Twenty48 extends ApplicationAdapter {
    private OrthographicCamera camera; //the camera to our world
    private Viewport viewport; //maintains the ratios of your world

    //These are all needed to draw text on the screeeeeeen!!!!!
    private SpriteBatch batch; 
    private BitmapFont font; 
    private GlyphLayout layout; 
    private ShapeRenderer renderer; 

    private int[][] grid; 
    private ArrayList<Texture> images;

    //Instance variable to draw start button
    private Texture start1; //Starter button
    private Texture start2; //Highlighted button
    private Rectangle startRect; //Where you draw the rectangle

    //Instance variables to get the location of the mouse
    private Vector2 mouseVector;
    private Circle temp;
    private float mouseX;
    private float mouseY;

    private Gamestate gamestate; 

    @Override//this is called once when you first run your program
    public void create(){       
        camera = new OrthographicCamera(); 
        viewport = new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, camera); 

        batch = new SpriteBatch(); 
        layout = new GlyphLayout(); 
        font = new BitmapFont(); 
        renderer = new ShapeRenderer(); 

        grid = new int[4][4];

        images = new ArrayList<Texture>();
        gamestate = Gamestate.MENU; 
        createNewTile();//create one new tile when the game starts!
        debugPrint(); //print the grid to debug

        //load the images
        images.add(new Texture("tile.png")); 
        images.add(new Texture("2.png")); 
        images.add(new Texture("4.png")); 
        images.add(new Texture("8.png")); 
        images.add(new Texture("16.png")); 
        images.add(new Texture("32.png")); 
        images.add(new Texture("64.png")); 
        images.add(new Texture("128.png")); 
        images.add(new Texture("256.png")); 
        images.add(new Texture("512.png")); 
        images.add(new Texture("1024.png")); 
        images.add(new Texture("2048.png")); 

        //Initialize
        start1 = new Texture("start1.png"); //Need to be a png
        start2 = new Texture("start2.png");

        //Half width of image
        //Shift half the width of the button
        //y will be in the middle
        startRect = new Rectangle(Constants.WORLD_WIDTH / 2 - start1.getWidth() / 2, //x location
            Constants.WORLD_HEIGHT / 2, //y location of bottom left of rectangle
            start1.getWidth(), //Width of rectangle
            start1.getHeight()); //Height of rectangle

        mouseVector = new Vector2();
        temp = new Circle(0, 0, .1f);
        mouseX = 0;
        mouseY = 0;
    }

    @Override//this is called 60 times a second
    public void render(){
        //these two lines wipe and reset the screen so when something action had happened
        //the screen won't have overlapping images
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(gamestate == Gamestate.GAME) {
            if(Gdx.input.isKeyJustPressed(Keys.LEFT)) {
                boolean needToCreate = shiftLeft(); //were we able to shiftLeft
                boolean needToCreate2 = combineLeft();//was there a combination 
                shiftLeft(); //shift left again, for example if you had a row or 2's
                // 2 2 2 2, after 1 shift left and 1 combine left the row is: 4 0 4 0, thus one more shift left is needed
                if(needToCreate || needToCreate2)//if you were able to shift or combine left you need to create new tile
                    createNewTile();
                debugPrint(); //this only for debugging, remove when the method is working.
            }
            if(Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
                boolean needToCreate = shiftRight();
                boolean needToCreate2 = combineRight(); 
                shiftRight(); 
                if(needToCreate || needToCreate2)
                    createNewTile();
                debugPrint(); 
            }
            if(Gdx.input.isKeyJustPressed(Keys.UP)) {
                boolean needToCreate = shiftUp(); 
                boolean needToCreate2 = combineUp(); 
                shiftUp();
                if(needToCreate || needToCreate2)
                    createNewTile();
                debugPrint(); 
            }
            if(Gdx.input.isKeyJustPressed(Keys.DOWN))
            {
                boolean needToCreate = shiftDown(); 
                boolean needToCreate2 = combineDown(); 
                shiftDown();
                if(needToCreate || needToCreate2)
                    createNewTile();
                debugPrint(); 
            }
        }
        if(gamestate == Gamestate.MENU || gamestate == Gamestate.INSTRUCTIONS) {
            if(Gdx.input.isKeyJustPressed(Keys.I)) {
                gamestate = Gamestate.INSTRUCTIONS;
            }
            if(Gdx.input.isKeyJustPressed(Keys.M)) {
                gamestate = Gamestate.MENU;
            }
            updateMouseLocation();

            //Did my mouse overlap w/ the startButton?
            // if(Gdx.input.isKeyJustPressed(Keys.G)) {
            if(Intersector.overlaps(temp, startRect) & Gdx.input.justTouched()) { //Want this to be based on the location of the mouse & if we clicked
                gamestate = Gamestate.GAME; 
            }
        }

        //Hint 3: All logic is completed above, now draw based on the updated attributes
        batch.setProjectionMatrix(viewport.getCamera().combined); 
        batch.begin();

        if(gamestate == Gamestate.MENU) //Draw a different menu
            drawMenu(); 
        else if(gamestate == Gamestate.INSTRUCTIONS)
            drawInstructions(); 
        else if(gamestate == Gamestate.GAME)
            drawBoard();
        batch.end(); 
    }

    private boolean shiftLeft(){ //Col
        //TODO:shift the contents all the way to the left, return true if
        //at least one element shifted
        //Shifts should have nested nested loop (3 loops)
        //Move grid only to empty ("0") spaces
        for(int run = 0; run < 3; run++) {
            for(int r = 0; r < grid.length; r++) {
                for(int c = 0; c < grid[r].length; c++) {
                    if(c-1 >= 0 && grid[r][c-1] == 0) { //Check if in bounds
                        if(grid[r][c] != 0) { //Don't shift 0s & 1+ element is shifted
                            grid[r][c-1] = grid[r][c]; 
                            grid[r][c] = 0;
                            return true;
                        }
                    }
                }
            }
        }
        return false; 
    }

    private boolean combineLeft(){
        //TODO:combine any elements next to each other that are equal, the 
        //one on the left becomes twice as big and the one on the right becomes 0
        //return true if you combine any elements, false otherwise
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {    
                if(c-1 >= 0 && c+1 < grid[r].length && grid[r][c] == grid[r][c-1]) {
                    grid[r][c-1] = grid[r][c-1] + grid[r][c]; //Left. Doubled b/c they are the same
                    grid[r][c] = 0; //Right
                }
            }
        }
        return false;
    }

    private boolean shiftRight(){
        //TODO:shift the contents all the way to the right, return true if
        //at least one element shifted
        for(int run = 0; run < 3; run++) {
            //Fix for loop(int c)?
            for(int r = 0; r < grid.length; r++) { //r1, r2, r3, r4
                for(int c = grid[r].length; c < 0; c--) { //c4, c3, c2, c1
                    if(c+1 < grid[r].length && grid[r][c+1] == 0) { //Check if in bounds
                        if(grid[r][c] != 0) { //Don't shift 0s & 1+ element is shifted
                            grid[r][c+1] = grid[r][c]; //Shift right
                            grid[r][c] = 0;
                            return true;
                        }
                    }
                }
            }
        }
        return false; 
    }

    private boolean combineRight(){
        //TODO:combine any elements next to each other that are equal, 
        //the one on the righ becomes twice as big and the one on the left becomes 0
        //return true if you combine any elements, false otherwise
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {    
                if(c-1 >= 0 && c+1 < grid[r].length && grid[r][c] == grid[r][c+1]) {
                    grid[r][c+1] = grid[r][c+1] + grid[r][c];
                    grid[r][c] = 0;
                    return true;
                }
            }
        }
        return false; 
    }

    private boolean shiftUp(){
        //TODO:shift the contents all the way to the up, return true if
        //at least one element shifted
        for(int run = 0; run < 3; run++) { //Fix later
            for(int r = 0; r < grid.length; r++) {
                for(int c = 0; c < grid[r].length; c++) {
                    if(r-1 >= 0 && grid[r-1][c] == 0) { //Check if in bounds
                        if(grid[r][c] != 0) {
                            grid[r-1][c] = grid[r][c];
                            grid[r][c] = 0;
                            return true;
                        }
                    }
                }
            }
        }
        return false; 
    }

    private boolean combineUp(){
        //TODO:combine any elements next to each other that are equal, 
        //the one on the top  becomes twice as big and the one on the bottom becomes 0
        //return true if you combine any elements, false otherwise
        // boolean up = shiftUp();
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(r-1 >= 0 && r+1 < grid[r].length && grid[r][c] == grid[r-1][c]) {
                    grid[r-1][c] = grid[r-1][c] + grid[r][c];
                    grid[r][c] = 0;
                    return true;
                }

                /*
                if(r-1 >= 0 && r+1 < grid.length && c-1 >= 0 && c+1 < grid[r].length) { //In bounds
                if(grid[r][c] != grid[0][c] && grid[r][c] != grid[r][0]) { //if not empty
                if(grid[r][c] == grid[r-1][c]) { //Top & bottom are equal
                grid[r-1][c] = grid[r*2][c]; //Top
                grid[r][c] = grid[0][0]; //Bottom
                if(up == true) {
                return true;
                }
                else {
                return false;
                }
                }
                }
                }
                */
            }
        }
        return false; 
    }

    private boolean shiftDown(){
        //TODO:shift the contents all the way to the down, return true if
        //at least one element shifted
        //[4][4]
        // boolean shifted = false;
        //Fix for loop(int r)?
        for(int r = grid.length; r > 0; r--) {
            for(int c = 0; c < grid[r].length; c++) {
                if(r+1 >= 0 && grid[r+1][c] == 0) { //Check if in bounds
                    if(grid[r][c] != 0) {
                        grid[r+1][c] = grid[r][c];
                        grid[r][c] = 0;
                        return true;
                    }
                }

                /*int tempR = 0;
                int tempC = 0;
                grid[tempR][tempC] = grid[grid.length-1][c];
                grid[r-1][c] = grid[grid.length-1][c];
                grid[r][c] = grid[grid.length-1][c];
                grid[r+1][c] = grid[grid.length-1][c];
                if(grid[grid.length-1][c] == grid[tempR][tempC]) {
                shifted = true;
                }
                else {
                shifted = false;
                }*/
            }
        }
        return false;
    }

    private boolean combineDown(){
        //TODO:combine any elements next to each other that are equal, 
        //the one on the bottom becomes twice as big and the one on the top becomes 0
        //return true if you combine any elements, false otherwise
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(r-1 >= 0 && r+1 < grid[r].length && grid[r][c] == grid[r+1][c]) {
                    grid[r+1][c] = grid[r+1][c] + grid[r][c];
                    grid[r][c] = 0;
                    return true;
                }
                /*if(r-1 >= 0 && r+1 < grid.length && c-1 >= 0 && c+1 < grid[r].length) { //In bounds
                if(grid[r][c] != grid[0][c] && grid[r][c] != grid[r][0]) { //if not empty
                if(grid[r][c] == grid[r-1][c]) {
                grid[r][c] = grid[0][0]; //Top
                grid[r+1][c] = grid[r*2][c]; //Bottom
                return true;
                }
                else {
                return false;
                }
                }
                }*/
            }
        }
        return false;
    }

    private void debugPrint()
    {
        for(int[] row : grid)
        {
            for(int element : row)
            {
                if(element < 10)
                    System.out.print(element + "     "); 
                else if(element < 100)
                    System.out.print(element + "    ");
                else if(element < 1000)
                    System.out.print(element + "   ");
                else 
                    System.out.print(element + "  ");
            }
            System.out.println(); 
        }
        System.out.println(); 
    }

    private void createNewTile() {
        //TODO create a 2 or 4 on a random empty cell in the grid(if a cell is empty the value is 0). 
        //Create a 2 90% of the time and a 4 10% of the time
        int random = (int)Math.random() * 10; //2 has 90% & 4 has 10%
        int row = (int)Math.random() * grid.length;
        int col = (int)Math.random() * grid[0].length;
        if(row == 0 && col == 0) { //if(empty)
            if(random == 1) { //Create a 4
                grid[row][col] = 4;
            }

            if(random >= 2) { //Create a 2
                grid[row][col] = 2;
            }
        }
        //Don't shift empty tiles
    }

    private void updateMouseLocation() { //To avoid recopying same logic, write a helper method
        //Get location of the mouse
        mouseVector.x = Gdx.input.getX();
        mouseVector.y = Gdx.input.getY();
        mouseX = viewport.unproject(mouseVector).x; //Layered dot call

        mouseVector.y = Gdx.input.getY(); //Assign again
        mouseY = viewport.unproject(mouseVector).y;

        //Update the x & y loctaion of the Circle object
        temp.x = mouseX;
        temp.y = mouseY;
    }

    //EXTRA CREDIT: check if the player got 2048 and draw a screen that shows they have won
    //to test hard code some cells to be 1024
    private boolean checkWinner() {
        return false; 
    }

    //EXTRA CREDIT: check if a player cannot move anymore and then draw a screen that shows they lost
    //to test hard code the board in create to a losing scenario.
    private boolean checkLoser() {
        return false; 
    }

    private void drawMenu() {
        font.setColor(1f, 1f, 1f, 1f);
        layout.setText(font, "Welcome to the Slide Puzzle Game\nI: Instructions, G: Start the puzzle!");
        font.draw(batch,
        layout,
        Constants.WORLD_WIDTH / 2 - layout.width / 2,
        Constants.WORLD_HEIGHT / 2 + layout.height / 2);

        //Draw 2 different images depending on what's true or not
        updateMouseLocation();
        if(Intersector.overlaps(temp, startRect)) {
            batch.draw(start1, startRect.x, startRect.y, startRect.width, startRect.height); //Don't hardcode in
        }
        else { //Draw non-highlighted button
            batch.draw(start2, startRect.x, startRect.y, startRect.width, startRect.height); //Don't hardcode in
        }
    }

    private void drawInstructions() {   
        font.setColor(1f, 0f, 0f, 1f);
        layout.setText(font, "Combine the tiles to get 2048.\nPress M to return to the menu\nPress G to start the game!");
        font.draw(batch,
            layout, 
            Constants.WORLD_WIDTH / 2 - layout.width / 2, 
            Constants.WORLD_HEIGHT / 2 + layout.height / 2);
    }

    private void drawBoard() {
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                //this gets the correct index of from the list based on what numbers is 
                //in the 2D array. For example if the number is 64, then log based 2 of 64 is 6, 
                //and this corresponds to the 64 image in the images ArrayList. 
                int index = 0; 
                if(grid[r][c] != 0)
                    index = (int)(Math.log10(grid[r][c]) / Math.log10(2)); 

                //TODO: You need to replace 0,0 with the x and y location to draw each 
                //tile based on row, r and column c. You can use Constants.CELL_WIDTH, 
                // Constants.CELL_HEIGHT, and grid.length in your logic. 
                
                //I set the x and y location for you. 
                //
                batch.draw(images.get(index), 
                    c * Constants.CELL_WIDTH, //x location depends on the column
                    (grid.length - 1) * Constants.CELL_HEIGHT - Constants.CELL_HEIGHT * r, //y location depends on the row
                    Constants.CELL_WIDTH, 
                    Constants.CELL_HEIGHT);     
            }
        }
    }

    @Override
    public void resize(int width, int height){
        viewport.update(width, height, true); 
    }

    @Override
    public void dispose(){
        batch.dispose();
    }
}