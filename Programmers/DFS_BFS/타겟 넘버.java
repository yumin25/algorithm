class Solution {
    public static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public void dfs(int[] numbers, int sum, int now, int target){
        if(numbers.length == now) {
            if(sum == target) answer++;
            return;
        }
        dfs(numbers, sum-numbers[now], now+1, target);
        dfs(numbers, sum+numbers[now], now+1, target);
        return;
    }
}