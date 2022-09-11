public class Board {
    public String board_name;
    public char[][] board_array;
    public int columns;
    public int rows;

    public Board(String name, char[][] array) {
        board_name = name;
        board_array = array;
        // get the number of rows and columns for a board
        rows = array.length + 1;
        columns = array[0].length + 1;

    }
}
