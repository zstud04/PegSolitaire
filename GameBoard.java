public class GameBoard {

    public int boardId;
    public int board_rows;
    public int board_columns;

    public char[][] board;

    // char arrays for Board object templates
    static final char[][] board_cross = { { '#', '#', '#', '@', '@', '@', '#', '#', '#' },
            { '#', '#', '#', '@', '@', '@', '#', '#', '#' },
            { '@', '@', '@', '@', '@', '@', '@', '@', '@' },
            { '@', '@', '@', '@', '-', '@', '@', '@', '@' },
            { '@', '@', '@', '@', '@', '@', '@', '@', '@' },
            { '#', '#', '#', '@', '@', '@', '#', '#', '#' },
            { '#', '#', '#', '@', '@', '@', '#', '#', '#' } };

    static final char[][] board_circle = { { '#', '-', '@', '@', '-', '#' },
            { '-', '@', '@', '@', '@', '-' },
            { '@', '@', '@', '@', '@', '@' },
            { '@', '@', '@', '@', '@', '@' },
            { '-', '@', '@', '@', '@', '-' },
            { '#', '-', '@', '@', '-', '#' } };

    static final char[][] board_triangle = { { '#', '#', '#', '-', '@', '-', '#', '#', '#' },
            { '#', '#', '-', '@', '@', '@', '-', '#', '#' },
            { '#', '-', '@', '@', '-', '@', '@', '-', '#' },
            { '-', '@', '@', '@', '@', '@', '@', '@', '-' } };

    static final char[][] board_simple_t = { { '-', '-', '-', '-', '-' },
            { '-', '@', '@', '@', '-' },
            { '-', '-', '@', '-', '-' },
            { '-', '-', '@', '-', '-' },
            { '-', '-', '-', '-', '-' } };

    // create board template_objects
    static private Board[] board_options = {
            new Board("Cross", board_cross),
            new Board("Circle", board_circle),
            new Board("Triangle", board_triangle),
            new Board("Simple T", board_simple_t)
    };

    // constructor for the class
    public GameBoard(int boardType) {
        boardId = boardType;
        board = createBoard(boardId - 1);
        board_rows = board_options[boardId - 1].rows;
        board_columns = board_options[boardId - 1].columns;

    }

    // create and initialize a game board array and assign it one of the static
    // constants
    public static char[][] createBoard(int boardType) {

        char[][] board_array = new char[0][0];
        board_array = board_options[boardType].board_array;

        return board_array;
    }

    // retrieve a list of all boards to display in a string
    public static String retrieveBoards() {
        String option_string = "";

        for (int i = 0; i < board_options.length; i++) {
            option_string += i + 1 + ") " + board_options[i].board_name + "\n";
        }
        return option_string;
    }

    // print the board in a user readable way with columns and rows labeled
    public void displayBoard() {

        System.out.print(" \n ");
        // print column numbers(starts at 1, not 0)
        for (int i = 0; i < board[0].length; i++) {

            System.out.print(i + 1);
        }
        System.out.println("");

        // print row numbers and row values
        for (int i = 0; i < board.length; i++) {

            // print row numbers(starts at 1, not 0)
            System.out.print(i + 1);

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("\n");
        }
    }

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
