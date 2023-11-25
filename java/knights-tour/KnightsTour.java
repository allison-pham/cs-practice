import apcslib.*;
import java.util.*;
public class KnightsTour {
    private int[][] board;
    private int ctr;
    private int kR; //knightsRow
    private int kC; //knightsCol
    private ArrayList<Integer> possRow; //Possible rows
    private ArrayList<Integer> possCol; //Possible columns
    private int[] combRow = {2, 1, -2, 1, 2, -2, 2, -1}; //Send in 8
    private int[] combCol = {1, 2, 1, -2, -1, 1, -1, 2}; //Send in 8
    public KnightsTour() { //Initialize properly!
        board = new int[8][8];
        ctr = 1; //Assign next value to ctr at 2 b/c already starting at R1, C1
        kR = 0;
        kC = 0;
        possRow = new ArrayList<Integer>();
        possCol = new ArrayList<Integer>();
    }
    //Horizontal move changes the column and a vertical move changes the row

    public void board() {
        int row = 0;
        int col = 0;
        int r = 0;
        int c = 0;
        int ctr = 0;
        while(ctr<64) {
            //for(int amount = 1; amount<64; amount++) {
            List<Integer> movesStorage = new ArrayList<Integer>();
            for(int i = 0; i<8; i++) {
                r = row+combRow[i];
                c = col+combCol[i];
                if(check(r, c)) { //r>=0 && r<8 && c>=0 && c<8) {
                    //if(kR - 1 >= 0 && kC + 2 < board[0].length && board[kR - 1][kC+2] == 0) {
                    movesStorage.add(i);
                }
            }
            if(movesStorage.size() == 0) {
                break;
            }
            int random = (int)(Math.random() * movesStorage.size()); //Don't +1
            int moveAtPosition = movesStorage.get(random);
            row+=combRow[moveAtPosition];
            col+=combCol[moveAtPosition];
            ctr++;
            board[row][col] = ctr;
        }
        print();
        System.out.println("\n" + ctr + " squares were visited");
    }

    // public int getPossMoves(int randomMove) { //Helper method
    // //Takes one element out randomly
    // return randomMove;
    // }

    // private boolean canMove() { //Helper method
    // while(canMove()) {
    // if(kR - 1 >= 0 && kC + 2 < board[0].length && board[kR - 1][kC+2] == 0) {
    // //Checks if you can move a space
    // //fillPossibilityList()
    // //selectMoveRandomly
    // //move
    // print();
    // //resetPossibility
    // }
    // }
    // }

    private boolean check(int a, int b) {
        return (a >= 0 && a < 8 && b >= 0 && b < 8 && board[a][b] == 0);
    }

    private void print() {
        //"2 squares were visited"
        System.out.print("  ");
        for (int i = 0; i<8; i++) {
            int store1 = i+1;
            System.out.print(Format.right(store1, 3)); //1 & 2 doesn't work
        }
        System.out.println();
        for (int row = 0; row<8; row++) {
            int store2 = row+1;
            System.out.print(Format.right(store2, 3));
            // System.out.print(Format.right((store1), 2)); //1 & 2 doesn't work
            for (int col = 0; col<8; col++) {
                int store3 = board[row][col];
                System.out.print(Format.right(store3, 3)); //1 & 2 doesn't work
            }
            System.out.println();
        }
        System.out.println();
    }
}
