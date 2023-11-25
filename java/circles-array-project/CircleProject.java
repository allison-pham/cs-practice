//API Link - https://javadoc.io/doc/com.badlogicgames.gdx/gdx/latest/index.html
//Use probability: regular circle is red (33% chance), ColoredCircle is random color (33%), & MovingCircle is random color (33%)
//Inheritance + arrays
//Bounce off walls
//CircularCircle: allowing Circles to move in a circle pattern
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
import com.badlogic.gdx.utils.*;
import com.badlogic.gdx.*; 
import com.badlogic.gdx.graphics.*; 

//NOTE: Always reset the JVM before compiling (it is the small loop arrow in the
//bottom right corner of the project window)!! 
//First layer is logic, second layer is drawing based on attributes
//Prompt: Everytime you click, there is a random color circle & make the radius random

public class CircleProject extends ApplicationAdapter 
{
    //Everytime we click, we make a circle show up
    //(0,0) is top left, as you go down y is going down
    private OrthographicCamera camera; //the camera to our world
    private Viewport viewport; //maintains the ratios of your world
    private ShapeRenderer renderer; //used to draw textures and fonts 
    private Vector2 screenCoord; //Get mouse position
    private Vector2 worldCoord;
    public static Circle[] circles; //Gets a lot of circles (Circles, ColoredCircles, & MovingCircles)
    private int companion; //Need a companion variable

    public static final float WORLD_WIDTH = 400; 
    public static final float WORLD_HEIGHT = 400;
    public static final int MAX_CIRCLES = 1000;

    @Override//called once when we start the game
    public void create(){
        camera = new OrthographicCamera(); 
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera); 
        renderer = new ShapeRenderer();
        screenCoord = new Vector2();
        worldCoord = new Vector2();
        circles = new Circle[MAX_CIRCLES];
        //Render gets called 60 times per sec
        companion = 0;
    }

    @Override//called 60 times a second
    public void render(){
        //these 2 lines clear the screen and set the background color every FRAME. 
        Gdx.gl.glClearColor(0, 0, 0, 1); //Set background to black
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        screenCoord.x = Gdx.input.getX(); //Gets x location of the mouse
        screenCoord.y = Gdx.input.getY(); //Gets y location of the mouse
        // System.out.println("** screen x: " + screenCoord.x + " screen y: " + screenCoord.y + " **");

        worldCoord = viewport.unproject(screenCoord); //Does all the math, gets mouse position
        // System.out.println("++ world x: " + worldCoord.x + " world y: " + worldCoord.y + " ++");

        if(Gdx.input.justTouched() && companion < MAX_CIRCLES) //If I clicked & there is space in the array, justTouched vs. isTouched
        {
            float r = (float)(Math.random());
            float g = (float)(Math.random());
            float b = (float)(Math.random());
            Color theColor = new Color(r, g, b, 1f); //1f is the transparency
            float randomRadius = (float)(Math.random() * 100 + 5); //5 to 104, casting to a float
            float randomAngle = (float)(Math.random() * 360); //0 - 356
            float randomSpeed = (float)(Math.random()); //0 inclusive to 1 exclusive
            //Add a "Circle" to the array w/ equal probability
            // int chance = (int)(Math.random() * 3 + 1); //1 to 3

            // if(chance == 1) {
            // ColoredCircle circ = new ColoredCircle(worldCoord.x, worldCoord.y, randomRadius, theColor); //Add circle into array
            // circles[companion] = circ;
            // companion++;
            // }

            // else if(chance == 2) {
            MovingCircle circ = new MovingCircle(worldCoord.x, worldCoord.y, randomRadius, theColor, randomAngle, randomSpeed); //Add circle into array
            circles[companion] = circ;
            companion++;
            // }

            // else {
            // circles[companion] = new Circle(worldCoord.x, worldCoord.y, randomRadius);
            // companion++;
            // }
        } //End of click if block
        //Move our circle

        for(Circle element : circles)
        {
            if(element instanceof MovingCircle)
            {
                ((MovingCircle)element).move();
            }
        }

        //Draw based on the updated attributes! Don't update then draw. Update everything then draw
        renderer.begin(ShapeType.Filled);
        // renderer.begin(ShapeType.Line);
        // renderer.setColor(Color.RED);

        //Getting diff colors, if you put diff color before for loop, then it will set it to the color
        //If you want circles to have their own color, color must be an instance variable
        int random = 0;
        for(int i = 0; i<companion; i++) //Default value is null
        {
            Circle temp = circles[i];
            if(temp instanceof ColoredCircle) //MovingCircles are also ColoredCircles
            {
                renderer.setColor(((ColoredCircle)temp).getColor());
            }

            else
            {
                renderer.setColor(Color.RED);
            }
            random = (int)(Math.random() * (50 - 1 + 1) * temp.radius);
            renderer.circle(temp.x, temp.y, temp.radius); //Then draw each circle based on its updated attributes of every frame
        }
        renderer.end();
    }

    @Override
    public void resize(int width, int height){
        viewport.update(width, height, true); 
    }

    @Override
    public void dispose(){
        renderer.dispose(); 
    }
}