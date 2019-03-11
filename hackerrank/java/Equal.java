import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Equal {

    // Complete the equal function below.
    static int equal(int[] arr) {
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int[] result = new int[3];
        int[][] dp = new int[len][3];
        for(int i=0;i<len;i++){
            if(arr[i] <= min){
                min = arr[i];
            }
        }
        //Arrays.fill(dp, 0);
        Arrays.fill(result, 0);
        int count = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<3;j++){
                int diff = arr[i] - min + j;
                while(true){
                    if(diff >= 5){
                        diff -= 5;
                        dp[i][j]++;
                    }else if(diff >= 2){
                        diff -= 2;
                        dp[i][j]++;
                    }else if(diff >= 1){
                        diff -= 1;
                        dp[i][j]++;
                    }else{
                        break;
                    }
                }
                //System.out.println("i: " + i + " j: " + j + " => " + dp[i][j]);
                result[j] += dp[i][j];
            }
        }
        int resMin = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            if(result[i] <= resMin){
                resMin = result[i];
            }
        }
        return resMin;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = equal(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

