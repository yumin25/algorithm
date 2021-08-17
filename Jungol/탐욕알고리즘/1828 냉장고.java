import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int [][]arr = new int[N][2];
         
        for(int i=0;i<N;i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arr[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            arr[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
         
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
         
        int answer = 1;
        int end = arr[0][1];
        for(int i=1;i<N;i++) {
            if(end<arr[i][0]) {
                end = arr[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }//main
}