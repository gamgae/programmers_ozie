package 영어끝말잇기;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
/*
테스트 1 〉	통과 (0.36ms, 73.9MB)
테스트 2 〉	통과 (0.39ms, 76.4MB)
테스트 3 〉	통과 (0.29ms, 76.8MB)
테스트 4 〉	통과 (0.35ms, 76.1MB)
테스트 5 〉	통과 (0.38ms, 79.2MB)
테스트 6 〉	통과 (0.33ms, 78.4MB)
테스트 7 〉	통과 (0.32ms, 73.9MB)
테스트 8 〉	통과 (0.35ms, 77.4MB)
테스트 9 〉	통과 (0.24ms, 73.5MB)
테스트 10 〉	통과 (0.38ms, 76.2MB)
테스트 11 〉	통과 (0.32ms, 83.3MB)
테스트 12 〉	통과 (0.34ms, 71.5MB)
테스트 13 〉	통과 (0.22ms, 73.5MB)
테스트 14 〉	통과 (0.22ms, 74.6MB)
테스트 15 〉	통과 (0.21ms, 72.2MB)
테스트 16 〉	통과 (0.24ms, 84MB)
테스트 17 〉	통과 (0.38ms, 75.7MB)
테스트 18 〉	통과 (0.22ms, 75.9MB)
테스트 19 〉	통과 (0.23ms, 76.6MB)
테스트 20 〉	통과 (0.78ms, 78.6MB)
* */

class Solution {

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
//
        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.add(words[0]);

        int num = 0;  /*번호(사람의 번호)*/
        int sun = 0;  /*순번(몇회차인가)*/
        for(int i=1; i<words.length; i++){
            num = i%n+1;
            sun = (int) Math.ceil(i/n+1);

            System.out.println("beforeWord : "+words[i-1]+", nowWord : "+words[i]);

            /*1. 앞 단어의 끝글자와 지금 단어의 첫 글자 비교*/
            String beforeWord = String.valueOf(words[i-1].charAt(words[i-1].length()-1));
            String nowWord = String.valueOf(words[i].charAt(0));

            if(!beforeWord.equals(nowWord)){
                System.out.println("끝말잇기 안됨");
                break;
            }
            /*2. 지금까지 나왔던 단어들과 커서의 단어를 비교*/

           /* List<String> oldWords = Arrays.asList(Arrays.copyOf(words,i-1));
            * i-1번째까지 한 단어를 담는 배열을 매번 만드는 것도 해봤는데 효율이 좋지않았음
            * 1) copyOf
            * 2) asList
            * 3) contains 하면서 총 3회를 반복하게 되기 때문이 아닐까?
            * */

            if(wordsList.contains(words[i])){
                System.out.println("이미 했음");
                break;
            }

            /*끝까지 다 했으면 0,0으로*/
            if(i==words.length-1){
                num=0;
                sun=0;
                break;
            }

            wordsList.add(words[i]);

        }
        answer[0] = num;
        answer[1] = sun;


        return answer;
    }

    public static void main(String[] args) {
        int n1 = 3;
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] result1 = solution(n1, words1);
        System.out.println(Arrays.toString(result1));

        System.out.println("######################");

        int n2 = 5;
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int[] result2 = solution(n2,words2);
        System.out.println(Arrays.toString(result2));


        System.out.println("######################");

        int n3 = 2;
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] result3 = solution(n3,words3);
        System.out.println(Arrays.toString(result3));

        System.out.println("######################");

        int n4 = 2;
        String[] words4 = {"land", "dream", "mom", "mom", "ror"};
        int[] result4 = solution(n4,words4);
        System.out.println(Arrays.toString(result4));

    }
}
