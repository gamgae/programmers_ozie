package 수박수박수박수;

/*
테스트 1 〉	통과 (4.14ms, 79.7MB)
테스트 2 〉	통과 (10.97ms, 87.8MB)
테스트 3 〉	통과 (7.53ms, 85MB)
테스트 4 〉	통과 (19.59ms, 93.4MB)
테스트 5 〉	통과 (5.92ms, 78MB)
테스트 6 〉	통과 (2.71ms, 77.2MB)
테스트 7 〉	통과 (2.19ms, 78.8MB)
테스트 8 〉	통과 (1.79ms, 69MB)
테스트 9 〉	통과 (3.02ms, 79.2MB)
테스트 10 〉	통과 (2.12ms, 75.4MB)
테스트 11 〉	통과 (2.21ms, 78.5MB)
테스트 12 〉	통과 (2.79ms, 67MB)
테스트 13 〉	통과 (2.99ms, 84MB)
테스트 14 〉	통과 (2.39ms, 77MB)
테스트 15 〉	통과 (47.00ms, 123MB)
테스트 16 〉	통과 (2.19ms, 73.4MB)
* */

class Solution {
    public static String solution(int n) {
        String answer = "";

        for(int i=0;i<n;i++){
            if(i%2==0){
                answer+="수";
            }else{
                answer+="박";
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String result = solution(100);
        System.out.println(result);
        //오늘 배운거 자바스크립트도 똑같애
        System.out.println("오지".repeat(10));
    }
}