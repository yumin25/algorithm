import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int tc=1;tc<t+1;tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char [][]map = new char[h][w];
            int x=0;int y=0; int d=0;
            for(int i=0;i<h;i++) {
                String tmp = br.readLine();
                for(int j=0;j<w;j++) {
                    map[i][j]=tmp.charAt(j);
                    if(map[i][j] == '^') {
                        x=i;y=j;d=1;
                    }else if(map[i][j] == 'v') {
                        x=i;y=j;d=2;
                    }else if(map[i][j] == '<') {
                        x=i;y=j;d=3;
                    }else if(map[i][j] == '>') {
                        x=i;y=j;d=4;
                    }
                }
            }
            
            int n = Integer.parseInt(br.readLine());
            char[] act = new char[n];
            act = br.readLine().toCharArray();
             
            for(int i=0;i<act.length;i++) {
                if(act[i]=='U') {
                    d=1;
                    if(x-1 >= 0 && map[x-1][y] == '.') {
                        map[x][y]='.';
                        x=x-1;
                    }
                    map[x][y]='^';
                }else if(act[i]=='D') {
                    d=2;
                    if(x+1 <h && map[x+1][y] == '.') {
                        map[x][y]='.';
                        x=x+1;
                    }
                    map[x][y]='v';
                }else if(act[i]=='L') {
                    d=3;
                    if(y-1>=0 && map[x][y-1] == '.') {
                        map[x][y]='.';
                        y=y-1;
                    }
                    map[x][y]='<';
                }else if(act[i]=='R') {
                    d=4;
                    if(y+1<w && map[x][y+1] == '.') {
                        map[x][y]='.';
                        y=y+1;
                    }
                    map[x][y]='>';
                }else if(act[i]=='S') {
                    int tmpx=x; int tmpy = y;
                    while (true) {
                        if(d == 1) {
                            tmpx=tmpx-1;
                        }else if(d ==2) {
                            tmpx=tmpx+1;
                        }else if(d==3) {
                            tmpy=tmpy-1;
                        }else if(d==4) {
                            tmpy=tmpy+1;
                        }
                        if(tmpx <0 || tmpy <0 || tmpx>=h || tmpy>=w) {
                            break;
                        }
                        if(map[tmpx][tmpy] == '*') {
                            map[tmpx][tmpy] = '.';
                            break;
                        }else if(map[tmpx][tmpy] == '#') {
                            break;
                        }
                    }
                }
            }
            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    sb.append(map[i][j]);
                }
                if(i !=h-1) {
                    sb.append("\n");
                }
            }
            System.out.println(sb);
        }//tc
    }//main	
}