
public class GameBoard {

    public int boardId;
    public int board_rows;
    public int board_columns;
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_BLUE = "\u001B[34m";

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
        String ANSI;

        System.out.print(" \n ");
        // print column numbers(starts at 1, not 0)
        for (int i = 0; i < board[0].length; i++) {
            if ((i + 1) % 2 == 0) {
                ANSI = ANSI_GREEN;
            } else {
                ANSI = ANSI_BLUE;
            }
            System.out.print(ANSI + (i + 1) + ANSI_RESET);
        }
        System.out.println("");

        // print row numbers and row values
        for (int i = 0; i < board.length; i++) {

            // print row numbers(starts at 1, not 0)
            System.out.print(i + 1);

            for (int j = 0; j < board[i].length; j++) {
                if (j % 2 == 0) {
                    ANSI = ANSI_BLUE;
                } else {
                    ANSI = ANSI_GREEN;
                }
                System.out.print(ANSI + board[i][j] + ANSI_RESET);
            }
            System.out.println("\n");
        }
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
     * @param column    - the horizontal position of the peg proposed tobe moved.
     * @param direction - the direction proposed to move/jump that peg in.
     * @return - true when the proposed move is legal, otherwise false.
     */

    private static class CoordinatePair {

        public int x = 0;
        public int y = 0;

        private CoordinatePair(int direction) {
            switch (direction) {
                case 4:
                    x = 1;
                    break;
                case 3:
                    x = -1;
                    break;
                case 2:
                    y = 1;
                    break;
                case 1:
                    y = -1;
                    break;

            }
        }

    }

    // private static Pair getMovementVal(int direction) {
    // switch (direction) {
    // case 4:
    // horizontal_movement={1,0};
    // case 3:
    // horizontal_movement = -1;
    // case 2:
    // vertical_movement = -1;
    // case 1:
    // vertical_movement = 1;

    // }
    // }

    // check if the selected space has a peg, if the adjacent space in the specified
    // direction has a peg, and if the space two spaces over in the specified
    // direction is empty
    // if any of these conditions is false, return false
    public boolean isValidMove(int row, int column, int direction) {

        row = row - 1;
        column = column - 1;
        CoordinatePair coords = new CoordinatePair(direction);
        // error handling for piece that is - or beyond bounds

        try {
            if (board[row][column] == '@') {
                if (board[row + coords.y][column + coords.x] == '@') {
                    if (board[row + (coords.y * 2)][column + (coords.x * 2)] == '-') {
                        return true;
                    }
                }
            }
        } catch (Exception e) {

        }

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
    public void performMove(int row, int column, int direction) {

        row = row - 1;
        column = column - 1;

        CoordinatePair coords = new CoordinatePair(direction);
        board[row][column] = '-';
        board[row + coords.y][column + coords.x] = '-';
        board[row + (coords.y * 2)][column + (coords.x * 2)] = '@';

    }

    /**
     * This method counts up the number of pegs left within a particular board
     * configuration, and returns that number.
     * 
     * @param board - the board that pegs are counted from.
     * @return - the number of pegs found in that board.
     */
    public int countPegsRemaining() {
        int peg_counter = 0;

        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[i].length; j++) {
                if (board[i][j] == '@') {
                    peg_counter++;
                }
            }
        }
        return peg_counter;
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
    public int countMovesAvailable() {
        int movesAvailable = 0;
        int lasti = 0;
        int lastj = 0;
        int lastk = 0;

        // iterate over all board spaces
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[i].length; j++) {
                // check if space is a peg
                if (board[i][j] == '@') {
                    // iterate over all possible directions
                    for (var k = 1; k < 5; k++) {
                        if (isValidMove(i + 1, j + 1, k) == true) {
                            movesAvailable++;
                            lasti = i;
                            lastk = k;
                            lastj = j;

                        }
                    }

                }
            }
        }

        return movesAvailable;
    }

}
