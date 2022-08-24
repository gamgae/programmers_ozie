package 올바른괄호;

/*배열로 바꿔서 풀었을 때
정확성테스트
테스트 1 〉	통과 (0.15ms, 73.8MB)
테스트 2 〉	통과 (0.14ms, 74.9MB)
테스트 3 〉	통과 (0.16ms, 77.9MB)
테스트 4 〉	통과 (0.14ms, 73MB)
테스트 5 〉	실패 (0.16ms, 73.5MB)
테스트 6 〉	통과 (0.17ms, 73.4MB)
테스트 7 〉	통과 (0.16ms, 70.4MB)
테스트 8 〉	통과 (0.19ms, 74.3MB)
테스트 9 〉	통과 (0.19ms, 85.3MB)
테스트 10 〉	통과 (0.16ms, 73.9MB)
테스트 11 〉	실패 (0.18ms, 73.3MB)
테스트 12 〉	통과 (0.38ms, 77.6MB)
테스트 13 〉	통과 (0.28ms, 82.5MB)
테스트 14 〉	통과 (0.53ms, 82.3MB)
테스트 15 〉	통과 (0.31ms, 76.1MB)
테스트 16 〉	통과 (0.39ms, 74.6MB)
테스트 17 〉	통과 (0.47ms, 94.2MB)
테스트 18 〉	통과 (0.44ms, 78.1MB)

효율성테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
* */

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public static boolean stackSolution(String s){
        /*첫번째 자리가 (로 시작하지 않으면 걍 버림*/
        if('('!=s.charAt(0)){
            return false;
        }

        /*마지막 자리가 )로 끝나지 않으면 걍 버림*/
        if(')'!=s.charAt(s.length()-1)){
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<s.length(); i++){
            if("(".equals(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                //if(stack.empty()) return fasle;
                stack.pop();
            }
        }

        return true;

    }

    /*Stack쓰지 않고 푼거*/
    public static boolean solution(String s) {

        int make0 = 0;

        /*첫번째 자리가 (로 시작하지 않으면 걍 버림*/
        if('('!=s.charAt(0)){
            return false;
        }

        /*마지막 자리가 )로 끝나지 않으면 걍 버림*/
        if(')'!=s.charAt(s.length()-1)){
            return false;
        }

        for(int i=0; i<s.length(); i++){

            if('('!=s.charAt(i)){
                make0 ++;
            }else{
                make0 --;
            }

            if(make0>0) return false;

        }

        if(make0==0){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args){

        boolean result1 = solution("()()");
        boolean result2 = solution("(())()");
        boolean result3 = solution("(((())))");
        boolean result4 = solution("(()(");
        boolean result5 = solution("())()(()");

        System.out.println("*******************");
        System.out.println("result1 : "+result1);
        System.out.println("*******************");
        System.out.println("result2 : "+result2);
        System.out.println("*******************");
        System.out.println("result3 : "+result3);
        System.out.println("*******************");
        System.out.println("result4 : "+result4);
        System.out.println("*******************");
        System.out.println("result5 : "+result5);

    }

}
