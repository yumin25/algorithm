import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('q', 0);	map.put('u', 1);	map.put('a', 2);	map.put('c', 3);	map.put('k', 4);
		char[] duck = bufferedReader.readLine().toCharArray();
		ArrayList<Integer> ducklist = new ArrayList<>();
		int count = 0;
		boolean check = false;
		
		for(int i=0;i<duck.length;i++) {
			check = false;
			if(duck[i] == 'q') {
				ducklist.add(1);
				check = true;
				count = Math.max(count, ducklist.size());
			}
			else {
				for(int j=0; j<ducklist.size(); j++) {
					if(ducklist.get(j) == map.get(duck[i])) {
						if(duck[i] =='k')
							ducklist.remove(j);
						else
							ducklist.set(j, ducklist.get(j)+1);
						check = true;
						break;
					}
				}
			}
			if(check ==false)
				break;
		}
		if(ducklist.isEmpty() && check!=false) System.out.println(count);
		else System.out.println(-1);
	}//main
}