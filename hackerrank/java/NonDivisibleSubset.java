import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NonDivisibleSubset {

    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {
        int[] arr = new int[k+1];
        for(int i=0;i<S.length;i++){
            int a = (int) S[i] % k;
            arr[a] += 1;
        }
        int max = 0;
        if(k == 2){
            for(int i=0;i<k;i++)
                if(arr[i] > 0)
                    max += 1;
            return max;
        }        
        int mid = (k%2==0) ? (k/2) : (int)(k/2)+1;
        max += (arr[0] > 0) ? 1 : 0;
        max += (k%2 == 0 && arr[mid] > 0) ? 1 : 0;
        for(int i=1;i<mid;i++)
            max += (arr[i] > arr[k-i]) ? arr[i] : arr[k-i];
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

