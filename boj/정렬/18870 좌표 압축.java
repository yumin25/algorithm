import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int []arr = new int[N];
		int []arrTmp = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(stringTokenizer.nextToken());
		}
		arrTmp = arr.clone();
		Arrays.sort(arrTmp);
		
		int count = 0;
		for(int i : arrTmp) {	//정렬 뒤 새로운 값이 나타날 때마다 count++을 해준다.
			if(!map.containsKey(i)) map.put(i, count++);
		}

		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i:arr) {
			stringBuilder.append(map.get(i)).append(" ");
		}
		System.out.println(stringBuilder);
	}
}