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

}