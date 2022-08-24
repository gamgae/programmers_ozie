package 방금그곡;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {

    public static class MusicInfo{

        public String startTime;
        public String endTime;
        public String title;
        public String score;
        public boolean containYn;

        public void setContainYn(boolean containYn) {
            this.containYn = containYn;
        }

        public Boolean getContainYn(){
            return this.containYn;
        }
        public String getEndTime() {
            return endTime;
        }

        public String getTitle() {
            return title;
        }

        public String getScore() {
            return score;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getStartTime(){
            return startTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        /*
        public String startTime;
        public String endTime;
        public String title;
        public String score;
        * */
        public String toString(){
            return "startTime : "+this.startTime
                    +", endTime : "+this.endTime
                    +", title : "+this.title
                    +", containYn : "+this.containYn /*무지 가사가 포함되는지 include*/
                    +", score : ["+score+"]";
        }
    }

    public String sharpToEng(String temp){

        temp = temp.substring(1);
        return temp.toLowerCase();

    }

    public static String solution(String m, String[] musicinfos) throws ParseException {

        /*
        * 1. 노래를 쪼갠다(시작, 종료, 제목, 가사)
        * 종료 - 시작으로 재생된 시간을 구하고,
        * 재생된 시간을 가사의 갯수(주의 #이 붙은 글자는 하나로 쳐야 함)로 나누어 반복재생한 수를 구한다.
        * 전체 가사를 반복재생한 수만큼 또 반복해준다.
        *
        * 2. 무지가 아는 가사와 재생된 노래의 가사를 비교한다
        * => include, contains
        * 원곡 a b c c d
        * 무지 c d e
        * 무지 가사의 앞 글자와 재생된 노래 가사를 각각 한 글자씩 비교해서 맞으면 각각 다음글자를 비교하고
        * 틀리면 다시 무지 가사의 앞글자와 노래 가사의 다음글자를 비교한다.
        * 무지 가사가 끝날때까지 비교한다.
        *
        * 3.
        * contain 2개 ->
        *
        * */


        /*1. 노래를 쪼갠다(시작, 종료, 제목, 가사)*/
        HashMap<String, MusicInfo> musicInfoHashMap = new HashMap<>();
        for(int i=0; i<musicinfos.length; i++){
            String[] temp = musicinfos[i].split(",");
            MusicInfo musicInfo = new MusicInfo();
            musicInfo.setStartTime(temp[0]);
            musicInfo.setEndTime(temp[1]);
            musicInfo.setTitle(temp[2]);

            SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);
            Date d1 = f.parse(musicInfo.getStartTime());
            Date d2 = f.parse(musicInfo.getEndTime());
            long diff = d2.getTime() - d1.getTime();
            long min = diff / 60000;


            String[] tempScore = temp[3].split("");
            String tempScoreStr = "";

            int repeatCnt = (int) Math.ceil ((double) min/tempScore.length);



            for(int k=0; k<repeatCnt; k++){

                for(int j=0; j<tempScore.length; j++){
                    tempScoreStr += tempScore[j];
                }
            }
            musicInfo.setScore(tempScoreStr);


            System.out.println("MUNICINFO start");
            System.out.println(musicInfo.toString());
            System.out.println("MUNICINFO end");

            musicInfoHashMap.put(musicInfo.getTitle(), musicInfo);

            System.out.println("************************");
        }

        /*2. 무지가 아는 가사와 재생된 노래의 가사를 비교한다*/

        boolean containYn = false;
        for(String title : musicInfoHashMap.keySet()){
            MusicInfo musicInfo = musicInfoHashMap.get(title);
            System.out.println("title  : "+musicInfo.getTitle());
            System.out.println("score  : "+musicInfo.getScore());
            System.out.println("muzi m : "+m);

            System.out.println("포함여부 : "+musicInfo.getScore().contains(m));
            containYn = musicInfo.getScore().contains(m);
            musicInfo.setContainYn(containYn);

        }


        /*3. 만약 무지의 가사를 포함한 곡이 2개 이상인 경우.,,
        * 조건이 일치하는 음악이 여러 개일 때에는
        * 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다.
        * 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다
        * */




        String answer = "";
        return answer;
    }

    public static void main(String[] args) throws ParseException {


        String m1 ="ABCDEFG";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String r1 = "HELLO";

        String result = solution(m1, musicinfos1);
        System.out.println(result);
    }
}
