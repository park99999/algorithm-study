class Solution {
    static String newMelody(String s){
        String newString = "";
        for(int i =0; i < s.length(); i ++){
            if(i < s.length() -1 && s.charAt(i+1) == '#'){
                char c = (char) ((int)(s.charAt(i) - 'A' + 'a'));
                i ++;
                newString += c;
            }
            else
                newString += s.charAt(i);
        }
        return newString;
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int time = 0;
        String newM = newMelody(m);
 
        for(String s : musicinfos){
            
            String[] infos = s.split(",");
            String[] start = infos[0].split(":");
            String[] end = infos[1].split(":");
            int minute = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60 + Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
            String melody = newMelody(infos[3]);
            String temp = "";
            for(int i =0; i < minute; i ++){
                temp += melody.charAt(i % melody.length());
            }
            //System.out.println(temp);
            if(temp.contains(newM)){
                if(minute > time){
                    answer = infos[2];
                    time = minute;
                }
            }
                   
        }
        if(answer == ""){
            answer = "(None)";
        }
        return answer;
    }
}