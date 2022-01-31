import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int []arr = new int[n];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            boolean check = false;
            if(arr[i]==1) continue;
            for(int j=2;j<=Math.sqrt(arr[i]);j++){
                if(arr[i]%j==0) {
                    check = true;
                    break;
                }
            }
            if(check==false) answer++;
        }
        System.out.println(answer);
    }
}
