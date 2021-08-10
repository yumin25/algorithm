import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		
		for(int i=0;i<3;i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int tmpx = Integer.parseInt(stringTokenizer.nextToken());
			int tmpy = Integer.parseInt(stringTokenizer.nextToken());
			
			if(x1 == 0) x1=tmpx;
			else if (x1==tmpx) x1 = -1;
			else if (x2 == 0) x2=tmpx;
			else if (x2==tmpx) x2 = -1;
			
			if(y1 == 0) y1=tmpy;
			else if (y1 ==tmpy) y1 = -1;
			else if (y2 == 0) y2=tmpy;
			else if (y2 ==tmpy) y2 = -1;
		}
		x1 = Math.max(x1, x2);
		y1 = Math.max(y1, y2);
		System.out.println(x1 +" "+y1);
	}
}