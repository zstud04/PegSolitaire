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

}
