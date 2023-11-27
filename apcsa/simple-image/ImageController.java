/**
 *    ImageController.java
 *
 *    @author G. Volger
 *    @date 1/19/10
 *
 *    Creates a frame and places a image panel on the left
 *    and a control panel on the right with 2 buttons.
 *    One button to load a random image, and another button
 *    to simplify the image.  The current pixel block range is also
 *    displayed
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageController extends JFrame implements ActionListener
{
    SimpleImage simImg;
    ImagePanel imagePanel;
    private JTextField blockSize;
    
    /**
     *    Creates the two panels.
     *    Places the image in the left panel.
     *    Places 2 buttons in the right panel and sets up the
     *    listeners.
     */
    public ImageController()
        {
            simImg = new SimpleImage(200, 200);
            // Comment out above line and un-comment line below once you have it working
            //    simImg = new SimpleImage();

            setSize(800, 300);
            setResizable(false);
            setTitle("Simple Image Display");
            
            Container c = getContentPane();
            
            c.setBackground(Color.white);
            c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
            
            imagePanel = new ImagePanel();
            c.add(imagePanel);
            
            JPanel rightPanel = new JPanel();
            JButton newRandom = new JButton("New random Image");
            newRandom.addActionListener(this);
            rightPanel.add(newRandom);
            JButton simplifyImage = new JButton("Simplify Image");
            simplifyImage.addActionListener(this);
            rightPanel.add(simplifyImage);
            blockSize = new JTextField(simImg.getBlockSize()+"    ");
            blockSize.setEditable(false);
            rightPanel.add(blockSize);
            c.add(rightPanel);
            
            imagePanel.update(simImg);
        
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        }

    /**
     *    Button to create new random image and display it
     *    Button to compress current image and display it - prompt for block size
     *    @param e the action event object that knows what just happened
     */
    public void actionPerformed(ActionEvent e)
    {
        String sCommand = (String) e.getActionCommand();
        
        if (sCommand.equals("New random Image"))
        {
            simImg = new SimpleImage(200, 200);
            imagePanel.update(simImg);
        }
        if (sCommand.equals("Simplify Image"))
        {
            String s = JOptionPane.showInputDialog("Block size");
            int bSize = -1;
            try {
                bSize = Integer.parseInt(s);
            } catch (Exception ex)
            {}
            if (bSize < 1)
                return;
            simImg.simplify(bSize);
            imagePanel.update(simImg);
            blockSize.setText(simImg.getBlockSize()+"");
        }        
    }
    
    public static void main(String[] args)
    {
        ImageController theFrame = new ImageController();
        theFrame.setVisible(true);
    }
}