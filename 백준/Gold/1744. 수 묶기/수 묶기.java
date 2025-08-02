import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> positives = new ArrayList<>();   
        List<Integer> negatives = new ArrayList<>();  
        int ones = 0;                              
        int zeros = 0;                                

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 1) {
                positives.add(x);
            } else if (x == 1) {
                ones++;
            } else if (x == 0) {
                zeros++;
            } else {
                negatives.add(x);
            }
        }
        
        positives.sort(Collections.reverseOrder());
        int result = 0;
        for (int i = 0; i + 1 < positives.size(); i += 2) {
            result += positives.get(i) * positives.get(i + 1);
        }
        if (positives.size() % 2 == 1) {
            result += positives.get(positives.size() - 1);
        }
        
        result += ones;
        
        Collections.sort(negatives);
        for (int i = 0; i + 1 < negatives.size(); i += 2) {
            result += negatives.get(i) * negatives.get(i + 1);
        }
        if (negatives.size() % 2 == 1) {
            if (zeros == 0) {
                result += negatives.get(negatives.size() - 1);
            }
        }
        
        System.out.println(result);
    }
}