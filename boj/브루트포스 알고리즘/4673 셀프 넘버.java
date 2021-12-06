import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		boolean []arr = new boolean[10001];
		int num = 0;
		
		for(int i=1;i<=10000;i++) {
			num = d(i);
			if(num<10001) arr[num] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=10000;i++) if(!arr[i]) sb.append(i+"\n");
		System.out.println(sb);
	}
	
	public static int d(int n) {
		int tmp = n;
		while(n>0) {
			tmp += n%10;
			n=n/10;
		}
		return tmp;
	}
}