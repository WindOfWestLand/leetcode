import java.util.HashMap;
import java.util.Map;

/**
 * Created by 孙亮 on 2017/5/11.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        for(int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            Integer count = 0;
            if(charCount.containsKey(c)) {
                count = charCount.get(c);
            }
            count ++;
            charCount.put(c, count);
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            if(charCount.containsKey(c)) {
                Integer count = charCount.get(c);
                count --;
                charCount.put(c, count);
            } else {
                return false;
            }
        }
        for(Character c : charCount.keySet()) {
            if(charCount.get(c) < 0)
                return false;
        }
        return true;
    }
}
