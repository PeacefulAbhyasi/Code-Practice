import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ClimbingLeaderboard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboardOne(int[] scores, int[] alice) {
        int n = scores.length;
        int[] res = new int[alice.length];
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(scores[0]);
        for(int j=1;j<n;j++){
            if(scores[j-1] != scores[j]){
                arr.add(scores[j]);
            }
        }
        Arrays.fill(res, -1);
        for(int i=0;i<alice.length;i++){
            int element = alice[i];
            //System.out.println("Element with index: " + i + " : " + element);
            for(int j=0;j<arr.size();j++){
                //System.out.println("Array Element => " + arr.get(j));
                if(arr.get(j) <= element){
                    res[i] = j+1;
                    break;
                }
            }
            if(res[i] == -1)
                res[i] = arr.size() + 1;
        }
        return res;
    }
    
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int n = scores.length;
        int[] res = new int[alice.length];
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(scores[0]);
        for(int j=1;j<n;j++){
            if(scores[j-1] != scores[j]){
                arr.add(scores[j]);
            }
        }
        Integer[] listArr = new Integer[arr.size()];
        listArr = arr.toArray(listArr);
        for(int i=0;i<alice.length;i++){
            int index = getIndex(listArr, 0, listArr.length-1, alice[i]);
            if(index == -1){
                if(alice[i] > listArr[0])
                    res[i] = 1;
                else
                    res[i] = listArr.length + 1;
            }else{
                res[i] = index + 1;
            }
            //System.out.println("Pointer => " + i + " : X => " + alice[i] + " : Index => " + 
            //    index + " : Result => " + res[i]);
        }
        return res;
    }
    
    private static int getIndex(Integer[] arr, int a, int b, int x){
        if(a > b)
            return -1;
        int mid = (a + b) / 2;
        int left = -1, right = -1;
        if(arr[mid] == x)
            return mid;
        if(mid != arr.length-1 && x < arr[mid] && x > arr[mid+1])
            return mid + 1;
        if(arr[mid] < x)
            left = getIndex(arr, a, mid-1, x);
        else
            right = getIndex(arr, mid+1, b, x);
        return (left >= right) ? left : right;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

