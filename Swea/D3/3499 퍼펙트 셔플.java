import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for(int tc=1;tc<T+1;tc++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("#").append(tc).append(" ");
            String [] cardFront;
            int quotient = N/2;
            int remainder = N%2;
 
            if(remainder == 1) {
                cardFront = new String[quotient+1];
            }
            else {
                cardFront = new String[quotient];
            }
 
            String [] cardBack = new String[quotient];
 
            for(int i=0;i<N;i++) {
                if(i< N/2){
                    cardFront[i] = stringTokenizer.nextToken();
                }
                else if(i == quotient && remainder == 1) {
                    cardFront[i] = stringTokenizer.nextToken();
                }
                else if(i >= quotient && remainder == 0) {
                    cardBack[i-quotient] = stringTokenizer.nextToken();
                }
                else if(i > quotient && remainder == 1) {
                    cardBack[i-quotient-1] = stringTokenizer.nextToken();
                }
            }
 
            for(int i=0;i<quotient;i++) {
                stringBuilder.append(cardFront[i]).append(" ").append(cardBack[i]).append(" ");
            }
            if(remainder == 1) {
                stringBuilder.append(cardFront[quotient]).append(" ");
            }
            System.out.println(stringBuilder);
        }//tc
	}//main	
}