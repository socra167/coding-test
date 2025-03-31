import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        String baseNumber = null;
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length; i++) {
            if (baseNumber != null) {
                if (phone_book[i].startsWith(baseNumber)) {
                    return false;
                }
            }
            baseNumber = phone_book[i];
        }
        
        return true;
    }
}