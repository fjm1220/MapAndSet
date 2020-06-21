package 面试题;
import java.util.HashMap;
import java.util.Map;
class Solution2{
    public int numJewelsInStones(String J, String S) {
    char[] ch = S.toCharArray();
    Map<Character,Integer> map = new HashMap<>();
    for(int i = 0;i < ch.length;i++){
        int value = map.get(ch[i]);
        if(value == 0){
            map.put(ch[i],1);
        }
        else{
            map.put(ch[i],value+1);
        }
    }
    int count = 0;
    for(int j = 0;j < J.length();j++){
        if(map.get(J.charAt(j)) != null){
            count = count+map.get(J.charAt(j));
        }
    }
    return count;
    }
}