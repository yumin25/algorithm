import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {   //dp
        int answer = 0;
        int maxA = 0;   int maxC = 0;   int len = problems.length;
        
        for(int i=0;i<len;i++){
            maxA = Math.max(maxA, problems[i][0]);
            maxC = Math.max(maxC, problems[i][1]);
        }
        if(maxA<alp) alp=maxA;
        if(maxC<cop) cop=maxC;
        
        int [][] dp = new int[maxA+2][maxC+2];
        for(int i=0;i<=maxA;i++){
            for(int j=0;j<=maxC;j++) dp[i][j]=Integer.MAX_VALUE;
        }
        
        dp[alp][cop]=0; int nowA, nowC;
        for(int i=alp;i<=maxA;i++){
            for(int j=cop;j<=maxC;j++){
                dp[i][j+1]=Math.min(dp[i][j+1], dp[i][j]+1);
                dp[i+1][j]=Math.min(dp[i+1][j], dp[i][j]+1);
                for(int[] p:problems){  //문제 풀기
                    if(p[0]<=i && p[1]<=j){
                        nowA = i+p[2];
                        nowC = j+p[3];
                        if(nowA>maxA) nowA=maxA;
                        if(nowC>maxC) nowC=maxC;
                        dp[nowA][nowC]=Math.min(dp[nowA][nowC], dp[i][j]+p[4]);
                    }
                }
            }
        }
        return dp[maxA][maxC];
    }
}