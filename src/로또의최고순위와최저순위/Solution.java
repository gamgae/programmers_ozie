package 로또의최고순위와최저순위;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
테스트 1 〉	통과 (1.44ms, 77.3MB)
테스트 2 〉	통과 (1.78ms, 85.1MB)
테스트 3 〉	통과 (1.44ms, 75.5MB)
테스트 4 〉	통과 (1.67ms, 70.8MB)
테스트 5 〉	통과 (1.49ms, 76.1MB)
테스트 6 〉	통과 (1.76ms, 77.4MB)
테스트 7 〉	통과 (1.55ms, 77MB)
테스트 8 〉	통과 (1.56ms, 75.5MB)
테스트 9 〉	통과 (1.46ms, 74.2MB)
테스트 10 〉	통과 (1.67ms, 78.6MB)
테스트 11 〉	통과 (1.84ms, 73.6MB)
테스트 12 〉	통과 (1.53ms, 69.8MB)
테스트 13 〉	통과 (1.64ms, 77.9MB)
테스트 14 〉	통과 (2.23ms, 81MB)
테스트 15 〉	통과 (1.54ms, 74.9MB)
* */

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = new int[2];
        int corr = 0;
        int countZero = 0;

        /* 1. 1등 array를 arrayList로 변환(contains를 사용하기 위해) */
        ArrayList<Integer> winNumArray = (ArrayList<Integer>) Arrays.stream(win_nums)
                .boxed()
                .collect(Collectors.toList());


        for (int i = 0; i < lottos.length; i++) {
            /*2. lottos에서 0인 갯수 확인*/
            if(lottos[i] == 0){
                countZero++;
                continue;
            }
            /*3. lottos 중 win과 일치하는 갯수 확인*/
            if(winNumArray.contains(lottos[i])){
                corr++;
                continue;
            }

        }

        /*결과 리스트 생성*/
        answer[0] = returnPlace(corr + countZero);
        answer[1] = returnPlace(corr);

        return answer;
    }

    public int returnPlace(int lottoCorr) {

        if (lottoCorr == 6) return 1;
        if (lottoCorr == 5) return 2;
        if (lottoCorr == 4) return 3;
        if (lottoCorr == 3) return 4;
        if (lottoCorr == 2) return 5;

        return 6;
    }
    /*
     * 과제형으로 나오는거?!?!
     * 근데 피드백을 안준다...ㅠㅠ
     */

}
