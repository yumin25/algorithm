import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long left=0, right=num;
        while(left<=right){
            long mid = (left+right)/2;
            long pow = (long)Math.pow(mid, 2);
            if(pow >= num) right = mid-1;
            else left = mid+1;
        }
        System.out.println(left);
    }
}