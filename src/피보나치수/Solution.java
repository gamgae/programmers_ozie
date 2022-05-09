package 피보나치수;

import java.util.Arrays;

/*
테스트 1 〉	통과 (0.02ms, 78.5MB)
테스트 2 〉	통과 (0.02ms, 71MB)
테스트 3 〉	통과 (0.02ms, 74.6MB)
테스트 4 〉	통과 (0.02ms, 84.3MB)
테스트 5 〉	통과 (0.02ms, 74.4MB)
테스트 6 〉	통과 (0.02ms, 76MB)
테스트 7 〉	통과 (0.07ms, 77.6MB)
테스트 8 〉	통과 (0.08ms, 76.4MB)
테스트 9 〉	통과 (0.60ms, 78.1MB)
테스트 10 〉	통과 (0.07ms, 72.4MB)
테스트 11 〉	통과 (0.05ms, 77.2MB)
테스트 12 〉	통과 (0.06ms, 71MB)
테스트 13 〉	통과 (3.77ms, 76.6MB)
테스트 14 〉	통과 (2.38ms, 76.8MB)
* */

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] fArray = new int[n+1];
        fArray[0] = 0;
        fArray[1] = 1;

        for(int i=2; i<=n; i++){
            fArray[i] = (fArray[i-1] + fArray[i-2]) % 1234567;
        }
        answer = fArray[n];
        return answer;
    }

}
/*
*
//n=4
        //F4 = F3 + F2
        //F4 = F2 + F1 + F2
        //F4 = F1 + F0 + F1 + F2
        //F4 = F1 + F0 + F1 + F1 + F0

        //F5 = F4 + F3
        //F5 = F1 + F0 + F1 + F1 + F0 + F1 + F1 + F0

* */