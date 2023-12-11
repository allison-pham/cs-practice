public class Tester {
    public static void main(String[] args) {
        /*int r = 0; //rows
        int c = 0; //columns
        while(reader.hasNextInt()) {
        r = reader.nextInt();
        c = reader.nextInt();
        if(r>=0 && r<grid.length && c>=0 && c<grid[0].length) {
        grid[r][c] = 1;
        }
        }

        //This will traverse through grid & countNeighbors
        //Fill & print
        // boolean finish = false; //For the while loop
        // int x = 0;
        for (int g = 0; g<5; g++) { //Continues to run until it has reached generation 5
        int[][] temp = new int[rowsAmt][colsAmt]; //Store 2d array
        for(int a = 1; a<=21; a++) { //Rows
        for(int b = 1; b<=21; b++) { //Columns
        //nested for loop to go through grid/petri dish
        int countAliveNeighbors = 0; //Counts living neighbors. Resets later
        for(int i = a-1; i<=a+1; i++) {
        for(int k = b-1; k<=b+1; k++) {
        if(i != rowsAmt || k != colsAmt) {
        countAliveNeighbors += grid[i][k];
        }
        }
        }
        }
        }
        }
        if (grid[a][b] == 1) {
        if (countAliveNeighbors == 2 || countAliveNeighbors == 3) {
        temp[a][b] = 1;
        }
        }
        else {
        if (countAliveNeighbors == 3) {
        temp[a][b] = 1;
        }
        }
        grid = temp;
        // for(int i = 0; i<grid.length; i++)
        // {
        // for(int k = 0; k<grid[i].length; k++)
        // {
        // countNeighbors(i, k);
        // }
        // }

        for(int i = 0; i < logLength; i++)
        {
        String temp = countries[i];
        for(int j = 0; j < temp.length(); j++)
        {
        // int index = getIndexOfAlpha(temp.charAt(j));
        // if(index != -1)//if it is a letter the -1 was not returned
        // freq[index]++;
        char letter = temp.charAt(j);
        int index = letter - 'a';//gets the proper index from 0 to 25 using the ASCII values
        if(letter >= 'a' && letter <= 'z') {//can't increase the spaces or
        apostrophes
        freq[index]++;
        }
        }
        }*/

        /*//Extra credit is win/lose screen or adding additions
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

        public class SlidePuzzle extends ApplicationAdapter 
        {
        private OrthographicCamera camera; //the camera to our world
        private Viewport viewport; //maintains the ratios of your world

        private SpriteBatch batch; 

        private int[][] grid; 
        private Array<Texture> images;

        public static final int WORLD_WIDTH = 300; 
        public static final int WORLD_HEIGHT = 300; 

        public static final int NUM_ROWS = 3; 
        public static final int NUM_COLUMNS = 3; 
        public static final int CELL_WIDTH = WORLD_WIDTH / NUM_COLUMNS;  
        public static final int CELL_HEIGHT = WORLD_HEIGHT / NUM_ROWS;

        public static final int EMPTY = 0; 

        @Override//this is called once when you first run your program
        public void create(){       
        camera = new OrthographicCamera(); 
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera); 

        batch = new SpriteBatch(); 

        grid = new int[3][3]; 

        fillGrid();//fill with values 1-8 from top to bottom
        //then put a 0 in the bottom right
        mix();//mix up the tiles

        images = new Array<Texture>(); 
        images.add(new Texture(Gdx.files.internal("1.png"))); 
        images.add(new Texture(Gdx.files.internal("2.png"))); 
        images.add(new Texture(Gdx.files.internal("3.png"))); 
        images.add(new Texture(Gdx.files.internal("4.png"))); 
        images.add(new Texture(Gdx.files.internal("5.png"))); 
        images.add(new Texture(Gdx.files.internal("6.png"))); 
        images.add(new Texture(Gdx.files.internal("7.png"))); 
        images.add(new Texture(Gdx.files.internal("8.png"))); 
        }

        @Override//this is called 60 times a second
        public void render(){
        //these two lines wipe and reset the screen so when something action had happened
        //the screen won't have overlapping images
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        getInput(); 

        batch.setProjectionMatrix(viewport.getCamera().combined); 
        batch.begin(); 

        drawBoard();

        batch.end();    
        }

        private void fillGrid()
        {
        //TODO fill the grid with the values of 1 - 8 in row major order,
        //set the bottom right to 0 (use the constant, EMPTY).
        for(int r = 0; r < grid.length; r++) {
        for(int c = 0; c < grid[r].length; c++) {
        if(r == 3 && c == 3) {
        grid[r][c] = EMPTY;
        }
        else {
        grid[3][3] = grid[r][c];
        }
        }
        }
        }

        private void getInput()
        {
        if(Gdx.input.isKeyJustPressed(Keys.SPACE))
        mix(); //shuffle the board
        if(Gdx.input.isKeyJustPressed(Keys.RIGHT))
        {
        shiftRight(); 
        }
        if(Gdx.input.isKeyJustPressed(Keys.LEFT))
        {
        shiftLeft(); 
        }
        if(Gdx.input.isKeyJustPressed(Keys.UP))
        {
        shiftUp(); 
        }
        if(Gdx.input.isKeyJustPressed(Keys.DOWN))
        {
        shiftDown(); 
        }
        }

        private void mix()
        {
        // int random = (int)(Math.random() *

        //TODO pick a random # from 50 to 150 
        //then randomly shift left, right, up, or down that many times to mix up the puzzle  
        }

        private void shiftLeft(){   
        //TODO: find the row where the EMPTY square is at (use a helper method call) and
        //find the column where the empty square is at (use a helper method call)
        //Then if possible shift the number into the empty spot. 
        // for(int r = 0; r < grid.length; r++) {
        // for(int c = 0; c < grid[r].length; c++) {
        // if(c > 0 && grid[r][c] == find0Row() && grid[r][c] == find0Col()) { //Returns index of row space
        // grid[r][c] = grid[r][c-1];
        // }
        // }
        // }
        }

        private void shiftRight(){
        //TODO: find the row where the EMPTY square is at (use a helper method call) and
        //find the column where the empty square is at (use a helper method call)
        //Then if possible shift the number into the empty spot.
        // for(int r = 0; r < grid.length; r++) {
        // for(int c = 0; c < grid[r].length; c++) {
        // if(c < grid[r].length && grid[r][c] == find0Row() && grid[r][c] == find0Col()) { //Returns index of row space
        // grid[r][c] = grid[r][c+1];
        // }
        // }
        // }
        }

        private void shiftUp(){
        //TODO: find the row where the EMPTY square is at (use a helper method call) and
        //find the column where the empty square is at (use a helper method call)
        //Then if possible shift the number into the empty spot.
        // for(int r = 0; r < grid.length; r++) {
        // for(int c = 0; c < grid[r].length; c++) {
        // if(r > 0 && grid[r][c] == find0Row() && grid[r][c] == find0Col()) { //Returns index of row space
        // grid[r][c] = grid[r-1][c];
        // }
        // }
        // }
        }

        private void shiftDown(){
        //TODO: find the row where the EMPTY square is at (use a helper method call) and
        //find the column where the empty square is at (use a helper method call)
        //Then if possible shift the number into the empty spot.
        // for(int r = 0; r < grid.length; r++) {
        // for(int c = 0; c < grid[r].length; c++) {
        // if(r < grid.length && grid[r][c] == find0Row() && grid[r][c] == find0Col()) { //Returns index of row space
        // grid[r][c] = grid[r+1][c];
        // }
        // }
        // }
        }

        private int find0Row()
        {
        //return the row index of the EMPTY space
        return -1; 
        }

        private int find0Col()
        {
        //Return the column index of the EMPTY space
        return -1; 
        }

        private void drawBoard()
        {
        for(int r = 0; r < grid.length; r++)
        {
        for(int c = 0; c < grid[0].length; c++)
        {
        //the element at grid[r][c] is one more than the index of the number that needs to be drawn
        if(grid[r][c] != EMPTY)//dont draw anything if the element is EMPTY
        batch.draw(images.get(grid[r][c]- 1), 
        c * CELL_WIDTH, 
        (grid.length - 1) * CELL_HEIGHT - CELL_HEIGHT * r,
        CELL_WIDTH, CELL_HEIGHT);   
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
        }*/
    }
}