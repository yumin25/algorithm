import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		
		for(int i =1;i<t+1;i++) {
            char aa[] = in.readLine().toCharArray();
            char []first= new char[aa.length];
            for(int w =0;w<aa.length;w++) {
                first[w] = '0';
            }
            char tmp = '0';
            int count = 0;
            for(int j =0;j<aa.length;j++) {
                if(first[j] != aa[j]) {
                    count +=1;
                    if(aa[j] == '0') {
                        tmp = '0';
                    }else {
                        tmp = '1';
                    }
                    for(int k =j;k<aa.length;k++) {
                        first[k] = tmp;
                    }
                }
            }
            System.out.println("#"+i +" "+count);
		}
	}
}