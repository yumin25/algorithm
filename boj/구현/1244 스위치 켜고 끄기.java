import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		num++;
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s[] = new String[num];
		for(int j=1;j<num;j++) {	//스위치 입력받기
			s[j] = st.nextToken();
		}
		
		int studentnum = Integer.parseInt(br.readLine());
		for (int i=0;i<studentnum;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st2.nextToken());
			int givennum = Integer.parseInt(st2.nextToken());
			if (sex == 1) {
				for (int j=1; j<num; j++) {
					if(j%givennum == 0) {
						if(s[j].equals("0")) {
							s[j]= "1"; 
						}else if(s[j].equals("1")){
							s[j]= "0"; 
						}
					}
				}
			}else if (sex == 2){
				int tmp = 1;
				while(true) {
					if((givennum-tmp) <1 || (givennum+tmp)>=num || !(s[givennum-tmp].equals(s[givennum+tmp]))) {
						tmp--;
						break;
					}else if (s[givennum-tmp].equals(s[givennum+tmp])){
						tmp++;
					}
				}
				for(int j=(givennum-tmp);j<=(givennum+tmp);j++) {
					if(s[j].equals("0")) {
						s[j]= "1"; 
					}else if(s[j].equals("1")){
						s[j]= "0"; 
					}
				}
			}
			
		}
		for(int j=1;j<num;j++) {
			Integer.parseInt(s[j]);
			if(j == (num-1)) {
				System.out.print(s[j]);
			}else if(j % 20 == 0){
				System.out.print(s[j]+"\n");
			}else {
				System.out.print(s[j]+ " ");
			}
		}
	}
}