package 최소직사각형;
/*
테스트 1 〉	통과 (0.03ms, 71.7MB)
테스트 2 〉	통과 (0.01ms, 71.8MB)
테스트 3 〉	통과 (0.02ms, 70.3MB)
테스트 4 〉	통과 (0.02ms, 68.3MB)
테스트 5 〉	통과 (0.01ms, 65.1MB)
테스트 6 〉	통과 (0.01ms, 74.1MB)
테스트 7 〉	통과 (0.02ms, 75.3MB)
테스트 8 〉	통과 (0.02ms, 71.9MB)
테스트 9 〉	통과 (0.02ms, 77.1MB)
테스트 10 〉	통과 (0.02ms, 75.4MB)
테스트 11 〉	통과 (0.03ms, 74.5MB)
테스트 12 〉	통과 (0.04ms, 73.6MB)
테스트 13 〉	통과 (0.10ms, 75.7MB)
테스트 14 〉	통과 (0.28ms, 98.5MB)
테스트 15 〉	통과 (0.27ms, 81.8MB)
테스트 16 〉	통과 (0.72ms, 82.8MB)
테스트 17 〉	통과 (0.77ms, 73.6MB)
테스트 18 〉	통과 (0.85ms, 84.1MB)
테스트 19 〉	통과 (0.91ms, 90.2MB)
테스트 20 〉	통과 (1.14ms, 82.3MB)
* */
import java.util.Arrays;

public class Solution {
    public static int solution(int[][] sizes) {

        /*가로는 가로끼리, 세로는 세로끼리 정렬*/
//        for(int i=0; i<sizes.length; i++){
//            int[] temp = sizes[i];
//            if(temp[0] < temp[1]){
//                int tem = temp[0];
//                temp[0] = temp[1];
//                temp[1] = tem;
//            }
//        }

        /*가로 중 제일 큰 길이, 세로 중 제일 큰 길이만 뽑아내기*/
        /*근데 이걸 완전탐색으로 푸는 방법은?!?!*/
        int widthMax = 0;
        int verticalMax = 0;
        for(int i=0; i<sizes.length; i++){
            int[] temp = sizes[i];
            if(widthMax < Math.max(temp[0],temp[1])){
                widthMax = Math.max(temp[0],temp[1]);
            }
            if(verticalMax < Math.min(temp[0],temp[1])){
                verticalMax = Math.min(temp[0],temp[1]);
            }
        }

//        System.out.println(Arrays.deepToString(sizes));
//        System.out.println("widthMax : "+widthMax);
//        System.out.println("verticalMax : "+verticalMax);
        return widthMax * verticalMax;
    }

    public static void main(String[] args){
        int[][] s1 = {{60, 50}, {30, 70}, {60, 30}, {40, 80}};      //4000
        int[][] s2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}; //120

        int r1 = solution(s1);
        int r2 = solution(s2);
    }
}
