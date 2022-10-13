import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int answer, N, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int []arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i]= Integer.parseInt(st.nextToken());
        answer=0;
        for(int i=1;i<=N;i++){
            int []tmp = new int[i];
            comb(i, 0, 0, arr, tmp);    //1~n개 조합
        }
        System.out.println(answer);
    }	//main

    public static void comb(int n, int cnt, int start, int[] arr, int[] tmp) {
        if(cnt==n) {    //n : 뽑아야 하는 숫자 개수, cnt : 이제껏 뽑은 수의 개수, start : 다음에 시작할 수
            int tmpAnswer = 0;
            for(int i=0;i<n;i++) tmpAnswer+=arr[tmp[i]];
            if(tmpAnswer==S) answer++;
            return;
        }
        for(int i=start;i<N;i++){
            tmp[cnt]=i;
            comb(n,cnt+1, i+1, arr, tmp);
        }
    }
}