//Picture, sound, & different font
import com.badlogic.gdx.ApplicationAdapter; 
import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.audio.*; 
import com.badlogic.gdx.graphics.*; 

//Link to API: https://javadoc.io/doc/com.badlogicgames.gdx/gdx/latest/index.html
//Use control + f to find the class you are looking for in the API
//Use control + f to find the TODO in this project to complete
public class Pong extends ApplicationAdapter//A Pong object IS A ApplicationAdapter
{
    //A Pong object HAS the following attributes:
    private OrthographicCamera camera; //the camera to our world
    private Viewport viewport; //maintains the ratios of your world
    private ShapeRenderer renderer; //used to draw shapes like a pen 
    private BitmapFont font; //used to draw fonts (text)
    private SpriteBatch batch; //also needed to draw fonts (text), or images
    private GlyphLayout layout;//needed to position our text
    private Color penColor; 

    private Sound sound; 
    private Texture background; 

    private Rectangle leftPaddle;//Rectangle object to represent the left paddle
    private Rectangle rightPaddle; //same, Rectangle is a class from libGDX
    private Circle ball; //Circle object to represent the ball (Circle is a class form libGDX)

    private float ballAngle; //holds the angle the ball is traveling
    private boolean started = false; //has the game started yet
    private int player1Score = 0; //keep track of scores
    private int player2Score = 0; 

    //static variables - belong to the entire class. 

    //WORLD_WIDTH and WORLD_HEIGHT proportional to config.width and config.height in GameLauncher class
    public static final float WORLD_WIDTH = 800; 
    public static final float WORLD_HEIGHT = 480;

    //other constants we will need
    public static final float PADDLE_WIDTH = 20; 
    public static final float PADDLE_HEIGHT = 80;
    public static final float RADIUS = 15;
    public static final float PADDLE_SPEED = 10;
    public static final float BALL_SPEED = 10;

    @Override//called once when the game is started (kind of like our constructor)
    public void create(){
        camera = new OrthographicCamera(); //camera for our world, it is not moving
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera); //maintains world units from screen units
        renderer = new ShapeRenderer(); 
        font = new BitmapFont(Gdx.files.internal("oswald-32.fnt")); //Use the name of font in ""
        batch = new SpriteBatch(); 
        layout = new GlyphLayout(font, "Press SPACE_BAR to start");
        penColor = Color.WHITE; 
        //TODO: Optional - replace bounce1.wav with bounce2.wav for a different sound
        //TODO: Optional - find your own sound to play, 
        sound = Gdx.audio.newSound(Gdx.files.internal("bounce1.wav")); 

        //TODO: Optional - replace background1.png with background2.png or background3.png
        //for a different backgrounds
        //TODO: Optional - find your own background,
        background = new Texture(Gdx.files.internal("background1.png")); 

        leftPaddle = new Rectangle(0, 0, PADDLE_WIDTH, PADDLE_HEIGHT); 
        rightPaddle = new Rectangle(WORLD_WIDTH - PADDLE_WIDTH, WORLD_HEIGHT / 2 - PADDLE_HEIGHT / 2,
            PADDLE_WIDTH, PADDLE_HEIGHT);
        ball = new Circle(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, RADIUS); 
        ballAngle = 0; 
    }

    @Override//this is called 60 times a second, all the drawing is in here, or helper
    //methods that are called from here
    public void render(){
        //these two lines wipe and reset the screen so when something action had happened
        //the screen won't have overlapping images
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);//sets the background color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //if the game has started move the ball
        if(started == true)
        {
            moveBall(); 
        }

        //these control the movement of the paddle
        if(Gdx.input.isKeyPressed(Keys.UP))
        {
            rightPaddle.y += PADDLE_SPEED;           
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN))
        {
            rightPaddle.y -= PADDLE_SPEED;           
        }
        //TODO: Look at the code above and have the 'W' key and 'S' key move the left paddle up and down

        //start the game
        if(Gdx.input.isKeyPressed(Keys.SPACE))
        {
            started = true;  
        }

        //make the ball bounce of the top and bottom walls
        if(ball.y + RADIUS > WORLD_HEIGHT)
        {
            ball.y = WORLD_HEIGHT - RADIUS;
            ballAngle *= -1; 
        }
        if(ball.y - RADIUS < 0)
        {
            ball.y = RADIUS; 
            ballAngle *= -1; 
        }

        //TODO: replace false to check for collision with the right paddle 
        //use Intersector.overlaps(ball, rightPaddle) to check for a collision
        if(false)
        {
            bounceOffRightPaddle(); 
            //TODO: call sound.play() to play a custoom sound when a ball hits a paddle
            //TODO: optional change the color of the "pen" by calling changeColor(); 
        }

        //TODO: replace false to check for collision with the left paddle - Intersector.overlaps(ball, leftPaddle)
        if(false)
        {
            bounceOffLeftPaddle(); 
            //TODO: call sound.play() to play a custoom sound when a ball hits a paddle
            //TODO: optional change the color of the "pen" by calling changeColor(); 
        }


        //draw the text and/or images on the screen
        batch.begin();

        drawBackground(); 
        drawText(); 

        batch.end();
        //draw everything on the screen with our renderer (pen)
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeType.Filled);

        drawShapes();

        renderer.end();

    }

    private void moveBall()
    {
        ball.x += BALL_SPEED * MathUtils.cosDeg(ballAngle);//cosine gets the change in x distance
        ball.y += BALL_SPEED * MathUtils.sinDeg(ballAngle); //sine gets the change in y distance
    }

    private void bounceOffRightPaddle()
    {
        float percentOfPaddle = (ball.y - rightPaddle.y) / PADDLE_HEIGHT;;
        ballAngle = 225 - (percentOfPaddle * 90);     
    }

    private void bounceOffLeftPaddle()
    {
        float percentOfPaddle = (ball.y - leftPaddle.y) / PADDLE_HEIGHT;;
        ballAngle = -45 + (percentOfPaddle * 90);
    }

    private void reset()
    {
        ballAngle = 0; 
        started = false; 
        ball.x  = WORLD_WIDTH / 2;
        ball.y = WORLD_HEIGHT / 2;
    }

    private void drawShapes()
    {   
        renderer.setColor(penColor); 
        renderer.rect(leftPaddle.x, leftPaddle.y, leftPaddle.width, leftPaddle.height);
        renderer.rect(rightPaddle.x, rightPaddle.y, rightPaddle.width, rightPaddle.height);
        renderer.circle(ball.x, ball.y, ball.radius);   
    }

    private void changeColor()
    {
        penColor.set((float)Math.random(), (float)Math.random(), (float)Math.random(), 1f);    
    }

    private void drawBackground()
    {
        batch.draw(background, 0, 0, WORLD_WIDTH, WORLD_HEIGHT);    
    }

    private void drawText()
    {
        //only  draw on the screen if the game has not started
        if(started == false)
        {
            layout.setText(font, "Press SPACE_BAR to start");
            font.draw(batch, layout, 
                WORLD_WIDTH / 2 - layout.width / 2, 
                WORLD_HEIGHT/2 + layout.height / 2 + 20);
        }
        else
        {
            layout.setText(font, player1Score + ":" + player2Score);
            font.draw(batch,layout , WORLD_WIDTH / 2 - layout.width / 2, 440); 
        }
    }

    @Override
    public void resize(int width, int height){
        viewport.update(width, height, true); 
    }

    @Override
    public void dispose(){
        renderer.dispose(); 
        batch.dispose(); 
        font.dispose(); 
        sound.dispose(); 
    }
}