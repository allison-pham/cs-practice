import java.util.List;
import java.util.ArrayList;

public class SimpleImage
{
    private int[][] image;
    private int pixelBlock;
    private int width;
    private int height;
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;    

    /**
     *    Creates a random 160 x 160 pixel image that when it is deciphered
     *    by a block size of 16 produces a secret message.
     */
    public SimpleImage()
    {
        pixelBlock = 1;
        width = 160;
        height = 160;
        image = new int[width][height];
        int[][] block;
        int blockSize = 16;
        for (int x = 0; x < width; x += blockSize)
            for (int y = 0; y < height; y += blockSize)
            {
                block = randomBlock(blockSize, GREEN);
                copyBlock(x, y, blockSize, block);
            }
        block = randomBlock(blockSize, BLUE);   copyBlock(16, 0, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(32, 0, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(48, 0, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(96, 0, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(112, 0, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(128, 0, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(16, 16, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(48, 16, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(96, 16, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(128, 16, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(16, 32, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(32, 32, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(48, 32, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(96, 32, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(112, 32, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(128, 32, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(16, 48, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(48, 48, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(96, 48, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(16, 64, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(48, 64, blockSize, block);
        block = randomBlock(blockSize, BLUE);   copyBlock(96, 64, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(16, 80, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(32, 80, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(48, 80, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(80, 80, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(96, 80, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(112, 80, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(16, 96, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(80, 96, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(16, 112, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(96, 112, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(16, 128, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(112, 128, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(16, 144, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(32, 144, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(48, 144, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(80, 144, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(96, 144, blockSize, block);
        block = randomBlock(blockSize, RED);    copyBlock(112, 144, blockSize, block);
    }    

    /**
     *    Copies the the random block created into the image.
     *    @param xStart starting x coordinate to copy block into
     *    @param yStart starting y coordinate to copy block into
     *    @param blcokSize the size of the block in pixels to copy
     *    @block the block of pixels to copy
     */
    private void copyBlock(int xStart, int yStart, int blockSize, int[][] block)
    {
        for (int x = xStart; x < xStart + blockSize; x++)
            for (int y = yStart; y < yStart + blockSize; y++)
                image[x][y] = block[x-xStart][y-yStart];
    }

    /**
     *    Produces a random block of the size indiacted to produce the color desired
     *    @param size the block size to make the random colors in
     *    @param color the color that will occur most in this block
     *    @return returns a size x size block (array) with the most colors containing in it is color
     */
    private int[][] randomBlock(int size, int color)
    {
        int[][] block = new int[size][size];
        List<Integer> colors = new ArrayList<Integer>(size*size);
        int total = size * size;
        int majority = total / 3 + 1;
        int minority1 = (total - majority) / 2;
        int minority2 = total - majority - minority1;
        //System.out.println("total = " + total + " majority = " + majority + " minority1 = " + minority1 + " minority2 = " + minority2);    // debug
        for (int k = 0; k < majority; k++)
            colors.add(color);
        if (color == RED)
        {
            // Put blue and green in other spots
            for (int k = 0; k < minority1; k++)
                colors.add(BLUE);
            for (int k = 0; k < minority2; k++)
                colors.add(GREEN);
        }
        else if (color == GREEN)
        {
            // Put blue and red in other spots
            for (int k = 0; k < minority1; k++)
                colors.add(BLUE);
            for (int k = 0; k < minority2; k++)
                colors.add(RED);
        }
        else
        {
            // Put green and red in other spots
            for (int k = 0; k < minority1; k++)
                colors.add(RED);
            for (int k = 0; k < minority2; k++)
                colors.add(GREEN);
        }
        // Fill the block with random colors from the List
        for (int r = 0; r < block.length; r++)
            for (int c = 0; c < block[r].length; c++)
            {
                int loc = (int) (Math.random() * colors.size());
                block[r][c] = colors.remove(loc);                
            }

        return block;
    }

    /**
     *    Create a random image of red, green and blue
     *    of the size passed
     *    @param theWidth width in pixles of image
     *    @param theHeight height in pixels of image
     */
    public SimpleImage(int theWidth, int theHeight)
    {
        pixelBlock = 1;
        width = theWidth;
        height = theHeight;
        image = new int[width][height];
        for (int r = 0; r < image.length; r++)
            for (int c = 0; c < image[0].length; c++)
                image[r][c] = (int)(Math.random()*3);
    }

    /**
     *    Returns the block size used for this image
     *    @return returns the block size for this image
     */
    public int getBlockSize()
    {
        return pixelBlock;
    }

    /**
     *    Returns the width of this image
     *    @return returns the width of this image
     */
    public int getWidth()
    {
        return width;
    }

    /**
     *    Returns the height of this image
     *    @return returns the height of this image
     */
    public int getHeight()
    {
        return height;
    }

    /**
     *    Changes the current image to the block size passed
     *    @param blockSize new bloock size for the image
     */
    public void simplify(int blockSize)
    {
        for(int r = 0; r < image.length; r++) {
            int ctr1 = 0;
            int ctr2 = 0;
            for(int c = 0; c < image[0].length; c++) {
                //to do: image[r][c]
                // image[r][c] = blockSize;
                if(blockSize == 4) {
                    image[r][c] = blockSize;
                    ctr1++;
                    ctr2+=3;
                    image[r+ctr1][c+ctr2] = blockSize;
                    ctr1++;
                    image[r+ctr1][c+ctr2] = blockSize;
                    ctr1++;
                    image[r+ctr1][c+ctr2] = blockSize;
                }
                /*int[][] image
                int pixelBlock, width,  height, RED (0), GREEN (1), BLUE (2)*/
            }
        }
    }

    /**
     *    Which of the 3 colors is greatest
     *    @param array an array of color counts
     *    @return returns the index that indicates which color count
     *            is the greatest in teh array
     */
    private int maxColor(int[] array)
    {
        int max = 0;
        for (int k = 1; k < array.length; k++)
            if (array[k] > array[max])
                max = k;
        return max;
    }

    /**
     *    Returns the color value at a given location
     *    @param r the row (x-coordinate)
     *    @param c the column (y-coordinate)
     *    @return returns the color value at the give corrdinate passed
     */
    public int getValue(int r, int c)
    {
        return image[r][c];
    }
}