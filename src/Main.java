import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[][] arr = getOneSolution();
        for (int[] row : arr){
            System.out.println(Arrays.toString(row));
        }
    }
    public static int[][] getOneSolution(){
        int numSolutions = 0;
        int[][] solArr = new int[8][8];
        while (numSolutions != 8){
            numSolutions = 0;
            solArr = new int[8][8];
            fillSpaces(solArr, 0, 0);
            while (!boardFilled(solArr)){
                int r = rand(0, solArr.length - 1);
                int c = rand(0, solArr[0].length - 1);
                boolean validSpace = false;
                while (!validSpace){
                    if (solArr[r][c] == 1 || solArr[r][c] == 8){
                        r = rand(0, solArr.length - 1);
                        c = rand(0, solArr[0].length - 1);
                    } else {
                        validSpace = true;
                    }
                }
                fillSpaces(solArr, r, c);
                numSolutions++;
            }
        }
        System.out.println(numSolutions);
        return solArr;
    }
    public static boolean boardFilled(int[][] arr){
        for (int[] row : arr){
            for (int num : row){
                if (num != 1 && num!= 8){
                    return false;
                }
            }
        }
        return true;
    }
    public static void fillSpaces(int[][] arr, int row, int col){
        fillRow(arr, row, col);
        fillColumn(arr, row, col);
        fillDiag(arr, row, col);
        arr[row][col] = 8;
    }
    public static void fillRow(int[][] arr, int row, int col){
        int r = row;
        int c = col;
        while (c >= 0){
            arr[r][c] = 1;
            c--;
        }
        while (col < arr[0].length){
            arr[row][col] = 1;
            col++;
        }
    }
    public static void fillColumn(int[][] arr, int row, int col){
        int r = row;
        int c = col;
        while (r >= 0){
            arr[r][c] = 1;
            r--;
        }
        while (row < arr.length){
            arr[row][col] = 1;
            row++;
        }
    }
    public static void fillDiag(int[][] arr, int row, int col){
        int r = row;
        int c = col;
        while (r > 0 && c > 0){
            arr[r][c] = 1;
            r--;
            c--;
        }
        while (row < arr.length && col < arr[0].length){
            arr[row][col] = 1;
            row++;
            col++;
        }
    }
    public static int rand(int min, int max){
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
