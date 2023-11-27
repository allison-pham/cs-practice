import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
public class ColoredCircle extends Circle
{
    private Color c;

    public ColoredCircle(float x, float y, float radius, Color c)
    {
        super(x, y, radius);
        this.c = c;
    }

    public Color getColor()
    {
        return c;
    }

    public void setColor(Color c)
    {
        this.c = c;
    }
}