import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); int type=0, a=0, b=0;
        int []arr = new int[n+1];
        for(int i=0;i<=n;i++) arr[i]=i;
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            type = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (type == 0) union(arr, a, b);
            else if (type == 1) {
                if(parentCheck(arr, a, b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }	//main

    public static void union(int []arr, int a, int b){
        int pA = parent(arr,a);
        int pB = parent(arr,b);
        if(pA<=pB) arr[pB]=pA;
        else arr[pA]=pB;

    }

    public static boolean parentCheck(int []arr, int a, int b){
        int pA = parent(arr,a);
        int pB = parent(arr,b);
        if(pA==pB) return true;
        return false;
    }

    public static int parent(int []arr, int a){
        if(arr[a]==a) return a;
        return arr[a]=parent(arr, arr[a]);
    }
}