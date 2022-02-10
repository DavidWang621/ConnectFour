import java.util.InputMismatchException;
import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) throws InputMismatchException, ArrayIndexOutOfBoundsException{
        Scanner input = new Scanner(System.in);
        String[][] c4 = CreateGrid();
        boolean flag = true;
        int count = 0;
        PrintGrid(c4);
        try {
            while(flag) {
                if (count % 2 == 0) {
                    System.out.println("Drop a red disk at column (0-6): ");
                    int Red = input.nextInt();
                    RedInput(c4, Red);
                } else {
                    System.out.println("Drop a Yellow disk at column (0-6): ");
                    int Yellow = input.nextInt();
                    YellowInput(c4, Yellow);
                }
                PrintGrid(c4);
                count++;
                if (CheckWin(c4) != null) {
                    if (CheckWin(c4).equals("|R")) {
                        System.out.println("The red player won.");
                    } else if (CheckWin(c4).equals("|Y")) {
                        System.out.println("The yellow player won.");
                    }
                    flag = false;
                }
            }
        } catch(InputMismatchException | ArrayIndexOutOfBoundsException ex) {
            System.out.println("Please enter number from 0 - 6");
        }
    }
    public static String[][] CreateGrid() {
        String[][] grid = new String[7][8];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(j < 7) {
                    grid[i][j] = "| ";
                } else{
                    grid[i][j] = "|";
                }
                if(i == 6) {
                    grid[i][j] ="..";
                }
            }
        }
        return grid;
    }
    public static void PrintGrid(String[][] x) {
        for(int i = 0; i < x.length; i++) {
            for(int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j]);
            }
            System.out.println();
        }
    }
    public static void RedInput(String[][] x, int y) {
        for (int i = 6; i > 0; i--) {
            if (x[i][y].equals("| ")) {
                x[i][y] = "|R";
                break;
            }
        }
    }
    public static void YellowInput(String[][] x, int y) {
        for (int i = 6; i > 0; i--) {
            if (x[i][y].equals("| ")) {
                x[i][y] = "|Y";
                break;
            }
        }
    }
    public static String CheckWin(String[][] x) {
        //for horizontal
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (!x[i][j].equals("| ") && !x[i][j + 1].equals("| ") && !x[i][j + 2].equals("| ") && !x[i][j + 3].equals("| ") &&
                        x[i][j].equals(x[i][j + 1]) && x[i][j + 1].equals(x[i][j + 2]) && x[i][j + 2].equals(x[i][j + 3])) {
                    return x[i][j];
                }
            }
        }
        //for vertical
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                if (!x[i][j].equals("| ") && !x[i + 1][j].equals("| ") && !x[i + 2][j].equals("| ") && !x[i + 3][j].equals("| ") &&
                        x[i][j].equals(x[i + 1][j]) && x[i + 1][j].equals(x[i + 2][j]) && x[i + 2][j].equals(x[i + 3][j])) {
                    return x[i][j];
                }
            }
        }
        //for ascending diagonal
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                if (!x[i][j].equals("| ") && !x[i + 1][j - 1].equals("| ") && !x[i + 2][j - 2].equals("| ") && !x[i + 3][j - 3].equals("| ") &&
                        x[i][j].equals(x[i + 1][j - 1]) && x[i + 1][j - 1].equals(x[i + 2][j - 2]) && x[i + 2][j - 2].equals(x[i + 3][j - 3])) {
                    return x[i][j];
                }
            }
        }
        //for descending diagonal
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (!x[i][j].equals("| ") && !x[i + 1][j + 1].equals("| ") && !x[i + 2][j + 2].equals("| ") && !x[i + 3][j + 3].equals("| ") &&
                        x[i][j].equals(x[i + 1][j + 1]) && x[i + 1][j + 1].equals(x[i + 2][j + 2]) && x[i + 2][j + 2].equals(x[i + 3][j + 3])) {
                    return x[i][j];
                }
            }
        }
        return null;
    }
}
