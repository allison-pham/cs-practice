import com.badlogic.gdx.*; //Audio, files, graphics, input, & screen
import com.badlogic.gdx.ApplicationAdapter; //Render images
import com.badlogic.gdx.audio.*; //Sound
import com.badlogic.gdx.graphics.*; //1) Fullscreen display mode & monitor & 2) Color
import com.badlogic.gdx.graphics.g2d.*; //1) BitmapFont - renders fonts, 2) GlyphLayout - text (ex: instructions), & 3) SpriteBatch - draws rectangles
import com.badlogic.gdx.graphics.glutils.*; //ShapeRenderer - circle, rect, & sectColor
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType; //Returns constants
import com.badlogic.gdx.graphics.OrthographicCamera; //Real world camera
import com.badlogic.gdx.graphics.Texture; //Buttons
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys; //Press keys
import com.badlogic.gdx.InputProcessor; //Receives input from keys
import com.badlogic.gdx.math.Circle; //New circle w/ coordinates
import com.badlogic.gdx.math.Intersector; //Cross
import com.badlogic.gdx.math.MathUtils; //Math functions
import com.badlogic.gdx.math.Rectangle; //New rectangle w/ coordinates
import com.badlogic.gdx.math.Vector2; //Vector (array of nums to describe something w/ direction & magnitude (ex: acceleration, position, velocity))
import com.badlogic.gdx.utils.Array; //Array objects
import com.badlogic.gdx.utils.viewport.*; //Manages Camera & determines how coordinates are laid out on screen
public class Game extends ApplicationAdapter {
    //Background
    private Texture backgroundTexture;
    private Sprite backgroundSprite;
    private SpriteBatch spriteBatch;

    //Board
    public static int[][] board;
    private static final float TILE_SIZE = 20; //Dimension for each png
    public static final int WIDTH = 15;
    public static final int HEIGHT = 19;

    //Character
    public static Rectangle thePlayer;
    public static Texture player; //1

    //Draw
    private ShapeRenderer renderer; //Draws shapes
    private static SpriteBatch batch; //Draws textures

    //Floor layout
    private static Texture unusedBlock; //2 - Space that is outside of border
    private static Texture wallBlocker; //3 - Border
    private static Texture ice; //4 - Everything starts off as ice
    private static Texture water; //5 - Ice turns into water for the pieces that the player steps on
    private static Texture nextLevel; //6 - Teleports character to next level

    //Graphics & menu (buttons)
    private Gamestate gamestate;
    private Rectangle startRect; //Where the rectangle is drawn
    private Rectangle tutorialRect;
    private Texture back1;
    private Texture back2;
    private Texture next1;
    private Texture next2;
    private Texture play1; //Play button
    private Texture play2; //Highlighted button
    private Texture tutorial1;
    private Texture tutorial2;

    //Mouse location
    private Circle temp;
    private float mouseX;
    private float mouseY;
    private Vector2 mouseVector;

    //Stats
    public static int coinBags;
    public static int coins;
    public static int denominator; //tilesReached
    public static int iceMelted;
    public static int level; //Displayed at top of screen & used to control which level method that runs
    public static int numerator; //tilesReached
    public static int points;
    public static String tilesReached; //numerator / denominator
    public static int time;

    //Text on screen
    private BitmapFont font; //Stores glyph as an array of pixels
    private GlyphLayout layout;

    //Viewing
    private OrthographicCamera camera; //Renders he exact size that was set
    private Viewport viewport; //Maintains the aspect ratios to ensure the game looks the same on multiple devices
    @Override//this is called once when you first run your program
    public void create() {
        //Background
        /*Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.graphics.setVSync(true);*/
        spriteBatch = new SpriteBatch();
        backgroundTexture = new Texture("background.png"); //Menu

        //Viewing
        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, camera);

        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setPosition(0, 0);
        backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        thePlayer = new Rectangle();
        thePlayer.width = TILE_SIZE;
        thePlayer.height = TILE_SIZE;
        thePlayer.x = (screenWidth - TILE_SIZE) / 2;
        thePlayer.y = (screenHeight - TILE_SIZE) / 2;

