import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> temp;
    public ArrayList<ArrayList<Integer>>  solution(int n) {
        temp = new ArrayList<ArrayList<Integer>>();
        hanoi(n,1,3,2);
        return temp;
    }
    static private void hanoi(int n, int start, int to, int via){
        if(n==1){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(start);
            tmp.add(to);
            temp.add(tmp);
        }
        else{
            hanoi(n-1, start, via, to);
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(start);
            tmp.add(to);
            temp.add(tmp);
            hanoi(n-1, via, to, start);
        }
    }
}