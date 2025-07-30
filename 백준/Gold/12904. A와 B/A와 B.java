
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        StringBuilder s = new StringBuilder(S);
        StringBuilder t = new StringBuilder(T);
        for (int i = t.length() - 1; i > -1; i--) {
            if (i == S.length()-1) {
                break;
            }
            if (t.charAt(i) == 'B') {
                t.deleteCharAt(i);
                t.reverse();
            }
            else {
                t.deleteCharAt(i);
            }
        }

        if (s.toString().contentEquals(t)) {
            System.out.println(1);
        }
        else
            System.out.println(0);
    }
}
