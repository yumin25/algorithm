import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N]; int tmp=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++){
            tmp = Integer.parseInt(st.nextToken());
            boolean check = false;
            int left=0, right=N-1, mid=0;
            while(left<=right){
                mid = (left+right)/2;
                if(tmp==arr[mid]) {
                    check = true;
                    break;
                }
                if(tmp<arr[mid]) right=mid-1;
                else left=mid+1;
            }
            if(check)sb.append(1 + " ");
            else sb.append(0 + " ");
        }
        System.out.println(sb.toString());
    }
}