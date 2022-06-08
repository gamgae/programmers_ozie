package 짝지어제거하기;
/*
정확성  테스트 => 어레이리스트로 한거
테스트 1 〉	통과 (0.03ms, 71.3MB)
테스트 2 〉	통과 (15.68ms, 79MB)
테스트 3 〉	통과 (18.41ms, 79.4MB)
테스트 4 〉	통과 (17.80ms, 86MB)
테스트 5 〉	통과 (18.29ms, 78.8MB)
테스트 6 〉	통과 (19.29ms, 80.5MB)
테스트 7 〉	통과 (20.74ms, 97.3MB)
테스트 8 〉	통과 (18.32ms, 83MB)
테스트 9 〉	통과 (0.03ms, 75.9MB)
테스트 10 〉	통과 (0.10ms, 73.3MB)
테스트 11 〉	통과 (0.03ms, 77.1MB)
테스트 12 〉	통과 (0.06ms, 75.8MB)
테스트 13 〉	통과 (0.03ms, 76MB)
효율성  테스트
테스트 1 〉	통과 (131.39ms, 105MB)
테스트 2 〉	통과 (48.12ms, 77.9MB)
테스트 3 〉	통과 (81.72ms, 80.7MB)
테스트 4 〉	통과 (79.66ms, 81MB)
테스트 5 〉	통과 (78.60ms, 81MB)
테스트 6 〉	통과 (81.03ms, 80.9MB)
테스트 7 〉	통과 (78.65ms, 80.8MB)
테스트 8 〉	통과 (92.08ms, 85.6MB)
* */

/*
* 스택으로 구현한거,,, 오히려 위에꺼보다 느려졌다
정확성  테스트
테스트 1 〉	통과 (0.15ms, 75.4MB)
테스트 2 〉	통과 (16.25ms, 80.5MB)
테스트 3 〉	통과 (20.68ms, 89.5MB)
테스트 4 〉	통과 (28.10ms, 89.9MB)
테스트 5 〉	통과 (22.86ms, 80.4MB)
테스트 6 〉	통과 (20.32ms, 83.5MB)
테스트 7 〉	통과 (18.38ms, 84.5MB)
테스트 8 〉	통과 (18.02ms, 82.8MB)
테스트 9 〉	통과 (0.16ms, 80.3MB)
테스트 10 〉	통과 (0.32ms, 73.3MB)
테스트 11 〉	통과 (0.12ms, 78.3MB)
테스트 12 〉	통과 (0.16ms, 70.1MB)
테스트 13 〉	통과 (0.12ms, 78MB)
효율성  테스트
테스트 1 〉	통과 (135.95ms, 97MB)
테스트 2 〉	통과 (57.45ms, 78.3MB)
테스트 3 〉	통과 (92.56ms, 82MB)
테스트 4 〉	통과 (88.25ms, 82.3MB)
테스트 5 〉	통과 (93.13ms, 82.5MB)
테스트 6 〉	통과 (93.41ms, 82.4MB)
테스트 7 〉	통과 (93.26ms, 81.9MB)
테스트 8 〉	통과 (97.63ms, 85.3MB)
* */

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    public static int solution(String s) {
        int answer = -1;
//        ArrayList<String> arrayList = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String t = String.valueOf(s.charAt(i));
            if (stack.size() == 0 || !stack.peek().equals(t)) {
//                arrayList.add(t);
                stack.push(t);
            } else {
                stack.pop();
//                arrayList.remove(arrayList.size()-1);
            }
        }
        if (stack.size() != 0) {
            answer = 0;
        } else {
            answer = 1;
        }

        return answer;
    }

    public static void main(String[] args){
        String s1 = "baabaa";
        int r1 = solution(s1); //1

        String s2 = "cdcd";
        int r2 = solution(s2);
    }

}
