import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        str1 = str1.toUpperCase(); str2 = str2.toUpperCase(); char a,b; int j=65536;
        
        for(int i=0;i<str1.length()-1;i++){
            a = str1.charAt(i); b = str1.charAt(i+1);
            if(a<'A' || a>'Z' || b<'A' || b>'Z') continue;
            list1.add(a+ "" +b);
        }
        System.out.println();
        
        for(int i=0;i<str2.length()-1;i++){
            a = str2.charAt(i); b = str2.charAt(i+1);
            if(a<'A' || a>'Z' || b<'A' || b>'Z') continue;
            list2.add(a+ "" +b);
        }
        
        if(list1.size()==0 && list2.size()==0) return 1*j;
        int inter=0, union=0;
        
        for(int i=0;i<list1.size();i++){
            if(list2.contains(list1.get(i))){
                list2.remove(list1.get(i));
                inter++;
            }
        }
        
        union = list1.size() + list2.size();
        double tmp = inter/(double)union*j;
        return (int)tmp;
    }
}