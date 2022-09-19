import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int []arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int low=0, high = 0, mid=0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]);
        }

        while(low<=high){
            mid = (low+high)/2;
            long sum = 0;
            for(int i=0;i<N;i++) {
                if(arr[i]-mid>0) sum += arr[i]-mid;
            }
            if(sum<M) high=mid-1;
            else low=mid+1;
        }
        System.out.println(high);
    }
}