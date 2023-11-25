import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
public class MovingCircle extends ColoredCircle
{
    //No constructor gives default constructor
    //Subclass automatically calls superclass's default constructor
    private float angle;
    private float speed;
    public MovingCircle(float x, float y, float radius, Color c, float angle, float speed)
    {
        super(x, y, radius, c);
        this.angle = angle;
        this.speed = speed;
    }

    public void move() //No parameters needed
    {
        x += MathUtils.cosDeg(angle) * speed;
        y += MathUtils.sinDeg(angle) * speed;
        //Later add logic for bouncing off the walls
        CircleProject x = new CircleProject();
        CircleProject radius = new CircleProject();
        if(this.x - this.radius < 0) { //Bounce off
            x = radius;
        }

        if(this.x - this.radius > 0)
        {
        }
    }
}