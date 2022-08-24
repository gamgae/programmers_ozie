package 성격유형검사하기;
/*

테스트 1 〉	통과 (2.30ms, 74.5MB)
테스트 2 〉	통과 (2.18ms, 75.5MB)
테스트 3 〉	통과 (2.53ms, 71.8MB)
테스트 4 〉	통과 (2.31ms, 74.8MB)
테스트 5 〉	통과 (3.40ms, 72.7MB)
테스트 6 〉	통과 (2.75ms, 76.5MB)
테스트 7 〉	통과 (4.12ms, 78.8MB)
테스트 8 〉	통과 (3.49ms, 71.1MB)
테스트 9 〉	통과 (3.85ms, 75.8MB)
테스트 10 〉	통과 (4.42ms, 85.6MB)
테스트 11 〉	통과 (3.65ms, 76.4MB)
테스트 12 〉	통과 (5.83ms, 73.6MB)
테스트 13 〉	통과 (11.15ms, 90.9MB)
테스트 14 〉	통과 (10.24ms, 83.3MB)
테스트 15 〉	통과 (11.53ms, 85.7MB)
테스트 16 〉	통과 (10.07ms, 76.7MB)
테스트 17 〉	통과 (10.76ms, 85.7MB)
테스트 18 〉	통과 (9.55ms, 85.4MB)
테스트 19 〉	통과 (9.12ms, 85.1MB)
테스트 20 〉	통과 (9.92ms, 79.7MB)
* */
import java.util.HashMap;

public class Solution {

    public static class KakaoMbti{
        /*지표 - 점수*/
        HashMap<String, Integer> kakaoMbti = new HashMap<>();

        public KakaoMbti(){
            kakaoMbti.put("R",0);
            kakaoMbti.put("T",0);

            kakaoMbti.put("C",0);
            kakaoMbti.put("F",0);

            kakaoMbti.put("J",0);
            kakaoMbti.put("M",0);

            kakaoMbti.put("A",0);
            kakaoMbti.put("N",0);
        }

        public String getMainMbti(){
            String mainMbti = "";
            if(kakaoMbti.get("R") > kakaoMbti.get("T") || kakaoMbti.get("R") == kakaoMbti.get("T")){
                mainMbti += "R";
            }else {
                mainMbti += "T";
            }

            if(kakaoMbti.get("C") > kakaoMbti.get("F") || kakaoMbti.get("C") == kakaoMbti.get("F")){
                mainMbti += "C";
            }else{
                mainMbti += "F";
            }

            if(kakaoMbti.get("J") > kakaoMbti.get("M") || kakaoMbti.get("J") == kakaoMbti.get("M")){
                mainMbti += "J";
            }else{
                mainMbti += "M";
            }

            if(kakaoMbti.get("A") > kakaoMbti.get("N") || kakaoMbti.get("A") == kakaoMbti.get("N")){
                mainMbti += "A";
            }else{
                mainMbti += "N";
            }

            return mainMbti;
        }

        public void addScore(String mbti, int count){
            int score = kakaoMbti.get(mbti);
            kakaoMbti.put(mbti,score + count);
        }

        public String toString(){
            return kakaoMbti.toString();
        }
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";

        KakaoMbti kakaoMbti = new KakaoMbti();

        for(int i=0; i<survey.length; i++){
            System.out.println(survey[i]+", "+choices[i]);

            String tmp[] = survey[i].split("");
            String mbti1 = tmp[0];
            String mbti2 = tmp[1];

            String selectedMbti = "";
            /*유형 계산*/
            if(choices[i] < 4){ /*왼쪽*/
                selectedMbti = mbti1;
            }else if(choices[i] == 4){ /*중도성향*/
                continue;
            }else{ /*오른쪽*/
                selectedMbti = mbti2;
            }

            /*점수 계산*/
            int absCount = Math.abs(4 - choices[i]);
            System.out.println(selectedMbti+","+absCount);

            kakaoMbti.addScore(selectedMbti, absCount);


        }

        System.out.println("[원본 ]: "+kakaoMbti.toString());
        String mainMbti = kakaoMbti.getMainMbti();
        System.out.println("mainMbti : "+mainMbti);

        return mainMbti;
    }

    public static void main(String[] args){
        String[] survey1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices1 = {5, 3, 2, 7, 5};

        String[] survey2 = {"TR", "RT", "TR"};
        int[] choices2 = {7, 1, 3};

        System.out.println("***********************");
        String result1 = solution(survey1, choices1);
        System.out.println("***********************");
        String result2 = solution(survey2, choices2);
        System.out.println("***********************");
    }

}
