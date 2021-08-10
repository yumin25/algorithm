import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int []number = new int[N];
		double sum = 0;
		int max = Integer.MIN_VALUE;	//ÃÖ´ñ°ª
		int min = Integer.MAX_VALUE;	//ÃÖ¼Ú°ª
		
		for(int i=0;i<N;i++) {
			int tmp =  Integer.parseInt(bufferedReader.readLine());
			number[i] = tmp;
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);
			sum +=tmp;
		}
		
		Arrays.sort(number);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int tmp = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {	//¸Ê¿¡ ºóµµ ÀúÀå
			if(number[i]!= tmp) {
				tmp = number[i];
				map.put(tmp, 1);
			}
			else {
				map.put(tmp, map.get(tmp)+1);
			}
		}
		
		int count = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int key : map.keySet()) {
			if(map.get(key) >count) {
				arr = new ArrayList<>();
				arr.add(key);
				count = map.get(key);
			}else if(map.get(key) == count) {
				arr.add(key);
			}
		}
		Collections.sort(arr);
		
		System.out.println(Math.round(sum/N));
		System.out.println(number[N/2]);
		if(arr.size()>=2) {
			System.out.println(arr.get(1));
		}
		else {
			System.out.println(arr.get(0));
		}
		System.out.println(max-min);
	}
}