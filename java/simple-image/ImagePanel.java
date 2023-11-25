/**
 *    ImagePanel.java
 *    @author G. Volger
 *    @date 1/10/10
 *
 *    Creates a panel for the image to be displayed in
 */

import javax.swing.*;
import java.awt.*;
    
public class ImagePanel extends JPanel
{
    private SimpleImage image;
    
    /**
     *    Set the background on the panel to white
     */
    public ImagePanel()
    {
        setBackground(Color.WHITE);
    }
    
    /**
     *    Receives the image to display in the panel
     *    @param img the image to display in the panel
     */
    public void update(SimpleImage img)
    {
        image = img;
        repaint();
    }
    
    /**
     *    Displays the image in the panel
     *    @param g the graphics object to use to display
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (int r = 0; r < image.getWidth(); r++)
        {
            for (int c = 0; c < image.getHeight(); c++)
            {
                // Only 3 posible colors to display - Red, Gren, or Blue
                if (image.getValue(r,c) == 0)
                    g.setColor(Color.RED);
                else if (image.getValue(r,c) == 1)
                    g.setColor(Color.GREEN);
                else
                    g.setColor(Color.BLUE);
                g.drawOval(r, c, 1, 1);    // Gotta be a better way...
            }
        }
    }
}