        //Draw & text on screen
        batch = new SpriteBatch();
        layout = new GlyphLayout();
        font = new BitmapFont();
        renderer = new ShapeRenderer();

        //Board (level 1)
        // board = new int[WIDTH][HEIGHT];

        //Graphics & menu (buttons)
        gamestate = Gamestate.MENU; //**Change back to MENU**
        board = new int[][] {
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, //*
            {3, 6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 3}, //*
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, //*
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};

        player = new Texture("player.png");
        unusedBlock = new Texture("unusedBlock.png");
        wallBlocker = new Texture("wallBlocker.png");
        ice = new Texture("ice.png"); //
        water = new Texture("water.png"); //
        nextLevel = new Texture("nextLevel.png");

        back1 = new Texture("button_back1.png");
        back2 = new Texture("button_back2.png");
        next1 = new Texture("button_next1.png");
        next2 = new Texture("button_next2.png");
        play1 = new Texture("button_play1.png"); //png
        play2 = new Texture("button_play2.png");
        tutorial1 = new Texture("button_tutorial1.png");
        tutorial2 = new Texture("button_tutorial2.png");
        startRect = new Rectangle(Constants.WORLD_WIDTH / 2 - play1.getWidth() / 2 - 25, //x location
            Constants.WORLD_HEIGHT / 2 - 140, //y location of bottom left of rectangle
            play1.getWidth(), //Width of rectangle
            play1.getHeight()); //Height of rectangle
        startRect.setSize(100, 50);
        tutorialRect = new Rectangle(Constants.WORLD_WIDTH / 2 - tutorial1.getWidth() / 2 + 105, //x location
            Constants.WORLD_HEIGHT / 2 - 140, //y location of bottom left of rectangle
            //Constants.WORLD_HEIGHT / 2 - startRect.y
            tutorial1.getWidth(), //Width of rectangle
            tutorial1.getHeight()); //Height of rectangle
        tutorialRect.setSize(100, 50);

        //Mouse location
        mouseVector = new Vector2();
        temp = new Circle(0, 0, .1f);
        mouseX = 0;
        mouseY = 0;

