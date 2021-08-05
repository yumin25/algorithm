import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		Stack<Integer> tower = new Stack<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		StringBuilder stringBuilder = new StringBuilder();
		int tmp;

		for(int i=1;i<N+1;i++) {
			tmp = (Integer.parseInt(stringTokenizer.nextToken()));
			map.put(tmp, i);
			while(!tower.isEmpty()) {
				if(tower.peek() <= tmp) {
					tower.pop();
				}else {
					stringBuilder.append(map.get(tower.peek()));
					break;
				}
			}
			if(tower.isEmpty()) {
				stringBuilder.append(0);
			}
			tower.add(tmp);
			stringBuilder.append(" ");
		}	
		System.out.println(stringBuilder);
	}
}