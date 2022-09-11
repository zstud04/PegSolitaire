import java.util.Scanner;

public class PegSolitaire {

    static boolean gameOver = false;

    public static void main(String[] args) {

        System.out.println("\nWELCOME TO CS300 PEG SOLITAIRE!");
        System.out.println("===============================\n");
        Scanner scanText = new Scanner(System.in);
        int board_id = readValidInt(scanText, "Board Style Menu \n" + GameBoard.retrieveBoards(), 4);
        GameBoard board = new GameBoard(board_id);
        board.displayBoard();

        do {
            int column_num = readValidInt(scanText, "Choose the COLUMN of a peg you'd like to move: ",
                    board.board_columns - 1);
            int row_num = readValidInt(scanText, "Choose the ROW of a peg you'd like to move: ", board.board_rows - 1);
            int direction_num = readValidInt(scanText,
                    "Choose a DIRECTION to move that peg 1) UP, 2) DOWN, 3) LEFT, or 4) RIGHT: ", 4);
            
            board.

        } while (gameOver == false);

    }

    // read inputs from the user and repeat prompt if input is invalid
    public static int readValidInt(Scanner in, String prompt, int max) {
        // TODO: IMPLEMENT THIS METHOD
        System.out.println(prompt);
        boolean repeat = true;
        int response = 0;
        while (repeat) {
            try {
                response = in.nextInt();
                if (response > max) {
                    throw new Exception();

                }
                repeat = false;
            } catch (Exception e) {
                System.out.println("You must enter a valid number");
                in.nextLine();

            }
        }

        return response;
    }

    //

    /**
     * This method is used to read in and validate each part of a user’s move
     * choice: the row and column that they wish to move a peg from, and the
     * direction that they would like to move/jump that peg in. When the
     * player’s row, column, and direction selection does not represent a valid
     * move, your program should report that their choice does not constitute a
     * legal move before giving them another chance to enter a different move.
     * They should be given as many chances as necessary to enter a legal move.
     * The array of three integers that this method returns will contain: the
     * user’s choice of column as the first integer, their choice of row as the
     * second integer, and their choice of direction as the third.
     * 
     * @param in    - user input from standard in is ready through this.
     * @param board - the state of the board that moves must be legal on.
     * @return - the user's choice of column, row, and direction representing
     *         a valid move and store in that order with an array.
     */
    public static int[] readValidMove(Scanner in, char[][] board) {
        // TODO: IMPLEMENT THIS METHOD
        return null;
    }

    /**
     * This method checks whether a specific move (column + row + direction) is
     * valid within a specific board configuration. In order for a move to be
     * a valid: 1)there must be a peg at position row, column within the board,
     * 2)there must be another peg neighboring that first one in the specified
     * direction, and 3)there must be an empty hole on the other side of that
     * neighboring peg (further in the specified direction). This method
     * only returns true when all three of these conditions are met. If any of
     * the three positions being checked happen to fall beyond the bounds of
     * your board array, then this method should return false. Note that the
     * row and column parameters here begin with one, and may need to be
     * adjusted if your programming language utilizes arrays with zero-based
     * indexing.
     * 
     * @param board     - the state of the board that moves must be legal on.
     * @param row       - the vertical position of the peg proposed to be moved.
     * @param column    - the horizontal position of the peg proposed to be moved.
     * @param direction - the direction proposed to move/jump that peg in.
     * @return - true when the proposed move is legal, otherwise false.
     */
    public static boolean isValidMove(char[][] board, int row, int column, int direction) {
        // TODO: IMPLEMENT THIS METHOD
        return false;
    }

    /**
     * The parameters of this method are the same as those of the isValidMove()
     * method. However this method changes the board state according to this
     * move parameter (column + row + direction), instead of validating whether
     * the move is valid. If the move specification that is passed into this
     * method does not represent a legal move, then do not modify the board.
     * 
     * @param board     - the state of the board will be changed by this move.
     * @param row       - the vertical position that a peg will be moved from.
     * @param column    - the horizontal position that a peg will be moved from.
     * @param direction - the direction of the neighbor to jump this peg over.
     * @return - the updated board state after the specified move is taken.
     */
    public static char[][] performMove(char[][] board, int row, int column, int direction) {
        // TODO: IMPLEMENT THIS METHOD
        return null;
    }

    /**
     * This method counts up the number of pegs left within a particular board
     * configuration, and returns that number.
     * 
     * @param board - the board that pegs are counted from.
     * @return - the number of pegs found in that board.
     */
    public static int countPegsRemaining(char[][] board) {
        // TODO: IMPLEMENT THIS METHOD
        return 0;
    }

    /**
     * This method counts up the number of legal moves that are available to be
     * performed in a given board configuration.
     * 
     * HINT: Would it be possible to call the isValidMove() method for every
     * direction and from every position within your board? Counting up the
     * number of these calls that return true should yield the total number of
     * moves available within a specific board.
     * 
     * @param board - the board that possible moves are counted from.
     * @return - the number of legal moves found in that board.
     */
    public static int countMovesAvailable(char[][] board) {
        // TODO: IMPLEMENT THIS METHOD
        return 0;
    }

}