class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (s.length() != 1){
            answer[0]++;
            int length = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '0') answer[1]++;
                else length++;
            }
            s = Integer.toBinaryString(length);  
        }
        return answer;
    }
}