        //Stats
        coinBags = 0;
        coins = 0;
        denominator = 0;
        iceMelted = 0;
        level = 1;
        numerator = 0;
        points = 0;
        tilesReached = "";
        time = 0;
    }

    @Override //Called 60 times a second
    public void render() { //Keys assigned w/ a certain function
        Gdx.gl.glClearColor(0, 0, 0, 1); //(0, 0, 0, 1) - puts clear color to black
        //24, 20, 10, 1
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //Clears screen w/ the color in ClearColor
        spriteBatch.begin();
        backgroundSprite.draw(spriteBatch);
        spriteBatch.end();

        updateMouseLocation();
        if(gamestate == Gamestate.GAME) {
            if(Gdx.input.isKeyJustPressed(Keys.UP)) { //**Issue: up goes down & down goes up**
                // Stats.countMovement();
                // Movement.goUp();
                int playerRow = -1;
                int playerCol = -1;
                for(int r = 0; r < board.length; r++) {
                    for(int c = 0; c < board[0].length; c++) {
                        if(board[r][c] == 1) {
                            playerRow = r;
                            playerCol = c;
                            break;
                        }
                    }
                    if(playerRow != -1)
                        break;
                }
                if(playerRow+1 <= board.length-1
                && (board[playerRow+1][playerCol] == 4 || board[playerRow+1][playerCol] == 6)) {
                    if(board[playerRow+1][playerCol] == 4)
                        board[playerRow][playerCol] = 4;
                    else if(board[playerRow+1][playerCol] == 6)
                        board[playerRow][playerCol] = 6;
                    board[playerRow+1][playerCol] = 1;
                    if(board[playerRow][playerCol] == 6) { //If player reaches new level
                        advanceToNextLevel();
                        // drawLayout();
                    }
                    if(board[playerRow][playerCol] == 4) //Ice
                        board[playerRow][playerCol] = 5; //Water        
                    thePlayer.y+=TILE_SIZE; //Move down
                }
            }

            if(Gdx.input.isKeyJustPressed(Keys.DOWN)) {
                int playerRow = -1;
                int playerCol = -1;
                for(int r = 0; r < board.length; r++) {
                    for(int c = 0; c < board[0].length; c++) {
                        if(board[r][c] == 1) {
                            playerRow = r;
                            playerCol = c;
                            break;
                        }
                    }
                    if(playerRow != -1)
                        break;
                }
                if(playerRow-1 >= 0
                && (board[playerRow-1][playerCol] == 4 || board[playerRow-1][playerCol] == 6)) {
                    if(board[playerRow-1][playerCol] == 4)
                        board[playerRow][playerCol] = 4; //Ice
                    else if(board[playerRow-1][playerCol] == 6)
                        board[playerRow][playerCol] = 6;
                    /*else if(board[playerRow-1][playerCol] == 5)
                    board[playerRow][playerCol] = 5;*/
                    board[playerRow-1][playerCol] = 1; //Player
                    if(board[playerRow][playerCol] == 6) { //If player reaches new level
                        advanceToNextLevel();
                        // drawLayout();
                    }
                    /*if(board[playerRow][playerCol] == 5) //Water
                    board[playerRow][playerCol] = 3; //Wallblocker*/
                    if(board[playerRow][playerCol] == 4) //Ice
                        board[playerRow][playerCol] = 5; //Water
                    thePlayer.y-=TILE_SIZE; //Move up
                }
            }

            if(Gdx.input.isKeyJustPressed(Keys.LEFT)) { // Movement.goLeft();
                int playerRow = -1;
                int playerCol = -1;
                for(int r = 0; r < board.length; r++) {
                    for(int c = 0; c < board[0].length; c++) {
                        if(board[r][c] == 1) { //&& (board[r][c+1] == 4)
                            playerRow = r; //Gets exact position of player (can be any set of nums)
                            playerCol = c;
                            break;
                        }
                    }
                    if(playerRow != -1)
                        break;
                }
                if(playerCol-1 >= 0
                && (board[playerRow][playerCol-1] == 4 || board[playerRow][playerCol-1] == 6)) {
                    if(board[playerRow][playerCol-1] == 4)
                        board[playerRow][playerCol] = 4;
                    else if(board[playerRow][playerCol-1] == 6)
                        board[playerRow][playerCol] = 6;
                    board[playerRow][playerCol-1] = 1;
                    if(board[playerRow][playerCol] == 6) { //If player reaches new level
                        advanceToNextLevel();
                        // level++;
                        // if(level == 2) { // runLevel();
                        // drawLayout();
                        // }
                    }
                    if (board[playerRow][playerCol] == 4)
                        board[playerRow][playerCol] = 5;                    
                    thePlayer.x-=TILE_SIZE; //Move left
                }
            }

            if(Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
                int playerRow = -1;
                int playerCol = -1;
                for(int r = 0; r < board.length; r++) {
                    for(int c = 0; c < board[0].length; c++) {
                        if(board[r][c] == 1) {
                            playerRow = r;
                            playerCol = c;
                            break;
                        }
                    }
                    if(playerRow != -1)
                        break;
                }
                if(playerCol-1 <= board[0].length-1
                && (board[playerRow][playerCol+1] == 4 || board[playerRow][playerCol+1] == 6)) {
                    if(board[playerRow-1][playerCol] == 4)
                        board[playerRow][playerCol] = 4; //Ice
                    else if(board[playerRow-1][playerCol] == 6)
                        board[playerRow][playerCol] = 6;
                    board[playerRow][playerCol] = 4;
                    board[playerRow][playerCol+1] = 1;
                    if(board[playerRow][playerCol] == 6) { //If player reaches new level
                        advanceToNextLevel();
                        // drawLayout();
                    }
                    if(board[playerRow][playerCol] == 4)
                        board[playerRow][playerCol] = 5;                    
                    thePlayer.x+=TILE_SIZE;
                }
            }
        }

        if(gamestate == Gamestate.MENU || gamestate == Gamestate.TUTORIAL) {
            if(Gdx.input.isKeyJustPressed(Keys.G))
                gamestate = Gamestate.GAME;
            /*if(Gdx.input.isKeyJustPressed(Keys.T))
            gamestate = Gamestate.TUTORIAL;
            if(Gdx.input.isKeyJustPressed(Keys.M))
            gamestate = Gamestate.MENU;*/
            updateMouseLocation();
            // if(Gdx.input.isKeyJustPressed(Keys.G)) {
            if(Intersector.overlaps(temp, startRect) && Gdx.input.justTouched()) //Want this to be based on the location of the mouse & if we clicked
                gamestate = Gamestate.GAME;
            if(Intersector.overlaps(temp, tutorialRect) && Gdx.input.justTouched()) //Want this to be based on the location of the mouse & if we clicked
                gamestate = Gamestate.TUTORIAL;
        }
        if(level == 5)
            gamestate = Gamestate.WINNER;
        /*if(Stats.lose())
        gamestate = Gamestate.LOST;*/
        // if(level == 2)
        // gamestate = Gamestate.LEVEL_2;
        // batch.setProjectionMatrix(viewport.getCamera().combined); 
        batch.begin();
        if(gamestate == Gamestate.MENU) //Draw a different menu
            drawMenu();
        else if(gamestate == Gamestate.TUTORIAL)
            drawTutorial(); //**Un-comment out**
        else if(gamestate == Gamestate.GAME) // Levels.level1();
            drawLayout();
        /*// if(gamestate == Gamestate.LEVEL_2)
        // runLevel();*/
        else if(gamestate == Gamestate.WINNER)
            drawEndScreen();
        else if(gamestate == Gamestate.REPLAY)
            replay();
        /*else if(gamestate == Gamestate.LOST)
        runLevel();*/
        batch.end();
    }

    @Override
    public void resize(int width, int height){
        viewport.update(width, height, true);
        Gdx.gl.glViewport(0, 0, width, height);
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
        unusedBlock.dispose();
        wallBlocker.dispose();
        ice.dispose();
        water.dispose();
        nextLevel.dispose();
        super.dispose();
    }

    private void drawMenu() {
        font.setColor(1f, 1f, 1f, 1f); //1, 1, 1, 1
        // layout.setText(font, "Welcome to Thin Ice!\nT: Tutorial, G: Start the game!");
        font.draw(batch,
            layout,
            Constants.WORLD_WIDTH / 2 - layout.width / 2,
            Constants.WORLD_HEIGHT / 2 + layout.height / 2);
        updateMouseLocation();
        /*System.out.println("temp x = " + temp.x + " temp y = " + temp.y + " radius = " + temp.radius); 
        System.out.println("startRect x = " + startRect.x + "startRect y = " + startRect.y
        + "startRect width = " + startRect.width + "startRect height = " + startRect.height);*/
        if(Intersector.overlaps(temp, startRect))
            batch.draw(play1, startRect.x, startRect.y, startRect.width, startRect.height); //Don't hardcode in
        else //Draw non-highlighted button
            batch.draw(play2, startRect.x, startRect.y, startRect.width, startRect.height); //Don't hardcode in
        if(Intersector.overlaps(temp, tutorialRect))
            batch.draw(tutorial1, tutorialRect.x, tutorialRect.y, tutorialRect.width, tutorialRect.height); //Don't hardcode in
        else //Draw non-highlighted button
            batch.draw(tutorial2, tutorialRect.x, tutorialRect.y, tutorialRect.width, tutorialRect.height); //Don't hardcode in
    }

    private void drawTutorial() {
        font.setColor(0f, 0f, 0f, 1f);
        layout.setText(font, "Press G to start.\nUse W, A, S, D to melt ice on your way\nthrough each maze.\nOnce the ice is melted you can't walk back.\nMelt all the ice to solve the stage.");
        font.draw(batch,
            layout, 
            Constants.WORLD_WIDTH / 2 - layout.width / 2, 
            Constants.WORLD_HEIGHT / 4 + layout.height / 4 + 100);
        /*System.out.println("temp x = " + temp.x + " temp y = " + temp.y + " radius = " + temp.radius);
        System.out.println("tutorial x " + tutorialRect.x + "tutorial y " + tutorialRect.y
        + "tutorial width " + tutorialRect.width + "tutorial height " + tutorialRect.height);*/
        if(Intersector.overlaps(temp, tutorialRect))
            batch.draw(tutorial1, tutorialRect.x, tutorialRect.y, tutorialRect.width, tutorialRect.height);
        else
            batch.draw(tutorial2, tutorialRect.x, tutorialRect.y, tutorialRect.width, tutorialRect.height);
    }

    public static void drawLayout() {
        // Levels.level1();
        //Switches certain nums with images (draw)
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                int s = board[r][c];
                float x = c * TILE_SIZE; //x-coordinate
                float y = r * TILE_SIZE; //y-coordinate
                switch(s) {
                    case 1:
                        batch.draw(player, x, y); //player, x, y, TILE_SIZE, TILE_SIZE
                        break;
                    case 2:
                        batch.draw(unusedBlock, x, y);
                        break;
                    case 3:
                        batch.draw(wallBlocker, x, y);
                        break;
                    case 4:
                        batch.draw(ice, x, y);
                        break;
                    case 5:
                        batch.draw(water, x, y);
                        break;
                    case 6:
                        batch.draw(nextLevel, x, y);
                        break;
                }
            }
        }
    }

    public void drawEndScreen() {
        //Include the coinBags, coins, iceMelted, points, & time
        font.setColor(0f, 0f, 0f, 1f);
        layout.setText(font, "You have completed the game!\nWant to play again?");
        font.draw(batch,
            layout, 
            Constants.WORLD_WIDTH / 2 - layout.width / 2, 
            Constants.WORLD_HEIGHT / 2 + layout.height / 2);
    }

    private void updateMouseLocation() { //To avoid recopying same logic, write a helper method
        //Get location of the mouse
        mouseVector.x = Gdx.input.getX();
        mouseVector.y = Gdx.input.getY();
        // System.out.println("mousex " + mouseVector.x);
        mouseX = viewport.unproject(mouseVector).x; //Layered dot call
        mouseVector.y = Gdx.input.getY(); //Assign again
        mouseY = viewport.unproject(mouseVector).y;
        //Update the x & y loctaion of the Circle object
        temp.x = mouseX;
        temp.y = mouseY;
        // System.out.println("temp x = " + temp.x);
    }

    private void loadLevel(int level) {
        //Calls a certain layout based on the instnace variable "level"
        if(level == 1) {
            board = new int[][] {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, //*
                {3, 6, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 3}, //*
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, //*
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
        }
        if(level == 2) {
            board = new int[][] {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 6, 3, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 3, 2, 2, 2},
                {2, 3, 3, 3, 3, 3, 3, 3, 2, 3, 3, 3, 3, 3, 4, 3, 2, 2, 2},
                {2, 3, 1, 4, 4, 4, 4, 3, 2, 3, 4, 4, 4, 4, 4, 3, 2, 2, 2},
                {2, 3, 3, 3, 3, 3, 4, 3, 3, 3, 4, 3, 3, 3, 3, 3, 2, 2, 2},
                {2, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 3, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
        }
        if(level == 3) {
            board = new int[][] {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2},
                {2, 3, 3, 3, 4, 4, 4, 3, 3, 4, 4, 4, 4, 3, 3, 3, 2, 2, 2},
                {2, 3, 6, 4, 4, 3, 4, 3, 3, 4, 3, 3, 4, 3, 3, 3, 3, 2, 2},
                {2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 3, 3, 4, 4, 4, 4, 3, 2, 2},
                {2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 1, 3, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 2, 2}};
        }
        if(level == 4) {
            board = new int[][] {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 2, 2},
                {2, 3, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 3, 2, 2},
                {2, 3, 4, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 4, 3, 2, 2},
                {2, 3, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 3, 2, 2},
                {2, 3, 3, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 3, 2, 2},
                {2, 2, 3, 4, 3, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 3, 3, 2, 2},
                {2, 2, 3, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 3, 6, 3, 2, 2, 2},
                {2, 2, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
        }
    }

    private void advanceToNextLevel() {
        level++;
        loadLevel(level);
    }

    private void replay() {
        if(level == 4) {
            level = 1;
            loadLevel(level);
        }
    }

    private boolean isLevelComplete() {
        boolean level = false;
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if(board[r][c] == 1 && board[r][c] == 6) {
                    level = true;
                    break;
                }
            }
        }
        return level;
    }
}