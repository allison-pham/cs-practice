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
        int fill = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                fill++;
                if(r == 3 && c == 3) {
                    grid[r][c] = EMPTY;
                }
                else {
                    grid[r][c] = fill;
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

    private void mix() {
        //TODO pick a random # from 50 to 150 
        //then randomly shift left, right, up, or down that many times to mix up the puzzle
        int mixNum = (int)(Math.random() * 150) + 50;
        int direction = (int)(Math.random() * 4);
        if(direction == 1) {
            for(int i = 0; i < mixNum; i++) {
                shiftLeft();
            }
        }

        if(direction == 2) {
            for(int i = 0; i < mixNum; i++) {
                shiftRight();
            }
        }

        if(direction == 3) {
            for(int i = 0; i < mixNum; i++) {
                shiftUp();
            }
        }

        if(direction == 4) {
            for(int i = 0; i < mixNum; i++) {
                shiftDown();
            }
        }
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
        int row = find0Row();
        int col = find0Col();
        if(row == EMPTY && col == EMPTY) {
            grid[row][col] = grid[row][col-1];
        }
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
        int row = find0Row();
        int col = find0Col();
        if(row == EMPTY && col == EMPTY) {
            grid[row][col] = grid[row][col+1];
        }
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
        int row = find0Row();
        int col = find0Col();
        if(row == EMPTY && col == EMPTY) {
            grid[row][col] = grid[row-1][col];
        }
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
        int row = find0Row();
        int col = find0Col();
        if(row == EMPTY && col == EMPTY) {
            grid[row][col] = grid[row+1][col];
        }
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
    }
}