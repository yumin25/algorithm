import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb;
    static int[] answer, arr;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        isSelected = new boolean[N];
        answer = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        sb = new StringBuilder();
        Permutaion(0, 0);

        System.out.println(sb);
    }

    public static void Permutaion(int now, int count){
        if(count==M){
            for(int i:answer) sb.append(i).append(" ");
            sb.append("\n");
        }
        else{
            for(int i=now;i<N;i++) {
                if (isSelected[i]) continue;
                answer[count] = arr[i];
                isSelected[i] = true;
                Permutaion(i+1, count + 1);
                isSelected[i] = false;
            }
        }
    }
}
