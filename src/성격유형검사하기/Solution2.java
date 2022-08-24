package 성격유형검사하기;
import java.util.HashMap;

public class Solution2 {

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
            mainMbti += kakaoMbti.get("R") >= kakaoMbti.get("T") ? "R" : "T";
            mainMbti += kakaoMbti.get("C") >= kakaoMbti.get("F") ? "C" : "F";
            mainMbti += kakaoMbti.get("J") >= kakaoMbti.get("M") ? "J" : "M";
            mainMbti += kakaoMbti.get("A") >= kakaoMbti.get("N") ? "A" : "N";

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
