public class notes {
    public static void main(String[] args) {
        int[] oldArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] newArray = new int[3][3];

        int row = 0;
        int col = 0;
        for(int value : oldArray) {
            newArray[row][col] = value;
            row++;
            if((row % 3) == 0) {
                col++;
                row = 0;}
        }
        System.out.println(newArray[0][2]);
    }
}