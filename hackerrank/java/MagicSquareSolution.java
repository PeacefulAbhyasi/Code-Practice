import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class MagicSquare{
    int[][] matrix;
    MagicSquare(int[][] arr){
        this.matrix = arr;
    }
}

public class MagicSquareSolution {

    static List<MagicSquare> magicMaricsList = new ArrayList<>();
    
    static{
        int[][] arr1 = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
        int[][] arr2 = {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
        int[][] arr3 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
        int[][] arr4 = {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}};
        int[][] arr5 = {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}};
        int[][] arr6 = {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};
        int[][] arr7 = {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}};
        int[][] arr8 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        magicMaricsList.add(new MagicSquare(arr1));
        magicMaricsList.add(new MagicSquare(arr2));
        magicMaricsList.add(new MagicSquare(arr3));
        magicMaricsList.add(new MagicSquare(arr4));
        magicMaricsList.add(new MagicSquare(arr5));
        magicMaricsList.add(new MagicSquare(arr6));
        magicMaricsList.add(new MagicSquare(arr7));
        magicMaricsList.add(new MagicSquare(arr8));
    }
    
    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        Integer minimum = Integer.MAX_VALUE;
        for(MagicSquare obj : magicMaricsList){
            Integer sum = 0;
            int[][] arr = obj.matrix;
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++)
                    sum += Math.abs(s[i][j] - arr[i][j]);
            if(sum < minimum)
                minimum = sum;
        }
        return minimum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

