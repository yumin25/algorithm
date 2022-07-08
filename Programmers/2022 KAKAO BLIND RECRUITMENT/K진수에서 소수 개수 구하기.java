import java.util.*;

class Solution {
    public int solution(int n, int k) {
        ArrayList<Integer> arr = notation(n,k);        
        int tmp = 0;
        int answer = 0;
        for(int i:arr){
            if(i==0) {
                if(tmp==0) continue;
                if(prime(tmp)) answer++;
                tmp = 0;
            } else tmp = tmp*10+i;
        }

        if(tmp!=0 && prime(tmp)) answer++;
        return answer;
    }
    
    public ArrayList<Integer> notation(int n, int k){
        ArrayList<Integer> arr = new ArrayList<>();
        while (true){
            arr.add(n%k);
            n /= k;
            if(n<k) {
                arr.add(n);
                break;
            }
        }
        Collections.reverse(arr);
        return arr;
    }
    
    public boolean prime(int n) {
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
}