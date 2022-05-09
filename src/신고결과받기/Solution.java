package 신고결과받기;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        /*=========================신고내용 중복처리=========================*/
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        /*=========================신고내용 중복처리=========================*/

        /*================신고받은사람={신고한사람들..}구조만들기====================*/
        HashMap<String, ArrayList<String>> reportUsersMap = new HashMap<>();

        for (String s : reportSet) {
            String[] temp = s.split(" ");
            String reporter = temp[0];/*신고한사람*/
            String reportee = temp[1];/*신고받은사람*/

            ArrayList<String> reporterList = reportUsersMap.getOrDefault(reportee,new ArrayList<>());

            reporterList.add(reporter);
            reportUsersMap.put(reportee, reporterList);
        }
        /*================신고받은사람={신고한사람들..}구조만들기====================*/

        /*=====================신고한사람=메일받을횟수 구조만들기====================*/
        HashMap<String, Integer> alarmMap = new HashMap<>();
        for(ArrayList<String> reporters : reportUsersMap.values()){
            if(reporters.size()>=k){
                for(String reporter : reporters){
                    alarmMap.put(reporter,alarmMap.getOrDefault(reporter,0)+1);
                }
            }
        }
        /*=====================신고한사람=메일받을횟수 구조만들기====================*/

        /*==================id_list순서대로알람횟수구조만들기(결과)==================*/
        int[] answer = new int[id_list.length];
        for(int i=0; i< alarmMap.size(); i++){
            answer[i] = alarmMap.get(id_list[i]);
        }
        /*==================id_list순서대로알람횟수구조만들기(결과)==================*/
        return answer;

    }
}
