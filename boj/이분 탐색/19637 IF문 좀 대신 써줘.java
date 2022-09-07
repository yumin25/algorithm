import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] titleS = new String[N];
        int[] titleI = new int[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            titleS[i] = st.nextToken();
            titleI[i] = Integer.parseInt(st.nextToken());
        }

        int now, l, r;
        for(int i=0;i<M;i++) {
            now = Integer.parseInt(br.readLine());
            l = 0; r = N-1; int middle;
            while(l<=r) {
                middle = (r+l)/2;
                if(now<=titleI[middle]) r = middle-1;
                else l = middle+1;
            }
            sb.append(titleS[l]).append("\n");
        }//for
        System.out.println(sb);
    }
}
