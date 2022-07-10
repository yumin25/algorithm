import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] answer, arr;
    static boolean[] selected;
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        answer = new int[M];
        selected = new boolean[N+1];
        sb = new StringBuilder();
        Permutation(0);
        System.out.println(sb);
    }

    public static void Permutation(int count){
        if(count == M){
            for(int i:answer) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            if(selected[i]) continue;
            selected[i] = true;
            answer[count] = arr[i];
            Permutation(count+1);
            selected[i] = false;
        }
    }
}