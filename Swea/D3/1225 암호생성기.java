import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1;tc<11;tc++) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(n).append(" ");
			int []num = new int[8];
			Queue<Integer> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<8;i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}

			while (true) {
				boolean ch = true;
				for(int i=1;i<6;i++) {
					int tmp = queue.poll();
					tmp -=i;
					if(tmp <= 0) {
						queue.add(0);
						ch = false;
						break;
					}
					queue.add(tmp);
				}
				if(ch == false) {
					break;
				}
			}
			for(int i=0;i<8;i++) {
				sb.append(queue.poll()).append(" ");
			}
			System.out.println(sb);
		}//tc
	}//main	
}