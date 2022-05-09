package 로또의최고순위와최저순위;

/*
테스트 1 〉	통과 (0.02ms, 74.7MB)
테스트 2 〉	통과 (0.01ms, 75.3MB)
테스트 3 〉	통과 (0.02ms, 75MB)
테스트 4 〉	통과 (0.02ms, 80.5MB)
테스트 5 〉	통과 (0.02ms, 76MB)
테스트 6 〉	통과 (0.02ms, 66.9MB)
테스트 7 〉	통과 (0.03ms, 72.7MB)
테스트 8 〉	통과 (0.02ms, 75.5MB)
테스트 9 〉	통과 (0.02ms, 73.2MB)
테스트 10 〉	통과 (0.01ms, 74.3MB)
테스트 11 〉	통과 (0.02ms, 71.6MB)
테스트 12 〉	통과 (0.01ms, 74.1MB)
테스트 13 〉	통과 (0.01ms, 76.9MB)
테스트 14 〉	통과 (0.02ms, 84.2MB)
테스트 15 〉	통과 (0.01ms, 84.4MB)
* */

public class Solution2 {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int corr = 0;
        int countZero = 0;
        for(int i=0; i< lottos.length; i++){

            if(lottos[i] == 0){
                countZero++;
                continue;
            }

            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    corr++;
                    continue;
                }
            }
        }

        answer[0] = (7-(corr + countZero)==7)?6:7-(corr + countZero);
        answer[1] = (7-corr==7)?6:7-corr;;

        return answer;
    }

}