class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isNewWord = true;
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                answer.append(ch);
                isNewWord = true;
            } else if (isNewWord) {
                answer.append(Character.toUpperCase(ch));
                isNewWord = false;
            } else {
                answer.append(Character.toLowerCase(ch));
            }
        }
        
        return answer.toString();
    }
}