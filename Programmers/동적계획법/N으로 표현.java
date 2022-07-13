import java.util.*;

class Solution {
    public static int n;
    public static List<Integer>[] dp;
    public int solution(int N, int number) {
        dp = new ArrayList[9];
        n = N;
        dp[0] = new ArrayList<>(Arrays.asList(0));
        for(int i=1;i<=8;i++){
            dp(i);
            if(dp[i].contains(number)) return i;
        }
        return -1;
    }
    
    public void dp(int count){
        dp[count] = new ArrayList<>();
        dp[count].add(Integer.parseInt(Integer.toString(n).repeat(count)));
        for(int i=1;i<count;i++){
            for(int a:dp[i]){
                for(int b:dp[count-i]){
                    dp[count].add(a+b);
                    dp[count].add(a-b);
                    dp[count].add(a*b);
                    if(b!=0) dp[count].add(a/b);
                }
            }
        }
    }
}