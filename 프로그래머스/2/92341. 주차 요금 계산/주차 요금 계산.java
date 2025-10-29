import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<Integer, Integer> parking = new HashMap<>(); 
        HashMap<Integer, Integer> fee = new HashMap<>();  
        
        for(String record : records){
            String[] infos = record.split(" ");
            String[] time = infos[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            int plateNumber = Integer.parseInt(infos[1]);
            String state = infos[2];
            int t = hour * 60 + minute;
            
            if(state.equals("IN")){
                parking.put(plateNumber, t);
                if(!fee.containsKey(plateNumber)) fee.put(plateNumber, 0);
            }else{ // OUT
                int inTime = parking.get(plateNumber);
                fee.put(plateNumber, fee.get(plateNumber) + (t - inTime)); 
                parking.remove(plateNumber); 
            }
        }
        
        int end = 23 * 60 + 59;
        for (Integer plateNumber : parking.keySet()) {
            int inTime = parking.get(plateNumber);
            fee.put(plateNumber, fee.getOrDefault(plateNumber, 0) + (end - inTime));
        }
        
        int basic_min = fees[0];
        int basic_fee = fees[1];
        int unit_min = fees[2];
        int unit_fee = fees[3];

        ArrayList<Integer> plates = new ArrayList<>(fee.keySet());
        Collections.sort(plates);
        for (Integer plateNumber : plates) {
            int time = fee.get(plateNumber);       
            int total_fee = basic_fee;  
            int use_time = time - basic_min;
            if (use_time > 0) {
                int units = (use_time + unit_min - 1) / unit_min; 
                total_fee += units * unit_fee;      
            }
            answer.add(total_fee);
        }

        return answer;
    }
}