import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] answer;
    static boolean[] selected;
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[M];
        selected = new boolean[N+1];
        sb = new StringBuilder();
        Permutation(0);
        System.out.println(sb);
    }

    public static void Permutation(int count) {
        if(count==M) {
            for(int i:answer) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=1;i<=N;i++) {
            answer[count] = i;
            Permutation(count+1);
        }
    }
}