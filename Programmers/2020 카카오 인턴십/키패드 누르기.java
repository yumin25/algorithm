class Solution {
    public String solution(int[] numbers, String hand) {
        int left = 10;
        int right = 12;
        StringBuilder answer = new StringBuilder();

        for(int i : numbers){
            if(i == 1 || i == 4 || i == 7) {
                left = i;
                answer.append("L");
            }
            else if(i == 3 || i == 6 || i == 9){
                right = i;
                answer.append("R");
            }
            else{
                if(i == 0) i=11;
                int tmpl = Math.abs(i - left)/3 + Math.abs(i - left)%3;
                int tmpr = Math.abs(i - right)/3 + Math.abs(i - right)%3;

                if(tmpl< tmpr){
                    left = i;
                    answer.append("L");
                }
                else if(tmpl>tmpr){
                    right = i;
                    answer.append("R");
                }
                else if(hand.equals("left")){
                    left = i;
                    answer.append("L");
                }
                else{
                    right = i;
                    answer.append("R");
                }
            }
        }
        
        return answer.toString();
    }
}