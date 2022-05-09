package 신고결과받기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
* 시간초과
* */
public class Solution2 {

    public int[] solution(String[] id_list, String[] report, int k) {


        /*1. report 리스트의 중복제거 */
        HashSet<String> reportSet = new HashSet<>();
        for(String rep : report){
            reportSet.add(rep);
        }

        HashMap<String, ArrayList<String>> userReportMap = new HashMap<>();
        HashMap<String, ArrayList<String>> reportUsersMap = new HashMap<>();
        HashMap<String, Integer> mailMap = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            /*사용자 리스트만큼 반복*/
            String user_id = id_list[i];

            mailMap.put(user_id, 0);

            ArrayList<String> tempReportList = new ArrayList<>();
            ArrayList<String> tempUserList = new ArrayList<>();
            for (String s : reportSet) {
                /*신고리스트를 Key-Value값 형태로 구분 후 Key에 맞춰 넣는다*/
                String[] temp = s.split(" ");
                String reporter = temp[0]; /* 신고한사람 */
                String reportee = temp[1]; /* 신고당한사람 */
                if(user_id.equals(reporter)){
                    tempReportList.add(reportee);
                }
                if(user_id.equals(reportee)){
                    tempUserList.add(reporter);
                }
            }
            /*1. 유저ID - 유저가 신고한 ID 형태의 구조체 초기화*/
            userReportMap.put(user_id, tempReportList);
            /*2. 유저ID - 유저를 신고한 ID 형태의 구조체 초기화*/
            reportUsersMap.put(user_id, tempUserList);
        }

        System.out.println("userReportMap : "+userReportMap.toString());
        System.out.println("reportUsersMap : "+reportUsersMap.toString());

        int[] temp = new int[id_list.length];
        /*reportUsersMap(신고당한사람별 신고한사람) 신고횟수를 넘어가는 사용자 확인, k미만인경우 map에서 삭제*/
        int mail = 0;
        for(String key : reportUsersMap.keySet()){
            if(reportUsersMap.get(key).size() >= k){
                System.out.println(key+"는 차단대상임");

                /*userReportMap을 돌면서 key를 신고한 사람의 mailcnt를 올림*/
                int a=0;
                for(String user : userReportMap.keySet()){

                    for(String rep : reportUsersMap.get(user)){
                        System.out.println(key+") ["+user+"] "+rep);
                        if(key.equals(user)) {
                            System.out.println(rep+"의 메일 횟수가 늘어난다 :"+mailMap.get(rep));
                            mailMap.put(rep,mailMap.get(rep)+1);
                        }
                    }
                }

            }
        }
        System.out.println("mailMap : "+mailMap.toString());

        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            String id = id_list[i];
            int mailCnt = mailMap.get(id);
            answer[i] = mailCnt;
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
