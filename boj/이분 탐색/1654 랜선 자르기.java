import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int []arr = new int[k];
        long high = 0, low = 1, mid = 0, count = 0;

        for(int i=0;i<k;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > high) high = arr[i];
        }

        while (low <= high) {
            count = 0;
            mid = (high + low)/2;
            for(int i=0;i<k;i++) count += arr[i]/mid;
            if(count < n) high = mid-1;
            else low = mid+1;
        }
        System.out.println(high);
    }
}
