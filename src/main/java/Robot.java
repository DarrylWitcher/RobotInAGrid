import java.util.Scanner;
import java.util.HashMap;

public class Robot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer, String> move = new HashMap<Integer, String>();

        System.out.println("Enter number of grid columns");
        int columns = input.nextInt();

        System.out.println("Enter number of grid rows");
        int rows = input.nextInt();

        int[][] gridEmpty = new int[rows][columns];
        int[][] grid = generateRandomArray(gridEmpty);
        printGrid(grid);

        move.put(0, "The robot has moved Right.");
        move.put(1, "The robot has moved Down.");

        int currentRow = 0;
        int currentColumn = 0;
        int currentPosition = grid[currentRow][currentColumn];
        int endPosition = rows*columns;

        while((currentRow != rows - 1) && (currentColumn != columns)) {
            System.out.println("To move right type 0");
            System.out.println("To move down type 1");
            System.out.println("The robot cannot move to any zero position.");

            int nextMove = input.nextInt();

            if(nextMove == 0) {

                int nextRight = currentColumn + 1;

                //Check the value in the right cell.
                int nextPosition = grid[currentRow][nextRight];
                if(nextPosition == 0) {
                    System.out.println("Invalid move");
                }else if(nextPosition == 1 || nextPosition == 2) {
                    currentColumn = nextRight;
                    currentPosition = grid[currentRow][currentColumn];
                    System.out.println("Right. Robot is now at position [" + currentRow + "][" + currentColumn + "]");
                }else{
                    System.out.println("Wall hit");
                }
            }else if(nextMove == 1) {

                int nextDown = currentRow + 1;
                //Check the value in the right cell.
                int nextPosition = grid[nextDown][currentColumn];
                if(nextPosition == 0) {
                    System.out.println("Invalid move");
                }else if(nextPosition == 1 || nextPosition == 2) {
                    currentRow = nextDown;
                    currentPosition = grid[currentRow][currentColumn];
                    if(currentPosition == grid[rows-1][columns]) {
                        System.out.println("Down. Robot is now at position [" + currentRow + "][" + currentColumn + "]");
                    }
                }else{
                    System.out.println("Wall hit");
                }

            }
        }if (currentPosition == grid[rows][columns]) {
            System.out.println("Task Complete");
        }else {
            System.out.println("Task Failed");
        }
    }

    public static int[][] generateRandomArray(int[][] array) {

        for(int index = 0; index < array.length; index++) {
            for(int index2 = 0; index2 < array[index].length; index2++){
                int number = 0 + (int)(Math.random() * ((2 - 0) + 1))
                        ;
                array[index][index2] = number;
            }
        }
        return array;
    }

    public static void printGrid(int[][] array) {
        for(int index = 0; index < array.length; index++) {
            for(int index2 = 0; index2 < array[index].length; index2++){
                System.out.print(array[index][index2]);
            }
            System.out.println();
        }
}}
