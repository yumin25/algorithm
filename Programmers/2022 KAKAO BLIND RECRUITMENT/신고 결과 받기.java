import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int []answer = new int[id_list.length];
		HashMap<String, HashSet<String>> map = new HashMap<>(); //유저 별 신고한 사람
		HashMap<String, Integer> memberMap = new HashMap<>();   //유저 별 id_list에서 몇 번째인지 저장
		for(int i=0;i<id_list.length;i++) memberMap.put(id_list[i], i);
		
		String []tmpMember;
		for(int i=0;i<report.length;i++) {
			tmpMember = report[i].split(" ");
			if(!map.containsKey(tmpMember[1])) {
				map.put(tmpMember[1], new HashSet<>());
			}
			map.get(tmpMember[1]).add(tmpMember[0]);
		}
		
		int tmpNum=0;
		for(String s:id_list) {
			if(map.containsKey(s) && map.get(s).size()>=k) {
				for(String ss:map.get(s)) {
					tmpNum = memberMap.get(ss);
					answer[tmpNum]++;
				}
			}
		}
		return answer;
    }
}