package 신고결과받기;

import java.util.*;
/*
* 시간초과
테스트 1 〉	통과 (0.22ms, 73.4MB)
테스트 2 〉	통과 (0.79ms, 67.7MB)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	통과 (1.06ms, 69.7MB)
테스트 5 〉	통과 (1.17ms, 74.8MB)
테스트 6 〉	통과 (36.79ms, 106MB)
테스트 7 〉	통과 (62.09ms, 108MB)
테스트 8 〉	통과 (81.86ms, 105MB)
테스트 9 〉	통과 (7400.23ms, 401MB)
테스트 10 〉	통과 (9084.60ms, 418MB)
테스트 11 〉	실패 (시간 초과)
테스트 12 〉	통과 (25.23ms, 96MB)
테스트 13 〉	통과 (24.30ms, 96.1MB)
테스트 14 〉	실패 (시간 초과)
테스트 15 〉	실패 (시간 초과)
테스트 16 〉	통과 (10.52ms, 89.4MB)
테스트 17 〉	통과 (27.20ms, 93.3MB)
테스트 18 〉	통과 (94.67ms, 97.5MB)
테스트 19 〉	통과 (69.28ms, 119MB)
테스트 20 〉	실패 (시간 초과)
테스트 21 〉	실패 (시간 초과)
테스트 22 〉	통과 (0.25ms, 73.9MB)
테스트 23 〉	통과 (0.18ms, 74.2MB)
테스트 24 〉	통과 (0.18ms, 75.5MB)
* */

public class Solution3 {

        public int[] solution(String[] id_list, String[] report, int k) {

            System.out.println("id_list : "+ Arrays.toString(id_list));

            HashSet<String> reportSet = new HashSet<>();
            for(String rep : report){
                reportSet.add(rep);
            }
            System.out.println(reportSet.toString());

            /*피신고자별 신고자리스트 : 신고된사람 = {신고한사람}*/
            HashMap<String, ArrayList<String>> reportUsersMap = new HashMap<>();
            /*메일링 리스트 : 신고한사람=메일받을 횟수 **순서가 보장되어야 하므로 LINKEDHASHMAP*/
            LinkedHashMap<String, Integer> mailMap = new LinkedHashMap<>();

            for(int i=0; i<id_list.length; i++){
                String user_id = id_list[i];
                /*메일맵 초기화*/
                mailMap.put(user_id,0);
                System.out.println(mailMap.toString());
                /*신고한사람*/
                ArrayList<String> tempUserList = new ArrayList<>();
                for (String s : reportSet) {
                    String[] temp = s.split(" ");
                    String reporter = temp[0];
                    String reportee = temp[1];
                    if(user_id.equals(reportee)){
                        tempUserList.add(reporter);
                    }
                }
                reportUsersMap.put(user_id, tempUserList);
            }
            System.out.println("피신고자별 신고자리스트 : "+reportUsersMap);

        /*
        피신고자별 신고자리스트 : 신고된사람 = {신고한사람}
        1. 신고된 사람 만큼 반복
        2. {신고한 사람}이 차단기준횟수 초과인지 확인
        3. 초과자를 신고한 사람은 메일링 맵에 넣고 메일 카운트를 올림
        * */
            for(String key : reportUsersMap.keySet()){
                System.out.println("피신고자 : "+key);
                if(reportUsersMap.get(key).size() >= k){
                    System.out.println(k+"회 초과");
                    for(String key2 : reportUsersMap.get(key)){
                        mailMap.replace(key2,mailMap.get(key2)+1);
                        System.out.println(key2+"="+mailMap.get(key2));
                    }
                }
            }

            System.out.println("mailMap : "+mailMap.toString());

            int[] result = new int[mailMap.size()];
            for(int i=0; i<result.length; i++){
                result[i] = mailMap.get(id_list[i]);
            }

            System.out.println("result : "+Arrays.toString(result));


            return result;
        }

}
