import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Picture implements Comparable<Picture>{
        int rec;   //추천받은 횟수
        int time;   //게시된 시간
        int number;   //학생 번호

        public Picture(int time, int number){
            super();
            this.time = time;
            this.number = number;
            this.rec = 1;
        }

        @Override
        public int compareTo(Picture o) {
            if(o.rec == rec)  return time - o.time;
            return rec - o.rec;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());    int now;
        ArrayList<Picture> pic = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            now = Integer.parseInt(st.nextToken());
            boolean check = false;
            if(pic.size()<N) {
                for(int j=0;j<pic.size();j++){
                    if(pic.get(j).number == now){
                        pic.get(j).rec++;
                        check = true;
                        break;
                    }
                }
                if(!check) pic.add(new Picture(i, now));
            }
            else {
                for(int j=0;j<pic.size();j++){
                    if(pic.get(j).number == now){
                        pic.get(j).rec++;
                        check = true;
                        break;
                    }
                }
                if(check) continue;
                Collections.sort(pic);
                pic.remove(0);
                pic.add(new Picture(i, now));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<pic.size();i++) answer.add(pic.get(i).number);   //최종 후보 번호 저장
        Collections.sort(answer);
        for(int i=0;i<answer.size();i++) sb.append(answer.get(i) + " ");
        System.out.println(sb);
    }
}