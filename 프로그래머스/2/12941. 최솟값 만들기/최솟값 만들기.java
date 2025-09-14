import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int size = A.length;
        for(int i =0; i < A.length; i ++){
            answer += A[i]*B[size-1-i];
        }
        

        return answer;
    }
}