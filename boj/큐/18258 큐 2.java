import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder stringBuilder = new StringBuilder();
		int back=-1;
		
		for(int i=0;i<N;i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String tmp = stringTokenizer.nextToken();
			
			if(tmp.contains("push")) {
				int push = Integer.parseInt(stringTokenizer.nextToken());
				queue.offer(push);
				back = push;
			}
			else if(tmp.equals("front")) {
				stringBuilder.append(queue.isEmpty()?-1:queue.peek()).append("\n");
			}
			else if(tmp.equals("back")) {
				stringBuilder.append(queue.isEmpty()?-1:back).append("\n");
			}
			else if(tmp.equals("size")) {
				stringBuilder.append(queue.size()).append("\n");
			}
			else if(tmp.equals("empty")) {
				stringBuilder.append(queue.isEmpty()?1:0).append("\n");
			}
			else if(tmp.equals("pop")) {
				stringBuilder.append(queue.isEmpty()?-1:queue.poll()).append("\n");
			}
		}
		System.out.println(stringBuilder);
	}//main
}